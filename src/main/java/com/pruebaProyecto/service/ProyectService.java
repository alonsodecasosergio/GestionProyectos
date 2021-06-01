package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.repository.ProyectoRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ProyectService {
	
	@Autowired
	private ProyectoRepository repository;
	
	/**
	 * Metodo para añadir un proyecto
	 * @param proyect
	 */
	public void addProyecto(Proyecto proyect) {
		
		log.debug("AÑADIDO DEL PROYECTO: " + proyect.toString());
		repository.save(proyect);
	}
	
	/**
	 * Metodo para obtener todos los proyectos
	 * @return
	 */
	public Iterable<Proyecto> getAll(){

		log.debug("OBTENCION DE TODOS LOS PROYECTOS");
		return repository.findAll();
	}
	
	/**
	 * Metodo para borrar un proyecto
	 * @param id
	 */
	public void deleteProyecto(int id) {
		
		log.debug("BORRADO DEL PROYECTO: " + getById(id).toString());
		repository.deleteById(id);
		
	}
	
	/**
	 * Metodo para obtener un proyecto
	 * @param id
	 * @return
	 */
	public Proyecto getById(int id) {

		log.debug("OBTENCION DEL PROYECTO CON ID: " + id);
		return repository.findById(id);
	}
	
	/**
	 * Metodo para actualizar un proyecto
	 * @param project
	 */
	public void updateProject(Proyecto project) {
		
		log.debug("ACTUALIZACION DEL PROYECTO: " + project.toString());
		repository.save(project);
	}

}
