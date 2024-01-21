package com.boot.blogappapis.config;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig{
	
	
	@Bean
	public UserDetailsService userDetailsServiceAutoConfiguration(PasswordEncoder passwordEncoder) {
		UserDetails normalUser = User
				.withUsername("kunal")
				.password(passwordEncoder.encode("password"))
				.roles("Normal")
				.build();
		
		UserDetails adminUser = User
				.withUsername("swarnkar")
				.password(passwordEncoder.encode("password"))
				.roles("Admin")
				.build();
		return new InMemoryUserDetailsManager(normalUser,adminUser);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
		
	}
	
}
