package com.pruebaProyecto;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaProyectoApplication.class, args);
		BasicConfigurator.configure();
	}

}
