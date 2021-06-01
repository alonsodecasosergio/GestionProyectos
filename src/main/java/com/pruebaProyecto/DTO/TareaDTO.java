package com.pruebaProyecto.DTO;

import com.pruebaProyecto.model.Tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TareaDTO {
	
	private int codigo;
	private String mensaje;
	private Tarea tarea;

}
