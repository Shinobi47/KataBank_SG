package com.sg.kataapi.interfaces;

import java.util.ArrayList;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;

public interface IRepository {
	public ArrayList<OperationBean> getOperations();
	public ClientBean getClient(String name, String password);
	public void persistDeposit(int amount);
	public void persistWithdraw(int amount);
	public int getBalance();
	
}
