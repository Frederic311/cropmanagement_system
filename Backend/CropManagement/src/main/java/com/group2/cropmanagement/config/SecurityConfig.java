package com.group2.cropmanagement.config;

import com.group2.cropmanagement.util.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private final AuthFilter jwtRequestFilter;

	@Autowired
	public SecurityConfig(AuthFilter jwtRequestFilter) {
		this.jwtRequestFilter = jwtRequestFilter;
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/api/auth/save", "/api/auth/login").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/api/**")
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}
