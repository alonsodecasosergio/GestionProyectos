package com.pruebaProyecto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.pruebaProyecto.model.Tarea;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.HomeworkService;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/homework")
public class HomeworkController {
	
	@Autowired
	private ProyectService projectService;
	@Autowired
	private HomeworkService homeworkService;
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Metodo el cual devolvera las tareas del proyecto
	 * @param id id del proyecto del que se quiere ver las tareas
	 * @return
	 */
	@GetMapping("/{id}")
	public List<Tarea> viewHomework(@PathVariable("id") int id) {
		
		//MOSTRARIA TODAS LAS TAREAS DE ESE PROYECTO
		List<Tarea> homeworks = (List<Tarea>) homeworkService.getAllByProyecto(projectService.getById(id));
		
		return homeworks;
		
	}
	
	/**
	 * Metodo el cual devuelve las tareas solo del usuario el cual este conectado
	 * @param sesion
	 * @param id id del proyecto del que ver las tareas
	 * @return
	 */
	@GetMapping("/myHomework/{id}")
	public List<Tarea> myHomework(HttpSession sesion, @PathVariable("id") int id) {
		
		//Usuario user = (Usuario) sesion.getAttribute("usuario");
		Usuario user = usuarioService.getById(1);
		
		//MOSTRARIA LAS TAREAS DE ESE PROYECTO DEL USUARIO CONECTADO
		//RECOGIENDO EL ID DEL PROJECTO
		List<Tarea> homeworks = (List<Tarea>) homeworkService.getAllByUsuarioAndProyecto(user, projectService.getById(id));
		
		return homeworks;
	}
	
	/**
	 * Paso de una tarea segun su id
	 * 
	 * @param sesion
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public Tarea getTarea(HttpSession sesion, @PathVariable("id") int id) {
		
		Tarea tarea = homeworkService.getTareaById(id);
		
		return tarea;
	}
	
	/**
	 * Añadido de una nueva tarea 
	 * @param sesion 
	 * @param tarea 
	 * @param bindingResult 
 	 * @return
	 */
	@PostMapping("/add")
	public Tarea addHomework(HttpSession sesion, @Valid @RequestBody Tarea tarea, BindingResult bindingResult) {
		
		//AÑADIRA UNA NUEVA TAREA
		
		System.out.println(tarea.toString());
		
		//COMPROVACION DE VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			
			homeworkService.addTarea(tarea);
			
			log.debug("AÑADIDO DE LA NUEVA TAREA: " + tarea.toString());
		}
		
		return tarea;
	}
	
	/**
	 * Borrado de una tarea segun el id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public Tarea deleteHomework(@PathVariable("id") int id) {
		
		Tarea t = homeworkService.getTareaById(id);
		//BORRADO DE LA TAREA SEGUN SU ID 
		homeworkService.deleteTarea(id);
		
		return t;
		
	}
	
	/**
	 * Actualizado de una tarea
	 * @param tarea
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Tarea updateHomework(@PathVariable("id") int id,@Valid @RequestBody Tarea tarea, BindingResult bindingResult) {
		
		tarea.setId(id);
		
		//COMPROVACION DE VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			
		}else {
			log.debug("EDITADO DE LA TAREA: " + tarea.toString());
			
			//EDITADO DE LA TAREA
			homeworkService.updateTarea(tarea);
		}
		
		return tarea;
	}

}
