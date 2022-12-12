package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Product;
import com.store.repository.ProductRepository;
/**
 * 
 * @author hieun
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> getAllProduct() {
		return productRepo.getAllProduct();
	}

	public List<Product> getTenProduct() {
		return productRepo.getTenProduct();
	}

	public List<Product> getProductByCategory(int categoryId) {
		// validate
		return productRepo.getProductByCategory(categoryId);
	}

	public List<Product> getTenProductByCategory(int categoryId) {
		// validate
		return productRepo.getTenProductByCategory(categoryId);
	}

	public Product getProductById(int id) {
		// validate
		return productRepo.getProductById(id);
	}

	public int addProduct(Product product) {
		if (product == null) {
			return 0;
		} else {
			int result = productRepo.addPoduct(product);
			return result;
		}
	}
	
	public int updateProduct(Product product) {
		if (product == null) {
			return 0;
		} else {
			int result = productRepo.updateProduct(product);
			return result;
		}
	}

}
