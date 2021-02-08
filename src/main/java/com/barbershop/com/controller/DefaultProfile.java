package com.barbershop.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/defaultprofile")
public class DefaultProfile {

	 @GetMapping()
	 public String showDefaultProfile() {
		 
		 return "defaultprofile";
	 }
	
}
