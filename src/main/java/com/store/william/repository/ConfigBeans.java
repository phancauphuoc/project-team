package com.store.william.repository;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ConfigBeans {

	/**
	 *	Connect DB (via mybatis) 
	 * @return SqlSessionFactory bean
	 */
	
	//@Bean
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


		
}
