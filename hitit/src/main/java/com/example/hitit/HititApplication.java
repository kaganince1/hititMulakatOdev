package com.example.hitit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HititApplication {

	public static void main(String[] args) {
		SpringApplication.run(HititApplication.class, args);
	}

}
