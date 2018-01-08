package com.sg.kataapi.dto;

public class OperationBean {

	private int idOperation;
	private String operationName;
	private String operationDate;
	private int amount;
	private int balance;
	private ClientBean client;
	
	
	
	public OperationBean() {
		super();
	}

	public OperationBean(int idOperation, String operationName, ClientBean client) {
		super();
		this.idOperation = idOperation;
		this.operationName = operationName;
		this.client = client;
	}


	public int getIdOperation() {
		return idOperation;
	}


	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}


	public String getOperationName() {
		return operationName;
	}


	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	
}
