package com.barbershop.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private ImplementUserDetailServiceUser detailServiceCustomer;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests ()
		.antMatchers(HttpMethod.GET,"/").permitAll()
		.antMatchers("/registerUser/new").permitAll()
		.antMatchers("/registerUser/save").permitAll()
		.anyRequest (). authenticated ()
		.and()
		.formLogin().permitAll ()
		.loginPage("/login")
		//.defaultSuccessUrl("/registerUser/new")
		.defaultSuccessUrl("/defaultprofile")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login");

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth
		.userDetailsService(detailServiceCustomer).passwordEncoder(encoder());
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/images/**");
		web.ignoring().antMatchers("/javascripts/**");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder(11);
	}
}
