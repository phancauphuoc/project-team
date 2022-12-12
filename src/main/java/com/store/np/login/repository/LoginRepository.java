package com.store.np.login.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.np.login.entity.Customer;

@Repository
public class LoginRepository {
	@Autowired
	private SqlSessionFactory sqlFactory;

	public Customer getAccount(String username, String password) {
		SqlSession session = sqlFactory.openSession();
		
		Map<String, String> map = new HashMap<String, String>();	
		map.put("username", username);
		map.put("password", password);
		
		Customer c = (Customer) session.selectOne("login.getAccount",map);
//		System.out.println(c.getId());
//		System.out.println(c.getUser_name());
//		System.out.println(c.getPassword());
		
		
		//return (User) session.selectOne("foodboys.user.selectOne");
		//System.out.println(username + "-" + password);
		return c;
	}
	
}
