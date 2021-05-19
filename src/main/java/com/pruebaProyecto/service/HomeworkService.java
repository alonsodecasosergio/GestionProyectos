package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.model.Tarea;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.repository.TareaRepository;


@Service
public class HomeworkService {

	@Autowired
	private TareaRepository repository;
	
	public void addTarea(Tarea tarea) {
		
		repository.save(tarea);
		
	}
	
	public void deleteTarea(int id) {
		
		repository.deleteById(id);
	}
	
	public Tarea getTareaById(int id) {
		return repository.findById(id);
	}
	
	public Iterable<Tarea> getAll(){
		
		return repository.findAll();
	}
	
	public Iterable<Tarea> getAllByProyecto(Proyecto proyect){
		
		return repository.findByProyecto(proyect);
	}
	
	public Iterable<Tarea> getAllByUsuarioAndProyecto(Usuario user, Proyecto project){
		
		return repository.findByUsuarioAndProyecto(user, project);
	}
}
