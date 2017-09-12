package com.sg.katabank.katawebui.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapp.service.App;

import antlr.StringUtils;

@Controller
public class TestController {
	
//	@Autowired
//	Boot boot;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(ModelMap model) {
        model.addAttribute("msg", "variable msg :D ");
        return new ModelAndView("home", "authDto", new AuthDto());
    }
    
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
    
    @RequestMapping(value = "/proceed", method = RequestMethod.POST)
    public ModelAndView proceed(@RequestParam String action, ModelMap model) {
    	
    	if(action.equals("Deposit")){
    		return new ModelAndView("deposit", "operationDto", new OperationDto());
    	}
    	else if (action.equals("Withdraw")){
    		return new ModelAndView("home");
    	}
    	else{
			ApplicationContext context = new ClassPathXmlApplicationContext("ui-app-context.xml");
			App app = (App) context.getBean(App.class);

			ArrayList<OperationBean> operations = app.getOperations();
			model.addAttribute("operations", operations);
			return new ModelAndView("history");
    	}
//        model.addAttribute("msg", "variable msg :D ");
//        return new ModelAndView("home", "authDto", new AuthDto());
    }
    
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
    
    
    
    @RequestMapping(value = "/testmsg/{msg}", method = RequestMethod.GET)
    public String displayMessage(@PathVariable String nom, ModelMap model) {
        model.addAttribute("msg", "zis");
        return "test1";
    }
    
    
    
    
//    
//    @RequestMapping(value = "/testjson/{msg}", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody ProduitBean displayJSON(@PathVariable String msg, ModelMap model) {
//
//    	ProduitBean p = new ProduitBean();
//    	p.setLibelleProduit(msg);
//        model.addAttribute("msg", msg);
//        return p;
//    }
//    
//    @RequestMapping(value = "/prod", method = RequestMethod.GET)
//    public String displayList(ModelMap model) {
//    	ApplicationContext context = 
//    		      new ClassPathXmlApplicationContext("ui-app-context.xml");
//    				 App app = (App)context.getBean(App.class);
//    	
//    	ArrayList<ProduitBean> produits = app.getProduits();
//        model.addAttribute("produits", produits);
//        return "produits";
//    }
//    
//    @RequestMapping(value = "/achat/{idprd}", method = RequestMethod.GET)
//    public String displayVente(@PathVariable String idprd, ModelMap model) {
//        	ApplicationContext context = 
//        		      new ClassPathXmlApplicationContext("ui-app-context.xml");
//        				 App app = (App)context.getBean(App.class);
//        				 
//        				 app.acheterProduit(Integer.parseInt(idprd));
//        ArrayList<ProduitBean> produits = app.getProduits();
//        model.addAttribute("produits", produits);
//    	return "produits";
//    }

}

