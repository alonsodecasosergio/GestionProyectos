package com.pruebaProyecto.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class LoginController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProyectService proyectService;
	
	@GetMapping("")
	public String view() {
		
		return "index";
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
	public Usuario validateLogin(HttpSession sesion, Model model, @RequestBody Usuario usuario){
		
		String email = usuario.getEmail();
		String password = usuario.getPassword();
		
		Usuario user = usuarioService.getUserToEmail(email);
		
		//COMRPOBACION DEL EMAIL Y CONTRASEÑA
		if(usuarioService.checkUser(email, password)) {
			
			
			//AL SER EL USUARIO CORRECTO SE CRERIA UNA SESSION CON EL
			sesion.setAttribute("usuario", user);
			
			return user;
		}
		user.setEmail("");
		return user;
		
	}
	
	/**
	 * Metodo el cual registra un nuevo usuario en la aplicacion 
	 * @param idProject id del proyecto el cual se le asigna al usuario
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/register")
	public Usuario register(@Valid @RequestBody Usuario user, BindingResult bindingResult){
		
		System.out.println(user.toString());
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION AL CREAR EL USUARIO");
			
		}else{
			//AÑADIDO DEL USUARIO
			usuarioService.addUsuario(user);
			log.debug("Añadido del usuario: " + user.toString());
		}
		
		return user; 
	}

}
