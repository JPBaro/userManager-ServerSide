package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table (name="userskeys")
public class PassKeyUsers {
	
	@Id
	@Column(name = "username",unique = true)
	private String username;
	
	@NotEmpty
	@Column(name = "password")
	private String password;

	public PassKeyUsers() {}
	
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
