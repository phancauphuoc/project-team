package com.store.controllerAPI;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.AddCartRequestDto;
import com.store.dto.CartItemRequestDto;
import com.store.dto.CartItemResponseDto;
import com.store.dto.CartItemResponseDto2;
import com.store.dto.UserAccountRequestDto;
import com.store.model.Cart;
import com.store.resultType.CartResultType;
import com.store.service.CartService;
import com.store.service.CartServiceImpl;

//Author: Nam Phương
//====================================================
//BƯỚC 1: url mapping => Nhảy vào Controller đầu tiên
//====================================================


/* Enabling Cross Origin Requests (Bật Cross lên)

   Có nghĩa: Backend (port: 8080) và Frontend (port: 3000), do khác port xảy ra lỗi CORS error. 
   Có thể thấy lỗi này bên FE bằng cách: Bấm F12 -> Network sẽ hiển thị xem API đã được call chưa,
   và đồng thời nó cũng throw CORS error cho mình.
   
   => Dùng annotation: @CrossOrigin(origins = "http://localhost:3000") 
      Có nghĩa, những request với port 3000 sẽ được Controller chấp nhận cho call API.
*/

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/cart")
public class CartControllerAPI { 
	
    //Dependency injection (DI) => Bắt Spring Container tiêm thằng Bean vào	
	@Autowired
	private CartService cartService;       //Controller call Interface CartService => Spring Container sẽ đi tiêm thằng Bean (là Class implements Interface CartService này)
	
	
	//__________________________________________________________________________________
	//Chỉ có POST mới dùng được cột Body raw JSON (của Postman)
	//Call API lấy dữ liệu từ FE thông qua dto (~ request)
	//__________________________________________________________________________________
	
	
	//API add 1 item to cart => OK 
	
	@PostMapping("/add-to-cart") 
	public void addToCart(@RequestBody AddCartRequestDto req ) { 
		
		//    Khi mà lấy từ FE qua (trong phần Body raw JSON, convert ra instance AddCartRequestDto này.
		//==> Ở bên class AddCartRequestDto, cần có constructor ko tham số (đây gọi là default constructor).
		
		Cart cart = new Cart(req.getUsername(), req.getIdproduct(), req.getQuantity()); 
							//~ request.getUsername()
							//~ request.getIdproduct()
							//~ request.getQuantity()
		                                                                                
		cartService.addToCart(cart);
	}
	
	
	//---------------------------------------------------------------------------------
	//API view Cart => OK (bỏ)		
	
	@PostMapping("/view-cart") //BỎ (drop)
	public List<CartItemResponseDto> viewCart(@RequestBody UserAccountRequestDto req) { 
		//System.out.println(req.getUsername());
		
		return cartService.viewCart(req.getUsername()); //ra mảng của các JSON (Postman)
	}
	
	//---------------------------------------------------------------------------------
	@PostMapping("/view-cart2")
	//public List<CartItemResponseDto2> viewCart2(@RequestBody UserAccountRequestDto req, HttpSession session) { 
	public List<CartItemResponseDto2> viewCart2(@RequestBody UserAccountRequestDto req, HttpServletRequest request) { 	
		
		//Check sessionId xem đúng không?
		
		//System.out.println(request.getSession().getAttribute("username")); // HttpServletRequest => co tao ra session moi,
		                                                                     // nhung get attribute thi null

		//System.out.println(session.getAttribute("username")); // HttpSession => co tao ra session moi,
        													    // nhung get attribute thi null
		
		
		/*______________________________________________________________________________________________________________
		 * NOTE:
		 
		 * Calling getSession() and getSession(true) are functionally the same: retrieve the current session, 
		   and if one doesn't exist yet, create it.

         * Calling getSession(false), though, retrieves the current session, and if one doesn't exist yet, returns null. 
           Among other things, this is handy when we want to ask if the session exists.
		 ______________________________________________________________________________________________________________ */
		
		//Get List Cart (Result Type)
		List<CartResultType> listResultType = cartService.viewCart2(req.getUsername());
		
		//Initialize List Cart (DTO)
		List<CartItemResponseDto2> listDTO  = new ArrayList<CartItemResponseDto2>();
		
		
		//Mapping Cart(entity) ~ CartItemResponse (Dto)
		for(int i=0; i<listResultType.size(); i++) {
			
			//Create Cart (DTO)
			CartItemResponseDto2 item = new CartItemResponseDto2();
			item.setId(listResultType.get(i).getId());
			item.setProduct_img(listResultType.get(i).getProduct_img());
			item.setProduct_name(listResultType.get(i).getProduct_name());
			item.setUnit_price(listResultType.get(i).getUnit_price());
			item.setQuantity(listResultType.get(i).getQuantity());
			
			//Add Cart (DTO) to list Cart (DTO)
			listDTO.add(item);
		}
		
		return listDTO; 
	}
	
	//---------------------------------------------------------------------------------
	//API delete 1 item in Cart => OK
	
	@PostMapping("/delete-item-in-cart")
	public void deleteItemInCart(@RequestBody CartItemRequestDto req) {	
		cartService.deleteItemInCart(req.getId());
	}
	
	
	//---------------------------------------------------------------------------------
	//API increase quantity of item (in Cart) => OK
	
	@PostMapping("/increase-quantity-of-item-in-cart")
	public void increaseQuantityItemInCart(@RequestBody CartItemRequestDto req) {
		cartService.increaseQuantityItemInCart(req.getId());
	}
	
	
	//---------------------------------------------------------------------------------
	//API decrease quantity of item (in Cart) => OK
	
	@PostMapping("/decrease-quantity-of-item-in-cart")
	public void decreaseQuantityItemInCart(@RequestBody CartItemRequestDto req) {
		cartService.decreaseQuantityItemInCart(req.getId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//___________________________________________________________________________________________________________________		
	
	//==================================================================================
	// Call API lấy dữ liệu từ FE (fix cứng test thử)
	//==================================================================================
	
	@GetMapping("/add-to-cart1") // "http://localhost:8080/final-project/add-to-cart"
	public void addToCart1() {  
		Cart cart = new Cart("namphuong", 6, 2);              // gom tất cả các param thành 1 cục (~ 1 Instance)
		
		//System.out.println("Test for init");	
		cartService.addToCart(cart); 
		
	}//*/
	
	/*
	//==================================================================================
	// Call API lấy dữ liệu từ FE thông qua cột Params (của Postman)
	//==================================================================================
	@GetMapping("/add-to-cart2") // http://localhost:8080/final-project/add-to-cart2?username=huyoi&idproduct=15&quantity=2
	public void addToCart2(@RequestParam String username, @RequestParam int idproduct, @RequestParam int quantity  ) { 
		                  
						  // param không liên quan đến field của model
		                  // param lấy từ FE về dùng @RequestParam (cột param trong Postman, GET chỉ dùng được form-data)
																				
		Cart cart = new Cart(username, idproduct, quantity);
		cartService.addToCart(cart);
	}//*/
	
	//_____________________________________________________________________________________________________________________
}
