package com.store.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.store.dto.InforCusInvoiceDto;
import com.store.dto.InforProInvoiceDetailDto;
import com.store.dto.InvoiceDetailDto;
import com.store.model.Invoice;
import com.store.model.Product;
import com.store.service.CustomerService;
import com.store.service.InvoiceService;
import com.store.service.StatisticService;
import com.store.service.ProductService;

/**
 * 
 * @author hieun
 *
 */

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService cusService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private StatisticService statisticService;
	
	@GetMapping({"/", ""})
	public String home(Model model) {
		
		model.addAttribute("totalRevenue", statisticService.getTotalRenevue() );
		model.addAttribute("countCus", cusService.getAllCustomer().size());
		model.addAttribute("countInvoice", invoiceService.getAllInvoices().size());
		model.addAttribute("countProduct", productService.getAllProduct().size());
		
		return "index";
	}
	
	@GetMapping("/product")
	public String getProduct(Model model) {
		model.addAttribute("listProducts", productService.getAllProduct());
		return "product";
	}
	
	@GetMapping("/product-update/{id}")
	public String getProductDetail(Model model, @PathVariable int id) {
		model.addAttribute("productDetail", productService.getProductById(id));
		return "product-update";
	}
	
	@PostMapping("/product-update")
	public String getProductDetail(@ModelAttribute("product") Product product, Model model) {
		try {
			// upload hình lên server thứ 3 (Cloudinary)
			
			if(product.getFile().getOriginalFilename() != null) {
				Map<?, ?> resultImg = cloudinary.uploader().upload(product.getFile().getBytes(), 
						ObjectUtils.asMap("resource_type", "auto"));
				String img =  (String) resultImg.get("secure_url");		
				product.setProductImg(img);
			} else {
				if(product.getProductImg() != null) {
					product.setProductImg(product.getProductImg());
					System.out.println(product.getProductImg());
				}
			}
	 
			int result = productService.updateProduct(product);
			if(result == 1) {
				model.addAttribute("listProducts", productService.getAllProduct());
				return "redirect:/admin/product";
			} else {
				return "product-update";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("====ADD PRODUCT====" + e.getMessage());
		}
		
		return "redirect:/admin";
	}
	
	@GetMapping("/product-add")
	public String addProduct(Model model) {
		return "product-add";
	}
	
	@PostMapping("/product-add")
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		try {
			// upload hình lên server thứ 3 (Cloudinary)
			Map<?, ?> resultImg = cloudinary.uploader().upload(product.getFile().getBytes(), 
					ObjectUtils.asMap("resource_type", "auto"));
			
			String img =  (String) resultImg.get("secure_url");
			product.setProductImg(img);
			int result = productService.addProduct(product);
			if(result == 1) {
				model.addAttribute("listProducts", productService.getAllProduct());
				return "product";
			} else {
				return "product-add";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@GetMapping("/orders")
	public String getAllInvoice(Model model) {
		model.addAttribute("listAllInvoices", invoiceService.getAllOrders());
		return "orders";
	}
	
	@GetMapping("/order-update/{id}")
	public String updateInvoice(Model model, @PathVariable int id) {
		model.addAttribute("orderDetail", invoiceService.getOneOrder(id));
		return "order-update";
	}
	
	@PostMapping("/order-update")
	public String updateInvoice( @RequestParam("id") int id, @RequestParam("state") int state ,Model model) {
		invoiceService.updateOrder(id, state);
		
		return "redirect:/admin/orders";
	}
	
	@GetMapping("/invoice-detail/{id}")
	public String getInvoiceDetail(@PathVariable int id, Model model) {

		InforCusInvoiceDto cusInvoice = invoiceService.getInforCusInvoice(id);
		List<InforProInvoiceDetailDto> proInvoiceDetail = invoiceService.getInforProInvoiceDetail(id);
		model.addAttribute("cusInvoice", cusInvoice);
		model.addAttribute("proInvoiceDetail", proInvoiceDetail);

		return "invoice-detail";
	}
	
	@GetMapping("/revenue")
	public String getRevenue(Model model) {
		Map<Integer, String> result = statisticService.getTotalRenevueByMonth();
		model.addAttribute("revenueByMonth", result);
		return "revenue";
	}
	
	@GetMapping("/statistic-product")
	public String getStatisticProductMax(Model model) {
		model.addAttribute("top4Product", statisticService.getTop4Product());
		model.addAttribute("listOneTopProWithMonth", statisticService.getOneTopProductWithMonth());
		
		return "statistic-product";
	}
	
}
