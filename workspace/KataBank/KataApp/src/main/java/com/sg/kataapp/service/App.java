package com.sg.kataapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapi.idomain.IDomain;
import com.sg.kataapi.irepository.IRepository;

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
	
	

}
