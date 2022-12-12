package com.store.np.springsecurityjwt.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.BeanIds;

import com.store.np.springsecurityjwt.jwt.JwtAuthenticationFilter;
import com.store.np.springsecurityjwt.jwt.JwtTokenProvider;
import com.store.np.springsecurityjwt.user.UserService;

//Author: Nam Phương

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
    UserService userService;
	
	//Khai báo type của method này là bean => JwtAuthenticationFilter là bean
//	@Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
	 
//	@Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }
	
//	@Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
        
        /*-------------------------------------------------------------------------------------------
         * Có nghĩa: Spring Security khi sử dụng (có nghĩa khi lấy password từ DB lên), 
         *           nó sẽ lấy pass ở dạng BCrypt (là dạng mật khẩu đã được mã hoá).
         *           Vì vậy ở dưới DB, phải lưu pass ở dạng BCrypt
         * 			 Vd: $2a$12$3OVfoeUPIB9B/A5Bz6M0cuNAVhxOTAmk0WfYk9lqi/hPd2EAb3pLy
         * 
         * 			 Còn trên Browser lúc đăng nhập ở form, người dùng vẫn nhập password chưa mã hoá.
         *           Vd: pass = 123456
         * 
         * Tham khảo trang web này, để chuyển đổi password sang dạng Bcrypt Hash Generator:
         *      https://bcrypt-generator.com/
         * 
         * -------------------------------------------------------------------------------------------
         * */
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService)     // Cung cấp userservice cho Spring Security
            .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors()					// Ngăn chặn request từ một domain khác
            .and()
            .authorizeRequests()
            	.antMatchers("/api/login").permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này
            	.antMatchers("/admin/*").hasRole("ADMIN")
            .anyRequest().authenticated()         // Tất cả các request khác đều cần phải xác thực mới được truy cập
            .and()
            .formLogin()
            	.loginPage("/login")
            	.successForwardUrl("/admin")
            	.failureForwardUrl("/logout")
            	.permitAll()
        // Thêm một lớp Filter kiểm tra jwt
            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
	
	
}
