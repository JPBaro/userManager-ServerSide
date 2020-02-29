package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table (name="userskeys")
public class NameAndPassw {

	public NameAndPassw() {}
	
	public NameAndPassw(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password=password;	
	}
	
	@Id	
	@Column(name = "username",unique = true)
	private String username;
	
	/*
	 * @OneToOne private UserModel user;
	 */
	@Size(min = 6, max = 20)
	@Column(name = "password")
	private String password;

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
