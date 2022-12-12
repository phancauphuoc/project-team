package com.store.repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.store.model.Category;

/**
 * 
 * @author Phuoc
 *
 */

@Repository
public class CategoryReposity {
	
	private static SqlSessionFactory sqlFactory;
	
	//Connect DB (via mybatis)	
		private static SqlSessionFactory getSqlSessionFactory() {
			if (sqlFactory == null) {
				String resource = "mybatis/mybatis-config.xml";
				Reader rd = null;
				try {
					// ctx.lookup
					rd = Resources.getResourceAsReader(resource);
					sqlFactory = new SqlSessionFactoryBuilder().build(rd);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (rd != null) {
					try {
						rd.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sqlFactory;
		}
		
		//Query
		public List<Category> getAllCategory(){
			sqlFactory = getSqlSessionFactory();
			SqlSession session = sqlFactory.openSession();
			List<Category> listCategory = session.selectList("category.selectAllcategory");
		
			return listCategory;
		}
		
}
