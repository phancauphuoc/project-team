package com.store.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 
 * @author hieun
 *
 */


//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { // lưu vô ram - inMemory
		auth.inMemoryAuthentication()
			.withUser("user1").password(passwordEncoder().encode("1234567890"))
			.authorities("ROLE_USER");
	}
	
	// Authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // đường dẫn cần chứng thực
//			.antMatchers("/admin/**").authenticated()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}


