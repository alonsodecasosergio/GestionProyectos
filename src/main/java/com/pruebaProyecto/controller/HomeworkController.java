package com.pruebaProyecto.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaProyecto.model.Tarea;
import com.pruebaProyecto.model.Usuario;
import com.pruebaProyecto.service.HomeworkService;
import com.pruebaProyecto.service.ProyectService;
import com.pruebaProyecto.service.UsuarioService;

@Controller
@RequestMapping("/homework")
public class HomeworkController {
	
	@Autowired
	private ProyectService projectService;
	@Autowired
	private HomeworkService homeworkService;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public String viewAll(@PathVariable("id") int id) {
		
		//MOSTRARIA TODAS LAS TAREAS DE ESE PROYECTO
		ArrayList<Tarea> homeworks = (ArrayList<Tarea>) homeworkService.getAllByProyecto(projectService.getById(id));
		
		for(Tarea t : homeworks) {
			System.out.println(t.toString());
		}
		
		return "index";
		
	}
	
	@GetMapping("/myHomework/{id}")
	public String myHomework(HttpSession sesion, @PathVariable("id") int id) {
		
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		
		//MOSTRARIA LAS TAREAS DE ESE PROYECTO DEL USUARIO CONECTADO
		//RECOGIENDO EL ID DEL PROJECTO
		ArrayList<Tarea> homeworks = (ArrayList<Tarea>) homeworkService.getAllByUsuarioAndProyecto(user, projectService.getById(id));
		
		for(Tarea t : homeworks) {
			
			System.out.println(t.toString());
		}
		
		
		return "index";
	}
	
	@PostMapping("/add")
	public String add(HttpSession sesion, @Valid @ModelAttribute Tarea tarea, BindingResult bindingResult) {
		
		//AÑADIRA UNA NUEVA TAREA 
		
		//RECOJE EL USUARIO DE LA SESSION
		//Usuario user = (Usuario) sesion.getAttribute("usuario");
		Usuario user = usuarioService.getById(1);
		
		//COMPROVACION DE VALIDACIONES
		if(bindingResult.hasErrors()) {
			
			System.out.println("HAY ERRORES DE VALIDACION");
			
		}else {
			
			tarea.setUsuario(user);
			tarea.setProyecto(user.getProyecto());
			
			homeworkService.addTarea(tarea);
			
			System.out.println("AÑADIDO DE LA NUEVA TAREA: " + tarea.toString());
		}
		
		return "index";
	}

}
