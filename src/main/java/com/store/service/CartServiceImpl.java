package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.CartItemResponseDto;
import com.store.model.Cart;
import com.store.repository.CartRepository;
import com.store.resultType.CartResultType;


//Author: Nam Phương
//====================================================
//BƯỚC 2: Đi đến Service
//====================================================

@Service
public class CartServiceImpl implements CartService{//Alt + Shift + R : rename name của Class, những chỗ liên quan đên Class này tự động cập nhật lại tên
	
   //Dependency injection (DI) => Bắt Spring Container tiêm thằng Bean Repo vào
	@Autowired
	private CartRepository cartRepo; //Service gọi Repo (đi đến BƯỚC 3: Reposity)
	
	public void addToCart(Cart cart) {
		cartRepo.addToCart(cart); 
	}
	
	
	public List<CartItemResponseDto> viewCart(String username){	
		return cartRepo.viewCart(username);
	}
	
	public List<CartResultType> viewCart2(String username) {	
		return cartRepo.viewCart2(username);
	}
	
	public void deleteItemInCart(int id) {
		cartRepo.deleteItemInCart(id);		
	}

	public void increaseQuantityItemInCart(int id) {
		cartRepo.increaseQuantityItemInCart(id);
	}

	public void decreaseQuantityItemInCart(int id) {
		cartRepo.decreaseQuantityItemInCart(id);	
	}


	
	
	
	
}
