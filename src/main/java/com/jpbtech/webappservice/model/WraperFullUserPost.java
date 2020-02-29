package com.jpbtech.webappservice.model;


public class WraperFullUserPost{
	
	UserModel user;
	NameAndPassw credentials;
	public WraperFullUserPost(UserModel user, NameAndPassw credentials) {
		super();
		this.user = user;
		this.credentials = credentials;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public NameAndPassw getCredentials() {
		return credentials;
	}
	public void setCredentials(NameAndPassw credentials) {
		this.credentials = credentials;
	}
	
	
	
}
