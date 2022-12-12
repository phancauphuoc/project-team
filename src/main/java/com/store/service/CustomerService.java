package com.store.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Customer;

import com.store.repository.CustomerRepository;
/**
 * 
 * @author phong
 *
 */
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	public List<Customer> getAllCustomer() {
		return customerRepo.getAllCustomer();
	}
	
	public List<Customer> getByName(){
		return customerRepo.getByName();
	}
	
	public List<Customer> getByEmail(){
		return customerRepo.getByEmail();
	}
	
	public void saveCus(Customer cus) {
		
		customerRepo.saveCus(cus);
	}
	
	public int updateCus(int id, Customer cus) {
		if(cus.getId() == id) {
			customerRepo.updateCus(id, cus);
			return 1;
		}
		return 0;
	}
	
	
	public List<Customer> getOneCustomer(){
		return customerRepo.getOneCustomer();
	}
	
	public Customer getOneCusById(int id){
		return customerRepo.getOneCusById(id);
	}

	public int updateCus(Customer cus) {
		
		return customerRepo.updateCus(cus);
	}
	
//	public List<Customer> getCusByGender(){
//		return customerRepo.getCusByGender();
//	}
	public Map<String, Integer> statisticalCus(String gender) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Customer> listCusMale = new ArrayList<Customer>();
		List<Customer> listCusFemale = new ArrayList<Customer>();
		List<Customer> list = customerRepo.getAllCustomer();
		for (Customer customer : list) {
			if(customer.getGender().equals("male")) {
				listCusMale.add(customer);
			} else {
				listCusFemale.add(customer);
			}
		}
		
		map.put("Male", listCusMale.size());
		map.put("Female", listCusFemale.size());
//		return customerRepo.statisticalCus(gender);
		return map;
	}
	
	public Map<String, Integer> statisticalCus() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Customer> listCusMale = new ArrayList<Customer>();
		List<Customer> listCusFemale = new ArrayList<Customer>();
		List<Customer> list = customerRepo.getAllCustomer();
		for (Customer customer : list) {
			if(customer.getGender().equals("male")) {
				listCusMale.add(customer);
			} else {
				listCusFemale.add(customer);
			}
		}
		
		map.put("Male", listCusMale.size());
		map.put("Female", listCusFemale.size());
//		return customerRepo.statisticalCus(gender);
		return map;
	}
	
	public List<Customer> getCusByGender(String gender) {
		return customerRepo.getCusByGender(gender);
	}
	
}
