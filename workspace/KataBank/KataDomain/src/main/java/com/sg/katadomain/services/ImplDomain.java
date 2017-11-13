package com.sg.katadomain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sg.kataapi.interfaces.IDomain;
import com.sg.kataapi.interfaces.IRepository;

@Component
public class ImplDomain implements IDomain {
	
	@Autowired
	private IRepository repo;

	public String businessDeposit(int amount) {
		if(amount>1300){
			return "Amount exceeds deposit limit ! operation failed !";
		}
		else{
			repo.persistDeposit(amount);
			return "Operation success !";
		}
	}
	
	public String businessWithdraw(int amount) {
		
		if(repo.getBalance() - amount < 0){
			return "You are a poor guy ! Operatin Failed !";
		}
		else{
			repo.persistWithdraw(amount);
			return "Operation success !";
		}
	}

}
