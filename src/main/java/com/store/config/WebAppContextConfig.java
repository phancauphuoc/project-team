package com.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class WebAppContextConfig implements WebMvcConfigurer {
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver; 
	}
	
	@Bean
	public Cloudinary cloudinary() {
		Cloudinary c = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","sport-store",
				"api_key","375797853215176",
				"api_secret","rTgCOZrIJMGOLFZDMxvSP9Opq-k",
				"secure", true
		));
		
		return c;
	}
	

}
