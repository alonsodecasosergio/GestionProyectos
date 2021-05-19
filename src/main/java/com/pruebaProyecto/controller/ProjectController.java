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
		
		System.out.println("PROYECTO A MOSTRAR:" + projectMostrar.toString());
		
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
			
			System.out.println("HAY ERRORES DE VALIDACION");
			
		}else {
			
			//AÑADIDO DEL OBJETO A LA BASE DE DATOS
			projectService.addProyecto(project);
		}
		
		return "index";
	}
	
	@GetMapping("/del/{id}")
	public String deleteProyect(@PathVariable("id") int id) {
		
		System.out.println("BORRADO DEL PROJECTO: " + projectService.getById(id).toString());
		
		//BORRADO DEL PROJECTO SEGUN SU ID 
		projectService.deleteProyecto(id);
		
		
		return "redirect: /project";
		
	}
	
	@PostMapping("/update")
	public String updateProyect(@Valid @ModelAttribute Proyecto project, BindingResult bindingResult) {
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			System.out.println("HAY ERRORES DE VALIDACION");
			
		}else {
			System.out.println("EDITADO DEL PROJECTO: " + project.toString());
			
			//EDITADO DEL PRODUCTO
			projectService.updateProject(project);
		}
		
		return "index";
	}

}
