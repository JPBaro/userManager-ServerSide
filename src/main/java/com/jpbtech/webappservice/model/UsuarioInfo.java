package com.jpbtech.webappservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usersdb")
public class UsuarioInfo {

	@NotEmpty(message = "Nombre es requerido!" )
	@Size(min = 2, max = 100)
	@Column(name = "name")
	private String nombre;

	@NotEmpty(message = "Apellidos son requeridos!" )
	@Size(max = 100, message = "Maximo 100 caracteres!")
	@Column(name = "familyname")
	private String apellidos;

	@Min(value = 18)@Max(value=70)	
	@Column(name = "age")
	private int edad; // cambiar a fecha nacimiento -> Today -FN = Edad

	@NotEmpty
	@Size(max = 50)
	@Email(message = "Formato de Email no valido! < ejemplo@company.org > " )
	@Column(name = "email", unique = true)
	private String email;

	@Id
	@NotEmpty(message = "Debe introducir <username> !")
	@Column(name = "username", unique = true)
	private String username;
	
	//@NotNull(message = "Debe si el usuario esta activo <1> o no activo <0>  !")
	@Column(name = "status")
	private int activo;

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

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
