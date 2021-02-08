package com.barbershop.com.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.barbershop.com.model.Role;
import com.barbershop.com.model.UserModel;
import com.barbershop.com.repository.CategoriaRole;
import com.barbershop.com.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoriaRole categoriaRole;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("registerUser/new")
	public String registerNewUser(Model model) {

		model.addAttribute("user", new UserModel());

		model.addAttribute("categorias", categoriaRole.findAll());

		return "/register-user";
	}

	@PostMapping(path = "registerUser/save")
	public String saveUser(@ModelAttribute("user") UserModel userModel,
			@RequestParam("file") MultipartFile file, @AuthenticationPrincipal UserDetails user){

		try {
			userModel.setPhoto(file.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}

		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		
		if(user == null ) {
			
	       Role roleCliente = categoriaRole.findOneByNomeRole("ROLE_CLIENTE");
	       
	       
			
			userModel.setRoles(Arrays.asList(roleCliente));
             
         
		}
		
		userService.saveUser(userModel);
		return "redirect:/registerUser/new";

	}

}
