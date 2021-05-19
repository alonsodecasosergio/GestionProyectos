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
	
	public void addTarea(Tarea tarea) {
		
		repository.save(tarea);
		log.debug("AÑADIDO DE LA TAREA: " + tarea.toString());
		
	}
	
	public void deleteTarea(int id) {
		
		repository.deleteById(id);
		log.debug("BORRADO DE LA TAREA " + getTareaById(id).toString());
	}
	
	public void updateTarea(Tarea tarea) {
		repository.save(tarea);
		log.debug("ACTUALIZACION DE LA TAREA: " + tarea.toString());
	}
	
	public Tarea getTareaById(int id) {
		log.debug("OBTENCION DE LA TAREA CON ID: " + id);
		return repository.findById(id);
	}
	
	public Iterable<Tarea> getAll(){
		log.debug("OBTENCION DE TODAS LAS TAREAS");
		return repository.findAll();
	}
	
	public Iterable<Tarea> getAllByProyecto(Proyecto proyect){
		log.debug("OBTENCION DE TODAS LAS TAREAS DEL PROYECTO: " + proyect.toString());
		return repository.findByProyecto(proyect);
	}
	
	public Iterable<Tarea> getAllByUsuarioAndProyecto(Usuario user, Proyecto project){
		log.debug("OBTENCION DE LAS TAREAS DEL USUARIO: " + user.toString() + " EN EL PROYECTO: " + project.toString());
		return repository.findByUsuarioAndProyecto(user, project);
	}
}
