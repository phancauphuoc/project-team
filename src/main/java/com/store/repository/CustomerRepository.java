package com.store.repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.store.model.Customer;
import com.store.model.Product;

/**
 * 
 * @author phong
 *
 */
@Repository
public class CustomerRepository {
private static SqlSessionFactory sqlFactory;
	
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
	public List<Customer> getAllCustomer(){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<Customer> listCustomer = session.selectList("customer.selectAllCustomer");
		
		return listCustomer;
	}
	
	public List<Customer> getByName(){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<Customer> listCustomer = session.selectList("customer.getByName");
		return listCustomer;
	}
	
	public List<Customer> getByEmail(){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<Customer> listCustomer = session.selectList("customer.getByEmail");
		return listCustomer;
	}
		
	public void saveCus(Customer cus){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("customer.saveCus", cus);
		session.commit();
		session.close();
	}
	
	public void updateCus(int id, Customer cus) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int kq = session.update("customer.updateCus", cus);
		session.commit();
		session.close();
		System.out.println("=====> Repo: "+kq);
	}
	
	public List<Customer> getOneCustomer(){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<Customer> oneCustomer = session.selectList("customer.getOneCus");
		return oneCustomer;
	}
	
	public Customer getOneCusById(int id){
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		Customer customerDetail = session.selectOne("customer.getOneCusById", id);
		return customerDetail;
	}
	public int updateCus(Customer cus) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int kq = session.update("customer.updateCus", cus);
		session.commit();
		session.close();
		System.out.println("=====> Repo: "+kq);
		
		return kq;
	}
	
	public int statisticalCus(String gender) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int kq = session.selectOne("customer.statisticalCus", gender);
		return kq;
	}
	
//	public List<Customer> getCusByGender(){
//		sqlFactory = getSqlSessionFactory();
//		SqlSession session = sqlFactory.openSession();
//		List<Customer> oneCustomer = session.selectList("customer.selectCusByGender");
//		return oneCustomer;
//	}
	public List<Customer> getCusByGender(String gender) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<Customer> oneCustomer = session.selectList("customer.selectCusByGender", gender);
		
		
		return oneCustomer;
	}

}
