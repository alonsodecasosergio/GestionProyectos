package com.pruebaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaProyecto.model.Proyecto;



public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{

	Proyecto findById(int id);
	
}
