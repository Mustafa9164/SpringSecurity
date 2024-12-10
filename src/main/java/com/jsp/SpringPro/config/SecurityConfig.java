package com.jsp.SpringPro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder pass) {
		
		UserDetails u1= User.withUsername("Rahul").password(pass.encode("12345")).roles("ADMIN").build();
		UserDetails u2= User.withUsername("virat").password(pass.encode("9087")).roles("ADMIN").build();

		UserDetails u3= User.withUsername("dhoni").password(pass.encode("1234")).roles("User").build();

		UserDetails u4= User.withUsername("sagar").password(pass.encode("123")).roles("DBM").build();
		
		return new InMemoryUserDetailsManager(u1,u2,u3,u4);

	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		return http.csrf().disable().authorizeHttpRequests().requestMatchers("/api2").permitAll().and()
//				.authorizeHttpRequests().requestMatchers("/api3").hasRole("DBM").and().formLogin().and().build();
//	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(t->t.disable()).
				authorizeHttpRequests(auth->auth.requestMatchers("/api2").permitAll()).
				authorizeHttpRequests(auth->auth.requestMatchers("/api3").hasRole("DBM")).formLogin(form->form.permitAll()).build();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		//provider.setUserDetailsService(userDetailsService());
		return provider;
	}

}
