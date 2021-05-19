package com.pruebaProyecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Proyecto proyecto;
	
	@Email(message="Debe ser una dirección de correo electrónico con formato correcto")
	@NotBlank(message="El email es obligatorio")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message="El nombre es obligatorio")
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank(message="La contraseña es obligatoria")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message="Los apellidos son obligatorios")
	@Column(name = "apellidos")
	private String apellidos;
	
}
