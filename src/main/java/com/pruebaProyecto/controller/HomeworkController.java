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

import com.pruebaProyecto.DTO.TareaDTO;
import com.pruebaProyecto.model.Tarea;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.CodigosError;
import com.pruebaProyecto.service.HomeworkService;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/homework")
public class HomeworkController{
	
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
	@GetMapping("/myHomework/{email}/{id}")
	public List<Tarea> myHomework(HttpSession sesion, @PathVariable("email") String email, @PathVariable("id") int id) {
		
		Usuario user = usuarioService.getUserToEmail(email);
		
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
	public TareaDTO addHomework(HttpSession sesion, @Valid @RequestBody TareaDTO t, BindingResult bindingResult) {
		
		//AÑADIRA UNA NUEVA TAREA
		TareaDTO tareaDTO = null;
		
		Tarea tarea = t.getTarea();
		
		
		//COMPROVACION DE VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_470[0]), CodigosError.cod_470[1], tarea);
			
		}else {
			
			if(homeworkService.addTarea(tarea)) {
				tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_270[0]), CodigosError.cod_270[1], tarea);
			}else {
				tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_500[0]), CodigosError.cod_500[1], tarea);
				log.error("Error al añadir la tarea: " + tarea.toString());
			}
		}
		
		return tareaDTO;
	}
	
	/**
	 * Borrado de una tarea segun el id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public TareaDTO deleteHomework(@PathVariable("id") int id) {
		
		TareaDTO tareaDTO = null;
		
		Tarea tarea = homeworkService.getTareaById(id);
		
		//BORRADO DE LA TAREA SEGUN SU ID 
		if(homeworkService.deleteTarea(id)) {
			tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_271[0]), CodigosError.cod_271[1], tarea);
		}else {
			tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_500[0]), CodigosError.cod_500[1], tarea);
		}
		
		return tareaDTO;
		
	}
	
	/**
	 * Actualizado de una tarea
	 * @param tarea
	 * @param bindingResult
	 * @return
	 */
	@PutMapping("/update/{id}")
	public TareaDTO updateHomework(@PathVariable("id") int id,@Valid @RequestBody TareaDTO t, BindingResult bindingResult) {
		
		TareaDTO tareaDTO = null;
		
		Tarea tarea = t.getTarea();
		
		tarea.setId(id);
		
		//COMPROVACION DE VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			log.error("HAY ERRORES DE VALIDACION");
			tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_473[0]), CodigosError.cod_473[1], tarea);
			
		}else {
			log.info("EDITADO DE LA TAREA: " + tarea.toString());
			
			//EDITADO DE LA TAREA
			if(homeworkService.updateTarea(tarea)) {
				tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_273[0]), CodigosError.cod_273[1], tarea);
			}else {
				tareaDTO = new TareaDTO(Integer.parseInt(CodigosError.cod_500[0]), CodigosError.cod_500[1], tarea);
			}
		}
		
		return tareaDTO;
	}

}
