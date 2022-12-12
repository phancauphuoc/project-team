package com.store.service;

import java.util.List;

import com.store.dto.CartItemResponseDto;
import com.store.model.Cart;
import com.store.resultType.CartResultType;

//Author: Nam Phương
public interface CartService {
	
	void addToCart(Cart cart); //default modifier trong interface là public
	
	List<CartItemResponseDto> viewCart(String username);
	
	List<CartResultType> viewCart2(String username);

	void deleteItemInCart(int id);

	void increaseQuantityItemInCart(int id);

	void decreaseQuantityItemInCart(int id);

	

}
