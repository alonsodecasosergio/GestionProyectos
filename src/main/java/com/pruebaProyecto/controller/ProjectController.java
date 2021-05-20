package com.pruebaProyecto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.ProyectService;

import lombok.extern.log4j.Log4j;
@Log4j
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProyectService projectService;
	
	@GetMapping("")
	public Proyecto viewProyect(HttpSession sesion) {
		
		//MOSTRARIA EL PROYECTO AL QUE EL USUARIO PERTENECE
		
		Usuario userConnected = (Usuario) sesion.getAttribute("usuario");
		Proyecto projectMostrar = userConnected.getProyecto();
		
		return projectMostrar;
	}
	
	/**
	 * Metodo el cual mostrara todos los proyectos extraidos de la base de datos
	 * @param sesion
	 * @return
	 */
	@GetMapping("/all")
	public List<Proyecto> viewAllProyect(HttpSession sesion) {
		
		//MOSTRARIA TODOS LOS PROYECTOS
		return (List<Proyecto>) projectService.getAll();
	}
	
	/**
	 * Metodo el cual añade un nuevo proyecto
	 * @param project
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/add")
	public Proyecto addProyect(@Valid @RequestBody Proyecto project, BindingResult bindingResult) {
		
		//FECHA FORMATO 2021/05/19
		System.out.println(project.toString());
		
		//COMPROBACION DE QUE NO HAY ERRORES EN EL OBJETO
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			
			//AÑADIDO DEL OBJETO A LA BASE DE DATOS
			projectService.addProyecto(project);
		}
		
		return project;
	}
	
	/**
	 * Metodo el cual elimina un proyecto segun el id recibido
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public Proyecto deleteProyect(@PathVariable("id") int id) {
		
		
		//BORRADO DEL PROJECTO SEGUN SU ID 
		Proyecto project = projectService.getById(id);
		projectService.deleteProyecto(id);
		
		
		return project;
		
	}
	
	/**
	 * Metodo para actualizar un proyecto
	 * @param project
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/update")
	public Proyecto updateProyect(@Valid @RequestBody Proyecto project, BindingResult bindingResult) {
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			log.debug("EDITADO DEL PROJECTO: " + project.toString());
			
			//EDITADO DEL PRODUCTO
			projectService.updateProject(project);
		}
		
		return project;
	}

}
