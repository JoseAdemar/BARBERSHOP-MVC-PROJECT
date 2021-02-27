package com.barbershop.com.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;


@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "USERTABLE")
public class UserModel implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Lob
	private byte[] photo;

	private String fullName;

	private String age;

	private String phone;

	
	@Column(unique = true)
	private String email;

	private String password;

	
	// implementação para roles
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_role",
	  joinColumns = @JoinColumn(name = "user_id",
	    referencedColumnName = "id",
	      table = "usertable"),
	        inverseJoinColumns = @JoinColumn(name="role_id",
	           referencedColumnName = "id",
	             table = "role"))
	private List<Role> roles ;
	
	//fim da implementação de roles
	 
	/**
	 * UserDetails methods
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return roles;
	}

	@Override
	public String getUsername() {

		return email;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
