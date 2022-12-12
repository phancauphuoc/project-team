package com.store.np.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.np.login.dto.LoginReponseDto;
import com.store.np.login.entity.Customer;
import com.store.np.login.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginRepository repo;
	
	public Customer getAccount(String username, String password) {	
		return repo.getAccount(username,password);
	}

}
