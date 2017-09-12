package com.sg.katadomain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sg.kataapi.idomain.IDomain;
import com.sg.kataapi.irepository.IRepository;

@Component
public class ImplDomain implements IDomain {
	
	@Autowired
	private IRepository repo;

	public String businessDeposit(int amount) {
		if(amount>1000){
			return "Amount exceeds deposit limit, operation failed !";
		}
		else{
			repo.persistDeposit(amount);
			return "Operation success !";
		}
	}

}
