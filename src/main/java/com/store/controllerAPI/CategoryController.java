package com.store.controllerAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Category;
import com.store.service.CategoryService; //những thứ mình import vào, là mình đang phụ thuộc vào nó

/*
 * @author phuoc
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class CategoryController {
	
	//Dependency Injection (tiêm sự phụ thuộc)
	
	//Thằng Controller đi yêu cầu Spring Container đi lấy thằng Bean Service ra cho mình xài 
	@Autowired
	private CategoryService categorySevice;
	
	@GetMapping("/get-all-category")
	public List<Category> getAllCategory(){
		List<Category> listCategory = categorySevice.getAllCategory();
		return listCategory;
	}
}
