package com.pruebaProyecto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Proyecto proyecto;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	public Usuario() {
		
	}

	public Usuario(Proyecto proyecto, String email, String nombre, String password, String apellidos) {
		super();
		this.proyecto = proyecto;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", proyecto=" + proyecto + ", email=" + email + ", nombre=" + nombre
				+ ", password=" + password + ", apellidos=" + apellidos + "]";
	}
	
	

	
}
