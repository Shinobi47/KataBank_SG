package com.sg.katainfra.hibernate.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cli")
public class Client {
	
	@Id
	@Column(name = "idCLI")
	private int idClient;
	
	@Column(name = "cli_name")
	private String clientName;
	
	@Column(name = "cli_pwd")
	private String clientPassword;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private List<Operation> operations;

	
	public Client() {
		super();
	}
	
	public Client(String clientName, String clientPassword, List<Operation> operations) {
		super();
		this.clientName = clientName;
		this.clientPassword = clientPassword;
		this.operations = operations;
	}


	public Client(int idClient, String clientName, String clientPassword, List<Operation> operations) {
		super();
		this.idClient = idClient;
		this.clientName = clientName;
		this.clientPassword = clientPassword;
		this.operations = operations;
	}
	
	


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getClientPassword() {
		return clientPassword;
	}


	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}


	public List<Operation> getOperations() {
		return this.operations;
	}


	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}


	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", clientName=" + clientName + ", clientPassword=" + clientPassword
				+ ", Operations=" + operations + "]";
	}

	
}
