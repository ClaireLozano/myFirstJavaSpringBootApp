package com.clozano.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.clozano.firstapp.config.MyFirstApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyFirstApplicationProperties.class)
public class MyFirstApplication {

	@Autowired
	private MyFirstApplicationProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApplication.class, args);
	}

	/**
	 * @Bean : Cette annotation indique à Spring que cette méthode produit un bean à gérer par le conteneur Spring. 
	 * Un bean est un objet qui est instancié, assemblé et géré par le conteneur Spring.
	 * 
	 * Retourne un CommandLineRunner : CommandLineRunner est une interface fonctionnelle fournie par Spring Boot. 
	 * Elle contient une méthode run(String... args) qui est exécutée une fois que le contexte de l'application 
	 * Spring est entièrement démarré.
	 */
	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Welcome message: " + properties.getWelcomeMessage());
		};
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runnerDev() {
		return args -> {
			System.out.println("this is something that we would only do in dev");
		};
	}

}
