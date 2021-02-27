package com.barbershop.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
@Data
@Entity
public class Role implements GrantedAuthority {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameRole;
	
	public Role(){
		
	}
	
	public Role(String nameRole) {
		
		this.nameRole = nameRole;
	}

	@Override
	public String getAuthority() {
		
		return this.nameRole;
	} 
}
