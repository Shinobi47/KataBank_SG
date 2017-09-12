package com.sg.katabank.katawebui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapp.service.App;
import com.sg.katabank.katawebui.dto.AuthDto;
import com.sg.katabank.katawebui.dto.OperationDto;


@Controller
public class TestController {
	

	//Authentification
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(ModelMap model) {
        model.addAttribute("msg", "variable msg :D ");
        return new ModelAndView("home", "authDto", new AuthDto());
    }
    
    // post authentification
    @RequestMapping(value = "/post_auth", method = RequestMethod.POST)
    public String post_auth(@ModelAttribute("authDto") AuthDto authDto, ModelMap model) {
    	
    	ApplicationContext context = 
	      new ClassPathXmlApplicationContext("ui-app-context.xml");
			 App app = (App)context.getBean(App.class);
			 
		ClientBean cb = app.getClient(authDto.getName(), authDto.getPassword());
		
		if(cb == null){
			model.addAttribute("msg", "Authentification failed ! no such client ...");
			return "operation_result";
		}
		else{
			return "authentified";
		}
    }
    
    //choosing opertation
    @RequestMapping(value = "/proceed", method = RequestMethod.POST)
    public ModelAndView proceed(@RequestParam String action, ModelMap model) {
    	
    	if(action.equals("Deposit")){
    		return new ModelAndView("deposit", "operationDto", new OperationDto());
    	}
    	else if (action.equals("Withdraw")){
    		return new ModelAndView("withdraw", "operationDto", new OperationDto());
    	}
    	else{
			ApplicationContext context = new ClassPathXmlApplicationContext("ui-app-context.xml");
			App app = (App) context.getBean(App.class);

			ArrayList<OperationBean> operations = app.getOperations();
			model.addAttribute("operations", operations);
			return new ModelAndView("history");
    	}
    }
    
    // make a deposit
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String deposit(@ModelAttribute("operationDto") OperationDto operationDto, ModelMap model) {
    	
    	ApplicationContext context = 
	      new ClassPathXmlApplicationContext("ui-app-context.xml");
			 App app = (App)context.getBean(App.class);
			 
		String amount = operationDto.getAmount();
		
		if(!amount.matches("\\d+(\\.\\d+)?")){
			model.addAttribute("msg", "Invalid amount");
			return "operation_result";
		}
		else{
			String result = app.makeDeposit(amount);
			model.addAttribute("msg", result);
			return "operation_result";
		}
    }
    
    // withdraw money
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdraw(@ModelAttribute("operationDto") OperationDto operationDto, ModelMap model) {
    	
    	ApplicationContext context = 
	      new ClassPathXmlApplicationContext("ui-app-context.xml");
			 App app = (App)context.getBean(App.class);
			 
		String amount = operationDto.getAmount();
		
		// check if the amount is numeric
		if(!amount.matches("\\d+(\\.\\d+)?")){
			model.addAttribute("msg", "Invalid amount");
			return "operation_result";
		}
		else{
			String result = app.withdrawMoney(amount);
			model.addAttribute("msg", result);
			return "operation_result";
		}
    }

}

