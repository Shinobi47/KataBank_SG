package com.sg.kataapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapi.interfaces.IDomain;
import com.sg.kataapi.interfaces.IRepository;

public class App {
	
	@Autowired
	private IRepository repo;
	
	@Autowired
	private IDomain domain;
	
	private ArrayList<OperationBean> operations;
	
	public App(){
		
	}
	
	public ArrayList<OperationBean> getOperations(){
		operations = repo.getOperations();
		return operations;
	}
	
	public ClientBean getClient(String name, String password){
		return repo.getClient(name, password);
	}
	
	public String makeDeposit(String amount){
		return domain.businessDeposit(Integer.parseInt(amount));
	}
	
	public String withdrawMoney(String amount){
		return domain.businessWithdraw(Integer.parseInt(amount));
	}
	

}
