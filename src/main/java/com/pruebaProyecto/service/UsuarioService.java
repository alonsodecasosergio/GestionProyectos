package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario getById(int id) {
		
		return repository.findById(id);
	}
	
	public void deleteUsuario(int id) {
		
		repository.deleteById(id);
	}
	
	public void addUsuario(Usuario user) {
		repository.save(user);
	}
	
	public Usuario getUserToEmail(String email) {
		
		return repository.findByEmail(email);
	}
	
	public boolean checkUser(String email, String password) {
		
		boolean correcto = false;
		
		Usuario user = getUserToEmail(email); 
		
		if(user != null) {
			
			if(user.getPassword().equals(password)) {
				correcto = true;
			}
		}
		
		return correcto;
		
	}

}
