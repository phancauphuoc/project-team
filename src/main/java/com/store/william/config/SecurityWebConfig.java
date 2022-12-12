package com.store.william.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Deprecated
//@Configuration
//@EnableWebSecurity
public class SecurityWebConfig {
	private Logger log = LoggerFactory.getLogger(SecurityWebConfig.class);
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("{}");
		http.authorizeRequests()
			.antMatchers("/api/*","/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
			;
		return http.build();
	}
	
	
	

}
