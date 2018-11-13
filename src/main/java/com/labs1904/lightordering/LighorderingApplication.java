package com.labs1904.lightordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LighorderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LighorderingApplication.class, args);
		System.out.println("Trigger build..");
	}
}
