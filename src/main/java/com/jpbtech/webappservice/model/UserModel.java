package com.jpbtech.webappservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class UserModel extends Object{
	
	@Id	
	@Column(name = "username",unique = true)
	private String username;
		
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
	
	@JsonIgnore
	@Size(min = 6, max = 100)
	@Column(name = "password")
	private String password;
	
	@Column(name = "activo")
	private Boolean activo;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


}
