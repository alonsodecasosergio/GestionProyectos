package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.repository.ProyectoRepository;

@Service
public class ProyectService {
	
	@Autowired
	private ProyectoRepository repository;
	
	public void addProyecto(Proyecto proyect) {
		
		repository.save(proyect);
	}
	
	public void deleteProyecto(int id) {
		repository.deleteById(id);
	}
	
	public Proyecto getById(int id) {
		return repository.findById(id);
	}
	
	public void updateProject(Proyecto project) {
		
		repository.save(project);
	}

}
