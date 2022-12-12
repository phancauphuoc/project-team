package com.store.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.dto.CartItemResponseDto;
import com.store.model.Cart;
import com.store.resultType.CartResultType;

//Author:Nam Phương

//============================
//BƯỚC 3: Đi đến Repository
//============================

@Repository
public class CartRepository {
	
	//Dependency Injection (DI)
	@Autowired
	private SqlSessionFactory sqlFactory; // CartRepository kêu thằng Spring Container tiêm thằng Bean SqlSessionFactory vào (file ConfigBeans.java trong package repo)
	
	//=====================================================================================	
	//Query
	//=====================================================================================	
		
		//Add 1 item to Cart
		public void addToCart(Cart cart) {
			SqlSession session = sqlFactory.openSession();			
				
			//System.out.println("ddd===" + sqlFactory);
			//System.out.println(cart.getId());
			
			session.insert("cart.addToCart", cart); // cart.addToCart ~ namespace.id (bên file mapper "cart.xml" bên mybatis)
			                                        // cart (bên phải) : chính là parameter mình truyền vào 

			session.commit();
			session.close();
		}
		
		//----------------------------------------------------------
		//View cart
		public List<CartItemResponseDto> viewCart(String username) {
			SqlSession session = sqlFactory.openSession();
			
//			List<CartItemResponseDto> list = session.selectList("cart.viewCart", username); //selectList => return list
//			
//			for(int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).getProduct_name());
//				System.out.println(list.get(i).getUnit_price());
//				System.out.println(list.get(i).getQuantity());
//				System.out.println("\n\n");
//			}
			
			return session.selectList("cart.viewCart", username);			
		}
		
		//----------------------------------------------------------
		//View cart2
		public List<CartResultType> viewCart2(String username) {
			SqlSession session = sqlFactory.openSession();
			
			return session.selectList("cart.viewCart2", username);
		}
		
		
		//----------------------------------------------------------
		//Delete 1 item in Cart
		public void deleteItemInCart(int id) {
			SqlSession session = sqlFactory.openSession();			
					  
			//Delete operation
			session.delete("cart.deleteItemInCart", id);     
			session.commit();   					
		}
		
		//----------------------------------------------------------
		//Increase quantity of item (in Cart)
		public void increaseQuantityItemInCart(int id) {
			SqlSession session = sqlFactory.openSession();
					
			//Update operation
			session.update("cart.increaseQuantityItemInCart",id);
			session.commit(); 
		}
		
		//----------------------------------------------------------
		//Decrease quantity of item (in Cart)
		public void decreaseQuantityItemInCart(int id) {
			SqlSession session = sqlFactory.openSession();
					
			session.update("cart.decreaseQuantityItemInCart",id);
			session.commit();
		}

		
		
		
}
