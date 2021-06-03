package com.pruebaProyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebaProyecto.model.Proyecto;
import com.pruebaProyecto.service.ProyectService;

@SpringBootTest
@RunWith(SpringRunner.class)
class PruebaProyectoApplicationTests {

	
	@Autowired
	ProyectService servicioProyecto;
	
	@Before
	void antesDelTest() {System.out.println("Antes de la prueba");}
	
	@BeforeClass
	static void antesDeLaClase() {System.out.println("Antes de la clase");}
	
	@Test
	void contextLoads() {
		//Dado un proyecto
		Proyecto pro = new Proyecto(123, "Proyecto Test", new Date(), new Date());
		
		//Cuando
		servicioProyecto.addProyecto(pro);
		
		//Entonces...verificamos
		assertTrue(servicioProyecto.addProyecto(pro));
	}
	
	@After
	void despuesDelTest() {System.out.println("Despues de cada prueba");}
	
	@AfterClass
	static void despuesDeLaClase() {System.out.println("Despues de la clase");}

}
