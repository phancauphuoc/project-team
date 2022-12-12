package com.store.np.springsecurityjwt.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.store.np.springsecurityjwt.user.UserService;

//Author: Nam Phương

/*__________________________________________________________________________________________________
	BƯỚC 5: Filter
	
	Filter: có nhiệm vụ kiểm tra request của người dùng 
	trước khi nó tới đích. Nó sẽ lấy Header Authorization (chính là header của anxios) ra
	và kiểm tra xem chuỗi JWT người dùng gửi lên có hợp lệ không.
	
	NOTE:  
	[Tomcat] ----request--->  [Filter] -----> [Dispatcher Servlet (mapping url)] ---> [Controller]
  _________________________________________________________________________________________________
*/
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
//	@Autowired
    private JwtTokenProvider tokenProvider;
	
//	@Autowired
    private UserService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
            // Lấy jwt từ request
			System.out.println(request.getParameter("productName"));
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                
            	// Lấy username từ chuỗi JWT
            	String userUsername = tokenProvider.getUserUsernameFromJWT(jwt); //Long userId = tokenProvider.getUserIdFromJWT(jwt);
                
                
                // Lấy thông tin người dùng từ username
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userUsername); //UserDetails userDetails = customUserDetailsService.loadUserById(userId);
                
                
                if(userDetails != null) {
                    // Nếu người dùng hợp lệ, set thông tin cho Security Context
                    
                	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
            System.out.println("failed on set user authentication: " + ex);
        }

        filterChain.doFilter(request, response);
		
	}
	
	private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        
        // Kiểm tra xem header Authorization có chứa thông tin jwt không?
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) { //Bearer token
            return bearerToken.substring(7);
        }
        return null;
    }

}
