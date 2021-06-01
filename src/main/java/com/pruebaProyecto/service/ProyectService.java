package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.repository.ProyectoRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ProyectService{
	
	@Autowired
	private ProyectoRepository repository;
	
	/**
	 * Metodo para añadir un proyecto
	 * @param proyect
	 * @return booleano indicando si se ha guardado ha ido correctamente
	 */
	public boolean addProyecto(Proyecto proyect) {
		
		boolean correcto = true;
		
		log.info("AÑADIDO DEL PROYECTO: " + proyect.toString());
		
		try {
			repository.save(proyect);
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
		
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
	 * @return devuelve si el borrado ha sido correcto
	 */
	public boolean deleteProyecto(int id) {
		
		boolean correcto = true;
		
		log.info("BORRADO DEL PROYECTO: " + getById(id).toString());
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
		
		
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
	public boolean updateProject(Proyecto project) {
		
		boolean correcto = true;
		
		log.info("ACTUALIZACION DEL PROYECTO: " + project.toString());
		
		try {
			repository.save(project);
		}catch(Exception e) {
			correcto = false;
		}
		
		return correcto;
	}

}
