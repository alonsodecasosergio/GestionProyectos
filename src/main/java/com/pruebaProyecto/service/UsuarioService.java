package com.pruebaProyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.repository.UsuarioRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario getById(int id) {

		log.debug("OBTENCION DEL USUARIO CON EL ID: " + id);
		return repository.findById(id);
	}
	
	public void deleteUsuario(int id) {
		
		log.debug("BORRADO DEL USUARIO: " + getById(id).toString());
		repository.deleteById(id);
	}
	
	public void addUsuario(Usuario user) {
		
		log.debug("AÑADIDO DEL USUARIO: " + user.toString());
		repository.save(user);
	}
	
	public Usuario getUserToEmail(String email) {
		
		log.debug("OBTENCION DEL USUARIO CON EL EMAIL: " + email);
		return repository.findByEmail(email);
	}
	
	public boolean checkUser(String email, String password) {
		
		log.debug("CHECKEANDO USUARIO Y CONTRASEÑA: " + email + " | " + password);
		boolean correcto = false;
		
		Usuario user = getUserToEmail(email); 
		
		//COMPRUEBA QUE EXISTA EL USUARIO SEGUN EL EMAIL
		if(user != null) {
			
			//UNA VEZ EL USUARIO EXISTE SE COMPRUEBA QUE LAS CONTRASEÑAS SEAN CORRECTAS
			if(user.getPassword().equals(password)) {
				log.debug("USUARIO CORRECTO");
				correcto = true;
			}else {
				log.debug("CONTRASEÑA INCORRECTA");
			}
		}else {
			log.debug("USUARIO INCORRECTO");
		}
		
		return correcto;
		
	}

}
