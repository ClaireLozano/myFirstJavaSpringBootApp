package com.clozano.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.clozano.firstapp.config.MyFirstApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyFirstApplicationProperties.class)
public class MyFirstApplication {

	@Autowired
	private MyFirstApplicationProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Welcome message: " + properties.getWelcomeMessage());
		};
	}

}
