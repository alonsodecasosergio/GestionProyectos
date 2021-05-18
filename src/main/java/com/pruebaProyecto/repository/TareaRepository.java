package com.pruebaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Tarea;



public interface TareaRepository extends JpaRepository<Tarea, Integer>{
	
	Tarea findById(int id);
	Iterable<Tarea> findByProyecto(Proyecto proyect);

}
