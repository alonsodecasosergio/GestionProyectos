package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Tarea;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.repository.TareaRepository;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class HomeworkService {

	@Autowired
	private TareaRepository repository;
	
	/**
	 * Metodo para añadir una tarea
	 * @param tarea
	 * @return informa de si el resultado ha sido correcto
	 */
	public boolean addTarea(Tarea tarea) {
		
		boolean correcto = true;
		
		log.info("AÑADIDO DE LA TAREA: " + tarea.toString());
		
		try {
			repository.save(tarea);	
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
		
	}
	
	/**
	 * Metodo para borrar una tarea
	 * @param id
	 * @return resultado de la operacion
	 */
	public boolean deleteTarea(int id) {
		
		boolean correcto = true;
		
		log.debug("BORRADO DE LA TAREA CON ID: " + id);
		
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
		
	}
	
	/**
	 * Metodo para actualizar una tarea
	 * @param tarea
	 * @return resultado de la operacion
	 */
	public boolean updateTarea(Tarea tarea) {
		
		boolean correcto = true;
		log.info("ACTUALIZACION DE LA TAREA: " + tarea.toString());
		try {
			repository.save(tarea);
			
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
	}
	
	/**
	 * Metodo para obtener una tarea
	 * @param id
	 * @return
	 */
	public Tarea getTareaById(int id) {
		log.debug("OBTENCION DE LA TAREA CON ID: " + id);
		return repository.findById(id);
	}
	
	/**
	 * Metodo para obtener todas las tareas
	 * @return
	 */
	public Iterable<Tarea> getAll(){
		log.debug("OBTENCION DE TODAS LAS TAREAS");
		return repository.findAll();
	}
	
	/**
	 * Metodo para obtener todas las tareas de un proyecto
	 * @param proyect
	 * @return
	 */
	public Iterable<Tarea> getAllByProyecto(Proyecto proyect){
		log.debug("OBTENCION DE TODAS LAS TAREAS DEL PROYECTO: " + proyect.toString());
		return repository.findByProyecto(proyect);
	}
	
	/**
	 * Metodo para obtener las tareas segun el usuario y proyecto
	 * @param user
	 * @param project
	 * @return
	 */
	public Iterable<Tarea> getAllByUsuarioAndProyecto(Usuario user, Proyecto project){
		log.debug("OBTENCION DE LAS TAREAS DEL USUARIO: " + user.toString() + " EN EL PROYECTO: " + project.toString());
		return repository.findByUsuarioAndProyecto(user, project);
	}
}
