package com.store.controllerAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Product;
import com.store.service.ProductService;

/**
 * 
 * @author hieun
 *
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProductControllerAPI {

	@Autowired
	private ProductService productService;

	@GetMapping("/get-all-product")
	public List<Product> getAllProduct() {
		List<Product> listProduct = productService.getAllProduct(); //query select * from product
		return listProduct;
	}
	
	@GetMapping("/get-ten-product")
	public List<Product> getTenProduct() {
		List<Product> listTenProduct = productService.getTenProduct();
		return listTenProduct;
	}

	@GetMapping("/get-product-category/{id}")
	public List<Product> getProductByCategory(@PathVariable int id){
		List<Product> listProByCate = productService.getProductByCategory(id);
		return listProByCate;
	}
	
	@GetMapping("/get-product-category4")
	public List<Product> getProductByCategory4(){
		List<Product> listProByCate = productService.getProductByCategory(4);
		return listProByCate;
	}
	
	@GetMapping("/get-ten-product-category")
	public List<Product> getTenProductByCategory(){
		List<Product> listTenProByCate = productService.getTenProductByCategory(1);
		return listTenProByCate;
	}
	
	@GetMapping("/get-ten-product-category4")
	public List<Product> getTenProductByCategory4(){
		List<Product> listTenProByCate = productService.getTenProductByCategory(4);
		return listTenProByCate;
	}
	
	@GetMapping("/get-product-detail/{id}")
	public Product getProductDetail(@PathVariable int id) {
		Product productDetail = productService.getProductById(id);
		return productDetail;
	}
	
	@PostMapping("/add-product")
	public int addProduct() {
//		Product product = new Product("Áo Khoác Thể Thao Nam Nu 3 Sọc", "THÔNG TIN SẢN PHẨM:- Chất thun poly 2 da cao cấp, Đường chỉ may chi tiết và chắc chắn - Chất liệu thấm hút mồ hôi tốt - Nón có thể thao rời - gắn lại được bằng khóa kéo - Logo thêu cực đẹp -  Chất vải không xù lông hay ra màu", 250000, 200, 1, null, null, null, 1);
		Product product = new Product();
		int result = productService.addProduct(product);
		return result;
	}
}
