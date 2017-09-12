package com.sg.kataapi.irepository;

import java.util.ArrayList;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;

public interface IRepository {
	public ArrayList<OperationBean> getOperations();
	public ClientBean getClient(String name, String password);
	public void persistDeposit(int amount);
	
}
