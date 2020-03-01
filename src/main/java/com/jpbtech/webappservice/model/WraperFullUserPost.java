package com.jpbtech.webappservice.model;

/**
 * 
 * @implNote class Wrapper which host: {@link UserModel} && {@link NameAndPassw} 
 *
 * @author Joaquin Pampin
 */
public class WraperFullUserPost extends UserModel {

	UserModel user;
	NameAndPassw credenciales;

	/**
	 * @param user
	 * @param credentials
	 */
	public WraperFullUserPost(UserModel user, NameAndPassw credentials) {
		//Constructor
		
		super();
		this.user = user;
		this.credenciales = credentials;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public NameAndPassw getCredentials() {
		return credenciales;
	}
	public void setCredentials(NameAndPassw credenciales) {
		this.credenciales = credenciales;
	}

}
