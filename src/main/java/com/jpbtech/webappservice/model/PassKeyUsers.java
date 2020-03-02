package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table (name="userskeys")
public class PassKeyUsers {
	
	@Id
	@Column(name = "username",unique = true)
	private String username;
	
	@NotEmpty(message = "Password necesario!")
	@Size(min = 8, message = "Password de 8 a N caracteres")
	@Column(name = "password")
	private String password;

	public PassKeyUsers() {}
	
	public PassKeyUsers(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {		
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
