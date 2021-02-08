package com.barbershop.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarbershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);

		// System.out.println(new BCryptPasswordEncoder ().encode("123"));

	}

}
