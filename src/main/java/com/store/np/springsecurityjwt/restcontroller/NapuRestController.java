package com.store.np.springsecurityjwt.restcontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.np.springsecurityjwt.jwt.JwtTokenProvider;
import com.store.np.springsecurityjwt.payload.LoginRequest;
import com.store.np.springsecurityjwt.payload.LoginResponse;
import com.store.np.springsecurityjwt.payload.RandomStuff;
import com.store.np.springsecurityjwt.user.CustomerUserDetails;

//Author: Nam Phương

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
//@RequestMapping("/")

public class NapuRestController {
//	@Autowired
    AuthenticationManager authenticationManager;
	
//	@Autowired
    private JwtTokenProvider tokenProvider;
	
	 	//@PostMapping("/login")
	    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	 		System.out.println("나 왔어요오~ " + this);
	 		if( authenticationManager != null ) {
		        // Xác thực từ username và password.
		        Authentication authentication = authenticationManager.authenticate(
		                new UsernamePasswordAuthenticationToken(
		                        loginRequest.getUsername(),
		                        loginRequest.getPassword()
		                )
		        );

		        // Nếu không xảy ra exception tức là thông tin hợp lệ
		        // Set thông tin authentication vào Security Context
		        // SecurityContextHolder.getContext().setAuthentication(authentication);
	
		        // Trả về jwt cho người dùng.
		        String jwt = tokenProvider.generateToken((CustomerUserDetails) authentication.getPrincipal());
		        return new LoginResponse(loginRequest.getUsername(), jwt);
	 		}
	 		return null;//NPE
	        
	    }

	    // Api /api/random yêu cầu phải xác thực mới có thể request
	    @GetMapping("/random")
	    public RandomStuff randomStuff(){
	        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
	    }
	    
}
