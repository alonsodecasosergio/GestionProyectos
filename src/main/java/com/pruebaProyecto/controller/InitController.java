package com.pruebaProyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class InitController {
	
	@GetMapping("")
	public String inicio() {
		
		System.out.println("Conntroler");
		
		return "index";
	}

}
