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
	public String viewHomework(@PathVariable("id") int id) {
		
		//MOSTRARIA TODAS LAS TAREAS DE ESE PROYECTO
		ArrayList<Tarea> homeworks = (ArrayList<Tarea>) homeworkService.getAllByProyecto(projectService.getById(id));
		
		for(Tarea t : homeworks) {
			System.out.println(t.toString());
		}
		
		return "index";
		
	}
	
	@GetMapping("/myHomework/{id}")
	public String myHomework(HttpSession sesion, @PathVariable("id") int id) {
		
		//Usuario user = (Usuario) sesion.getAttribute("usuario");
		Usuario user = usuarioService.getById(1);
		
		//MOSTRARIA LAS TAREAS DE ESE PROYECTO DEL USUARIO CONECTADO
		//RECOGIENDO EL ID DEL PROJECTO
		ArrayList<Tarea> homeworks = (ArrayList<Tarea>) homeworkService.getAllByUsuarioAndProyecto(user, projectService.getById(id));
		
		for(Tarea t : homeworks) {
			
			System.out.println(t.toString());
		}
		
		return "index";
	}
	
	@PostMapping("/add")
	public String addHomework(HttpSession sesion, @Valid @ModelAttribute Tarea tarea, BindingResult bindingResult) {
		
		//AÑADIRA UNA NUEVA TAREA 
		
		//RECOJE EL USUARIO DE LA SESSION
		//Usuario user = (Usuario) sesion.getAttribute("usuario");
		Usuario user = usuarioService.getById(2);
		
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
	
	@PostMapping("/del/{id}")
	public String deleteHomework(@PathVariable("id") int id) {
		
		System.out.println("BORRADO DE LA TAREA: " + homeworkService.getTareaById(id));
		
		//BORRADO DE LA TAREA SEGUN SU ID 
		homeworkService.deleteTarea(id);
		
		
		return "redirect: /homework";
		
	}
	
	@PostMapping("/update")
	public String updateHomework(@ModelAttribute Tarea tarea) {
		
		//OBTENCION DEL USUARIO A TRAVES DE LA SESSION 
		//Usuario user = (Usuario) sesion.getAttribute("usuario");
		Usuario user = usuarioService.getById(1);
		tarea.setUsuario(user);
		tarea.setProyecto(user.getProyecto());
		
		System.out.println("EDITADO DE LA TAREA: " + tarea.toString());
		
		//EDITADO DE LA TAREA
		homeworkService.updateTarea(tarea);
		
		return "index";
	}

}