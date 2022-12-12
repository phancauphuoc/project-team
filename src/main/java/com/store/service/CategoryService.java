package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Category;
import com.store.repository.CategoryReposity;
/**
 * 
 * @author Phuoc
 *
 */
@Service //nói với Spring Container (Tomcat) là đi tạo instance Service và quản lý dùm mình instance này.
         // instance mà do Spring Container tự động tạo và quản lý giúp mình => gọi là Bean
public class CategoryService {
	
	@Autowired
	private CategoryReposity categoryRepo;
	
	public List<Category> getAllCategory(){
		return categoryRepo.getAllCategory();
	}
	
}
