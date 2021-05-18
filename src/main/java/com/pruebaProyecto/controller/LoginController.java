package com.pruebaProyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebaProyecto.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("")
	public String view() {
		
		return "index";
	}
	
	@PostMapping("")
	public String validateLogin(Model model, @RequestParam(required = true) String email, @RequestParam(required = true) String password){
		
		if(usuarioService.checkUser(email, password)) {
			
			System.out.println("Usuario correcto");
		}
		
		
		return "index";
	}

}
