package com.pruebaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaProyecto.model.Proyecto;


/**
 * Interfaz para los metodos CRUD sobre el modelo de Proyecto
 * @author Formacion
 *
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{

	Proyecto findById(int id);
	
}
