package com.clozano.firstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.clozano.firstapp.config.MyFirstApplicationProperties;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(MyFirstApplicationProperties.class)
public class MyFirstApplication {

	// static : est partagé entre toutes les instances de MyFirstApplication.
	// final : ne peut pas être réassigné après son initialisation.
	private static final Logger log = LoggerFactory.getLogger(MyFirstApplication.class);

	/**
	 * @Autowired permet à Spring de résoudre et d'injecter automatiquement une instance du bean 
	 * approprié dans la variable membre properties de votre classe. Cela signifie que Spring va 
	 * chercher un bean de type MyFirstApplicationProperties dans le contexte de l'application et 
	 * l'assigner à cette variable.
	 */
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

			/**
			 * 2024-06-12T12:46:49.719+02:00  INFO 24016 --- [firstapp] [  restartedMain] c.clozano.firstapp.MyFirstApplication    : info
			 * 2024-06-12T12:46:49.720+02:00 DEBUG 24016 --- [firstapp] [  restartedMain] c.clozano.firstapp.MyFirstApplication    : debug
			 * 2024-06-12T12:46:49.720+02:00  WARN 24016 --- [firstapp] [  restartedMain] c.clozano.firstapp.MyFirstApplication    : warn
			 * 2024-06-12T12:46:49.721+02:00 ERROR 24016 --- [firstapp] [  restartedMain] c.clozano.firstapp.MyFirstApplication    : error
			 */
			log.info("info");
			log.warn("warn");
			log.debug("debug");
			log.trace("trace");
			log.error("error");
		};
	}

}
