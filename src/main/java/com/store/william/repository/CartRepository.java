package com.store.william.repository;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.store.model.Cart;

//====================================================
//BƯỚC 3: Đi đến Repository
//====================================================

public class CartRepository {
	/*
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	//=====================================================================================	
	//Query
	//=====================================================================================	

		public void addToCart(Cart cart) {
			SqlSession session = sqlFactory.openSession();			
			
			System.out.println("ddd===" + sqlFactory);
			System.out.println(cart.getId());
			
			session.insert("cart.addToCart", cart); // cart.addToCart ~ namespace.id (bên file mapper "cart.xml" bên mybatis)
		                                            // cart (bên phải) : chính là parameter mình truyền vào 

			session.commit();
			session.close();
		}
	*/
		
}
