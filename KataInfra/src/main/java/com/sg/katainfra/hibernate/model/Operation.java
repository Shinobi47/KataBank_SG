package com.sg.katainfra.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ope")
public class Operation {

	@Id
	@Column(name = "id_op")
	private int idOperation;

	@Column(name = "op_name")
	private String operationName;
	
	@Column(name = "ope_date")
	private String operationDate;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "balance")
	private int balance;

	@ManyToOne
	@JoinColumn(name = "fk_idCLI")
	private Client client;

	public Operation() {
		super();
	}

	public Operation(String operationName, Client client) {
		super();
		this.operationName = operationName;
		this.client = client;
	}

	public Operation(int idOperation, String operationName, Client client) {
		super();
		this.idOperation = idOperation;
		this.operationName = operationName;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Operation [idOperation=" + idOperation + ", operationName=" + operationName + ", client=" + client
				+ "]";
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
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
