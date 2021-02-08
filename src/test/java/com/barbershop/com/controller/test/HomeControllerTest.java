package com.barbershop.com.controller.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HomeControllerTest {

		
	@Test
	public String homePage() {

		return "/home";

	}

}
