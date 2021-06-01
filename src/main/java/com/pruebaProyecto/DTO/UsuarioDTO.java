package com.pruebaProyecto.DTO;

import com.pruebaProyecto.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO{
	
	private int codigo;
	private String mensaje;
	private Usuario usuario;

}
