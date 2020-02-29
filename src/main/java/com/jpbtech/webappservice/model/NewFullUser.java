package com.jpbtech.webappservice.model;


public class NewFullUser extends UserModel{
		
	private String password;

	public NewFullUser() {
		super();
	}
	public String getPassword() {
		
		return this.password;
	}
		
	public void setPassword(String password) {
		
		this.password=password;
		
	}
	
	
	
	

}
