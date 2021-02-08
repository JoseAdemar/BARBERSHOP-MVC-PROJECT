package com.barbershop.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class scheduleServiceController {

	@GetMapping("schedule/new") 
	public String scheduleService() {
		
		return "/schedule-service";
	}
}
