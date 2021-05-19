package com.pruebaProyecto.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.service.ProyectService;
@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProyectService projectService;
	
	@GetMapping("")
	public String view(HttpSession sesion) {
		
		return "index";
	}
	
	@PostMapping("/add")
	public String add(@Valid @ModelAttribute Proyecto project, BindingResult bindingResult) {
		
		//FECHA FORMATO 2021/05/19
		System.out.println(project.toString());
		
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("HAY ERRORES DE VALIDACION");
			
		}else {
			
			projectService.addProyecto(project);
		}
		
		return "index";
	}

}
