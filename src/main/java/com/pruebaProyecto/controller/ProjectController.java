package com.pruebaProyecto.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.ProyectService;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProyectService projectService;
	
	@GetMapping("")
	public String viewProyect(HttpSession sesion) {
		
		//MOSTRARIA EL PROYECTO AL QUE EL USUARIO PERTENECE
		
		Usuario userConnected = (Usuario) sesion.getAttribute("usuario");
		Proyecto projectMostrar = userConnected.getProyecto();
		
		return "index";
	}
	
	@GetMapping("/all")
	public String viewAllProyect(HttpSession sesion) {
		
		//MOSTRARIA TODOS LOS PROYECTOS
		ArrayList<Proyecto> proyects = (ArrayList<Proyecto>) projectService.getAll();
		
		for(Proyecto p : proyects) {
			
			System.out.println(p.toString());
			
		}
		
		return "index";
	}
	
	@PostMapping("/add")
	public String addProyect(@Valid @ModelAttribute Proyecto project, BindingResult bindingResult) {
		
		//FECHA FORMATO 2021/05/19
		System.out.println(project.toString());
		
		//COMPROBACION DE QUE NO HAY ERRORES EN EL OBJETO
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			
			//AÑADIDO DEL OBJETO A LA BASE DE DATOS
			projectService.addProyecto(project);
		}
		
		return "index";
	}
	
	@GetMapping("/del/{id}")
	public String deleteProyect(@PathVariable("id") int id) {
		
		
		//BORRADO DEL PROJECTO SEGUN SU ID 
		projectService.deleteProyecto(id);
		
		
		return "redirect: /project";
		
	}
	
	@PostMapping("/update")
	public String updateProyect(@Valid @ModelAttribute Proyecto project, BindingResult bindingResult) {
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			log.debug("EDITADO DEL PROJECTO: " + project.toString());
			
			//EDITADO DEL PRODUCTO
			projectService.updateProject(project);
		}
		
		return "index";
	}

}
