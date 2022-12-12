package com.store.np.login.service;

import com.store.np.login.dto.LoginReponseDto;
import com.store.np.login.entity.Customer;

public interface LoginService {
	public Customer getAccount(String username, String password);
}
