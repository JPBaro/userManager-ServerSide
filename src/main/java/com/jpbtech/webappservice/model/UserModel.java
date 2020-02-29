package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Create standard entity for DB. Pending to review 
 * if using @jsonIgnore in service
 * is enough to avoid getting passw on request 
 * or another entity for response should be created 
 * @author jpb
 *
 */

@Entity
@Table (name="usersdb")
public class UserModel{
	
	@Id	
	@Column(name = "username",unique = true)
	private String username;
	
	/*
	 * @OneToOne(mappedBy="username") private NameAndPassw nameNpass;
	 */
	
	@Size(min = 2, max = 100)
	@Column(name = "nombre")
	private String nombre;

	
	@Size(max = 100)
	@Column(name = "apellidos")
	private String apellidos;

	
	@Column(name = "edad")
	private int edad; //cambiar a fecha nacimiento -> Today -FN = Edad
	
	@Size(max = 50)
	@Column(name = "email",unique = true)
	private String email;
	
		
	@Column(name = "activo")
	private Boolean activo;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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
