package com.barbershop.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.com.model.Role;

public interface CategoriaRole extends JpaRepository<Role, Long>{

	 
	 Role findOneByNomeRole (String nomeRole);
		 
}
