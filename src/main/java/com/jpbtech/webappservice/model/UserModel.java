package com.jpbtech.webappservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Create standard entity for DB. Pending to review if using @jsonIgnore in
 * service is enough to avoid getting passw on request or another entity for
 * response should be created
 * 
 * @author jpb
 *
 */

@Entity
@Table(name = "usersdb")
public class UserModel {
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "username")
	@JoinColumn(name = "username", referencedColumnName = "usernamek")
	private String username;
	
	//@Column(name = "username")
	//private String username;

	/*
	 * @OneToOne(mappedBy="username") private NameAndPassw nameNpass;
	 */
	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "nombre")
	private String nombre;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "apellidos")
	private String apellidos;

	@NotNull
	@Column(name = "edad")
	private int edad; // cambiar a fecha nacimiento -> Today -FN = Edad

	@Id
	@NotEmpty
	@Size(max = 50)
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "activo")
	private Boolean activo;

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
