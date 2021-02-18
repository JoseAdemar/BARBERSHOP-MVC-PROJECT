package com.barbershop.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbershop.com.model.Appointment;
import com.barbershop.com.service.AppointmentService;

@Controller
@RequestMapping("/")
public class scheduleServiceController {
	
	@Autowired
	AppointmentService appointmentService;

	@GetMapping("schedule/new") 
	public String scheduleService(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "/schedule-service";
	}
	
	
	@PostMapping(path = "myAppointment/save")
	public String toSaveAppointment(@ModelAttribute("appointment")Appointment appointment) {
		
		appointmentService.saveAppointment(appointment);
		
		return "redirect:/schedule/new";
		
	}
}
