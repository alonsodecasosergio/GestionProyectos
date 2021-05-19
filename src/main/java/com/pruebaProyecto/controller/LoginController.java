package com.pruebaProyecto.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

@Controller
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
	
	@PostMapping("/checked")
	public String validateLogin(HttpSession sesion, Model model, @RequestParam(required = true) String email, @RequestParam(required = true) String password){
		
		//COMRPOBACION DEL EMAIL Y CONTRASEÑA
		if(usuarioService.checkUser(email, password)) {
			
			System.out.println("Usuario correcto");
			
			//AL SER EL USUARIO CORRECTO SE CRERIA UNA SESSION CON EL
			sesion.setAttribute("usuario", usuarioService.getUserToEmail(email));
			
			return "redirect: /project";
		}
		
		return "redirect: /login";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam(required = true) int idProject,@Valid  @ModelAttribute Usuario user, BindingResult bindingResult){
		
		//AÑADIDO DEL PROJECTO AL USUARIO
		user.setProyecto(proyectService.getById(idProject));
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			System.out.println("HAY ERRORES DE VALIDACION AL CREAR EL USUARIO");
			
		}else{
			//AÑADIDO DEL USUARIO
			usuarioService.addUsuario(user);
			System.out.println("Añadido del usuairo: " + user.toString());
		}
		
		return "redirect: /login";
	}

}
