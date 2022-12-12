 package com.store.repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.model.Product;

/**
 * 
 * @author hieun
 *
 */

@Repository
public class ProductRepository {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	//Connect DB (via mybatis)
//	private static SqlSessionFactory getSqlSessionFactory() {
//		if (sqlFactory == null) {
//			String resource = "mybatis/mybatis-config.xml";
//			Reader rd = null;
//			try {
//				// ctx.lookup
//				rd = Resources.getResourceAsReader(resource);
//				sqlFactory = new SqlSessionFactoryBuilder().build(rd);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if (rd != null) {
//				try {
//					rd.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return sqlFactory;
//	}
	
	//Query
	public List<Product> getAllProduct(){
		SqlSession session = sqlFactory.openSession();	
		List<Product> listProduct = session.selectList("product.selectAllProduct");
		return listProduct;
	}
	
	public List<Product> getTenProduct(){
		SqlSession session = sqlFactory.openSession();
		List<Product> listTenProduct = session.selectList("product.selectTenProduct");
		return listTenProduct;
	}
	
	public List<Product> getProductByCategory(int categoryId){
		SqlSession session = sqlFactory.openSession();
		List<Product> listProByCate = session.selectList("product.selectProductByCategory", categoryId);
		return listProByCate;
	}
	
	public List<Product> getTenProductByCategory(int categoryId){
		SqlSession session = sqlFactory.openSession();
		List<Product> listTenProByCate = session.selectList("product.selectTenProductByCategory", categoryId);
		return listTenProByCate;
	}

	public Product getProductById(int id){
		SqlSession session = sqlFactory.openSession();
		Product productDetail = session.selectOne("product.selectProductById", id);
		return productDetail;
	}
	

	public int addPoduct (Product product){
		SqlSession session = sqlFactory.openSession();
		int result = session.insert("product.insertProduct", product);
		session.commit();
		session.close();
		
		return result;
	}
	
	public int updateProduct (Product product){
		SqlSession session = sqlFactory.openSession();
		int result = session.update("product.updateProduct", product);
		session.commit();
		session.close();
		
		return result;
	}

}
