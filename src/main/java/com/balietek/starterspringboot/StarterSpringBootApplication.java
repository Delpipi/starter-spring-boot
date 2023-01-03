package com.balietek.starterspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.balietek.models") // sans cela les entities ne sont pas visible pour creer la base donnée
@ComponentScan(basePackages="com.balietek") // sans cela impossible de faire des requete HTTP
public class StarterSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterSpringBootApplication.class, args);
	}

}
