package com.pruebaProyecto.DTO;

import com.pruebaProyecto.model.Proyecto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProyectoDTO {
	private int codigo;
	private String mensaje;
	private Proyecto proyecto;

}
