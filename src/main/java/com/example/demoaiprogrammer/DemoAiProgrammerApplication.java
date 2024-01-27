package com.example.demoaiprogrammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoAiProgrammerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAiProgrammerApplication.class, args);
	}

}
