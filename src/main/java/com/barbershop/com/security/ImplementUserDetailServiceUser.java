package com.barbershop.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.barbershop.com.model.UserModel;
import com.barbershop.com.repository.UserRepository;


@Service
public class ImplementUserDetailServiceUser implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Method tha make the validation
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserModel userModel = userRepository.findUserByLogin(username);

		if (userModel == null) {

			throw new UsernameNotFoundException("user not found");
		}

		return new User(userModel.getEmail(), userModel.getPassword(), userModel.isEnabled(), 
				true, true, true, userModel.getAuthorities());
	
	}	

}
