package com.pruebaProyecto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaProyecto.DTO.UsuarioDTO;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.CodigosError;
import com.pruebaProyecto.service.UsuarioService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class LoginController extends CodigosError{
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("get/{email}")
	public Usuario getUserFromEmail(@PathVariable("email") String email, HttpSession sesion) {
		
		Usuario user = usuarioService.getUserToEmail(email);
		
		//MOSTRARIA EL PROYECTO AL QUE EL USUARIO PERTENECE
		return user;
	}
	
	/**
	 * Metodo el cual valida el acceso a la aplicacion mediante el email y la contraseña del usuario
	 * @param sesion
	 * @param model
	 * @param email Email de acceso
	 * @param password Password de acceso
	 * @return
	 */
	@PostMapping("/checked")
	public UsuarioDTO validateLogin(HttpSession sesion, Model model, @RequestBody UsuarioDTO u){
		
		UsuarioDTO userDTO = null;
		
		Usuario usuario = u.getUsuario();
		
		String email = usuario.getEmail();
		String password = usuario.getPassword();
		
		Usuario user = usuarioService.getUserToEmail(email);
		
		//COMRPOBACION DEL EMAIL Y CONTRASEÑA
		if(usuarioService.checkUser(email, password)) {
			
			//AL SER EL USUARIO CORRECTO SE CRERIA UNA SESSION CON EL			
			userDTO = new UsuarioDTO(Integer.parseInt(CodigosError.cod_281[0]), CodigosError.cod_281[1], user);
			log.info("Usuario conectado correctamente " + user.toString());
		}else {
			userDTO = new UsuarioDTO(Integer.parseInt(CodigosError.cod_483[0]), CodigosError.cod_483[1], user);
			log.info("Usuario incorrecto " + email + " | " + password);
		}
		
		return userDTO;
		
	}
	
	/**
	 * Metodo el cual registra un nuevo usuario en la aplicacion 
	 * @param idProject id del proyecto el cual se le asigna al usuario
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/register")
	public UsuarioDTO register(@Valid @RequestBody UsuarioDTO u, BindingResult bindingResult){
		
		UsuarioDTO userDTO = null;
		
		Usuario user = u.getUsuario();
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION AL CREAR EL USUARIO");
			userDTO = new UsuarioDTO(Integer.parseInt(CodigosError.cod_480[0]), CodigosError.cod_480[1], user);
			
		}else{
			//AÑADIDO DEL USUARIO
			usuarioService.addUsuario(user);
			log.info("Añadido del usuario: " + user.toString());
			userDTO = new UsuarioDTO(Integer.parseInt(CodigosError.cod_280[0]), CodigosError.cod_280[1], user);
		}
		
		return userDTO; 
	}
	
	/**
	 * Envio de todos los usuarios
	 * @return
	 */
	@GetMapping("/all")
	public List<Usuario> getAll(){
		return (List<Usuario>) usuarioService.getAll();
	}

}
