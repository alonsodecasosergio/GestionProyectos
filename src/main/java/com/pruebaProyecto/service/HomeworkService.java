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
	 */
	public void addTarea(Tarea tarea) {
		
		repository.save(tarea);
		log.debug("AÑADIDO DE LA TAREA: " + tarea.toString());
		
	}
	
	/**
	 * Metodo para borrar una tarea
	 * @param id
	 */
	public void deleteTarea(int id) {
		
		repository.deleteById(id);
		log.debug("BORRADO DE LA TAREA " + getTareaById(id).toString());
	}
	
	/**
	 * Metodo para actualizar una tarea
	 * @param tarea
	 */
	public void updateTarea(Tarea tarea) {
		repository.save(tarea);
		log.debug("ACTUALIZACION DE LA TAREA: " + tarea.toString());
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
