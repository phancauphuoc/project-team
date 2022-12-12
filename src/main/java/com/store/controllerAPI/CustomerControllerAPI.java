package com.store.controllerAPI;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Customer;
import com.store.service.CustomerService;

/**
 * 
 * @author phong
 *
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CustomerControllerAPI {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get-all-customer")
	public List<Customer> getAllCustomer() {
		List<Customer> listCustomer = customerService.getAllCustomer();
		return listCustomer;
	}	
	@PostMapping("/save-customer")
	public void saveCus(@RequestBody Customer cus) {

		customerService.saveCus(cus);
	}
	
	@GetMapping("/get-one-customer")
	public List<Customer> getOneCus(){
		List<Customer> listCustomers = customerService.getOneCustomer();
		return listCustomers;
	}
	
	@GetMapping("/get-one-customer-by/{id}")
	public Customer getOneCusById(@PathVariable int id){
		Customer oneCustomers = customerService.getOneCusById(id);
		return oneCustomers;
	}
	

	@PutMapping("/update-customer/{id}")
	public void updateCustomer(@PathVariable int id, @RequestBody Customer cus){
		cus.setId(id);
		System.out.println("user-------" + cus.getFullName());
		System.out.println("user-------" + cus.getAddress());
		System.out.println("user-------" + cus.getId());
		int kq = customerService.updateCus(cus);
		System.out.println(kq);
	}
	
	
	@GetMapping("/get-by-gender/{gender}")
	public List<Customer> getCusByGender(@PathVariable String gender){
		List<Customer> listCus =  customerService.getCusByGender(gender);
		return listCus;
	}
	
	@GetMapping("/count-by-gender")
	public Map<String, Integer> getGender() {
		customerService.statisticalCus();
		return customerService.statisticalCus();
	}
}

