package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Class to hold <b>username</b> && <b>password</b> in separate table "userskeys" for future auth.
 * {@code}
 * @author jpb
 *
 */

@Entity
@Table (name="userskeys")
public class NameAndPassw {
	
		
	@OneToOne(mappedBy = "username")
	private String userModel;
	@Id
	@Column(name = "usernamek")
	private String username;
	
	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "password")
	private String password;

	public String getUsernamek() {		
		return username;
	}

	public void setUsernamek(String username) {
		this.username = username;
		//userModel.setUsername(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
