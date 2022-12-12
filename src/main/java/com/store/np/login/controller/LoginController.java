package com.store.np.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.np.login.dto.LoginReponseDto;
import com.store.np.login.dto.LoginRequestDto;
import com.store.np.login.entity.Customer;
import com.store.np.login.service.LoginService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/common")
public class LoginController {
	@Autowired
	private LoginService service; //Tomcat container sẽ đi lấy thằng bean ~ class implements interface LoginService để tiêm vào cho Controller Login xài.
	
	@PostMapping("/login") 
	public LoginReponseDto loginCheck(@RequestBody LoginRequestDto req, HttpSession session) { 		
		Customer user = service.getAccount(req.getUsername(), req.getPassword());
		
		//Convert into DTO
		LoginReponseDto reponse = new LoginReponseDto(user.getId(), user.getUser_name());
		
		return reponse;
		
//		if(reponse != null) {
//			
//			/* ----------------------------------------------------------------------------------------------
//			 * Khi tạo session (bên phía Backend), thì Tomcat sẽ tự động tạo ra sessionId ứng với session đó.
//               Sau đó Cookie (bên phía Frontend) mang theo SessionId sẽ được tự động ra. 
//			 
//			 * Có thể xem Cookie bằng cách: 
//			   Network (Nhấn vào API sẽ hiển thị lên Header) --> chọn Header --> Xem tại Reponse Header (phần Set-Cookie: sẽ có trường JSESSIONID)
//			   ----------------------------------------------------------------------------------------------
//			 */
//			
//		  //session (NOTE: thời gian sống mặc định của session là 30 phút)
//			//session.setAttribute("username",user.getUser_name()); 
//			
//			//System.out.println(session.getAttribute("username"));
//			//System.out.println(session.getId()); //get session id (1 session sẽ ứng vs 1 session id , 1 session có thể có nhiều attribute)
//			                                     //session id do Tomcat định ra
//			
//	
//		}
		
		
	}
}
