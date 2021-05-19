package com.pruebaProyecto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "tareas")
public class Tarea {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Proyecto proyecto;
	
	@ManyToOne
	private Usuario usuario;
	
	@NotBlank(message="El nombre es obligatorio")
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank(message="La descripción es obligatoria")
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;

}
