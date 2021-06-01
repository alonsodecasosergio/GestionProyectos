package com.pruebaProyecto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaProyecto.DTO.ProyectoDTO;
import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.CodigosError;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

import lombok.extern.log4j.Log4j;
@Log4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController implements CodigosError{
	
	@Autowired
	private ProyectService projectService;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/get/{id}")
	public Proyecto viewProyect(@PathVariable("id") int id, HttpSession sesion) {
		
		//MOSTRARIA EL PROYECTO AL QUE EL USUARIO PERTENECE
		return projectService.getById(id);
	}
	
	@GetMapping("proyectFromSession/{email}")
	public Proyecto viewProyectFromSession(@PathVariable("email") String email, HttpSession sesion) {
		
		Usuario user = usuarioService.getUserToEmail(email);
		
		//MOSTRARIA EL PROYECTO AL QUE EL USUARIO PERTENECE
		return user.getProyecto();
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
	public ProyectoDTO addProyect(@Valid @RequestBody Proyecto project, BindingResult bindingResult) {
		
		//FECHA FORMATO 2021/05/19
		
		ProyectoDTO proyectoDTO = null;
		
		//COMPROBACION DE QUE NO HAY ERRORES EN EL OBJETO
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_460[0]), CodigosError.COD_460[1], project);
			
		}else {
			
			//AÑADIDO DEL OBJETO A LA BASE DE DATOS
			if(projectService.addProyecto(project)) {
				proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_260[0]), CodigosError.COD_260[1], project);
			}else {
				proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_500[0]), CodigosError.COD_500[1], project);
			}
			
			
		}
		
		
		return proyectoDTO;
	}
	
	/**
	 * Metodo el cual elimina un proyecto segun el id recibido
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public ProyectoDTO deleteProyect(@PathVariable("id") int id) {
		
		
		//BORRADO DEL PROJECTO SEGUN SU ID 
		Proyecto project = projectService.getById(id);
		
		ProyectoDTO proyectoDTO = null;
		
		if(projectService.deleteProyecto(id)) {
			proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_261[0]), CodigosError.COD_261[1], project);
		}else {
			proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_461[0]), CodigosError.COD_461[1], project);
		}
		
		
		return proyectoDTO;
		
	}
	
	/**
	 * Metodo para actualizar un proyecto
	 * @param project
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ProyectoDTO updateProyect(@PathVariable("id") int id,@Valid @RequestBody Proyecto project, BindingResult bindingResult) {
		
		ProyectoDTO proyectoDTO = null;
		
		project.setId(id);
		
		//COMPROBACION DE LAS VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_463[0]), CodigosError.COD_463[1], project);
			
		}else {
			log.debug("EDITADO DEL PROJECTO: " + project.toString());
			
			//EDITADO DEL PRODUCTO
			if(projectService.updateProject(project)) {
				proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_263[0]), CodigosError.COD_263[1], project);
				
			}else {
				proyectoDTO = new ProyectoDTO(Integer.parseInt(CodigosError.COD_500[0]), CodigosError.COD_500[1], project);
			}
		}
		
		return proyectoDTO;
	}

}
