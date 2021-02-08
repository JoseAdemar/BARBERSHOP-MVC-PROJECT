package com.barbershop.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.com.model.UserModel;
import com.barbershop.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public void saveUser(UserModel userModel) {

		userRepository.save(userModel);
	}

}
