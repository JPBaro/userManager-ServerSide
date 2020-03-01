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
public class UsernameAndPassw {
	
	@Id
	@Column(name = "username")
	private String username;
	
	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "password")
	private String password;

	
	public UsernameAndPassw(String username, @NotEmpty @Size(min = 6, max = 20) String password) {
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
