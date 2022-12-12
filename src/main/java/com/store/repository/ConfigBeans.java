package com.store.repository;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Author: Nam Phương

@Configuration
public class ConfigBeans {
	
	/**
	 *	Connect DB (via mybatis) 
	 * @return SqlSessionFactory bean
	 */
	
	@Bean
	protected SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis/mybatis-config.xml";
		Reader rd = null;
		SqlSessionFactory sqlFactory = null;
		try {
			rd = Resources.getResourceAsReader(resource);
			sqlFactory = new SqlSessionFactoryBuilder().build(rd);
		} catch (IOException e) {
			System.out.println("failed create SqlSessionFactory : " + e.getMessage());
		}
		if (rd != null) {
			try {
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlFactory;
	}
	
	/* _____________________________________________________________________________________________
	 * NOTE:
	 - annotation @Bean chỉ được dùng trước method => Để đánh dấu type của method là Bean
	   
	   Vd: @Bean
	       protected SqlSessionFactory getSqlSessionFactory() : method
	   
	   ==> Đánh dấu thằng SqlSessionFactory là Bean (~ instance được quản lý bởi Spring Container)
	   --------------------------------------------------------------------------------------
	 - Class mà chứa method được đánh dấu bằng annotation @Bean thì phải đánh dấu class đó 
	   bằng annotation @Configuration => thì mới khai báo được thằng Bean chính là thằng type của method.
	   
	   Có nghĩa: @ Configuration: cho Class 
	             @ Bean         : cho method nằm trong Class này 
	             => 2 annotation đó là 1 cặp phải đi chung
	   _____________________________________________________________________________________________
	 * 
	 * */ 
}
