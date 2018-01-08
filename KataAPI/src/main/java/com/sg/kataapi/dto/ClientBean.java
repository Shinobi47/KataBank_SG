package com.sg.kataapi.dto;


public class ClientBean {

	private int idClient;
	private String clientName;
	private String clientPassword;
	public ClientBean() {
		super();
	}
	public ClientBean(int idClient, String clientName, String clientPassword) {
		super();
		this.idClient = idClient;
		this.clientName = clientName;
		this.clientPassword = clientPassword;
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
	@Override
	public String toString() {
		return "ClientBean [idClient=" + idClient + ", clientName=" + clientName + ", clientPassword=" + clientPassword
				+ "]";
	}
	
	

}
