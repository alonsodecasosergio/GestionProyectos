package com.pruebaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaProyecto.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findById(int id);
	Usuario findByEmail(String email);
}
