package com.store.np.springsecurityjwt.jwt;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.store.np.springsecurityjwt.user.CustomerUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

//Author: Nam Phương

//BƯỚC 4: 
/*____________________________________________________
 * JwtTokenProvider: nơi mã hoá thông tin người dùng
 * 
 * username, password     ----encoding---->   JWT
 * username, password     <---decoding-----   JWT
 * 
 * NOTE: BƯỚC 5 đi đến Filter
 * ___________________________________________________
 * */
//@Component
public class JwtTokenProvider {
	
	// Đoạn JWT_SECRET này là key bí mật, chỉ có phía server biết
	private final String JWT_SECRET = "namphuongcute";
	
	// Thời gian có hiệu lực của chuỗi jwt
	private final long JWT_EXPIRATION = 604800000L;
	
	//----------------------------------------------
	// Tạo ra JWT từ thông tin user (encoding)
    public String generateToken(CustomerUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        
        // Tạo chuỗi json web token từ username của user (thông qua secret key)
        return Jwts.builder()
        		  .setSubject(userDetails.getUser().getUser_name()) //.setSubject(Long.toString(userDetails.getUser().getId()))
                   .claim("ROLE", "ABC") 
                  // .claim("sub", userDetails.getUser().getUser_name())
        		   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .signWith(SignatureAlgorithm.HS512, JWT_SECRET) // dùng thuật toán HS512 đã mã hoá (dựa trên secret key)
                   .compact();
    }
    
    /**********************************************************
     NOTE:
     
     * 1 token bao gồm 3 phần: header, payload, VERIFY SIGNATURE
      _________________________________________
      HEADER:  chính là ALGORITHM & TOKEN TYPE
	  _________________________________________
	     {
	  		"alg": "HS512"
		 }
      _________________________________________
      PAYLOAD: chính là DATA
      _________________________________________ 
		{
		  "sub": "namphuong01998",
		  "ROLE": "ABC",
		  "iat": 1659584424,
		  "exp": 1660189224
		}
		
	-------------------------------------------	
	* Dùng trang web này test thử token sẽ hiểu:
      			https://jwt.io/	
	
     **********************************************************
     * */
    
    //----------------------------------------------
    // Lấy thông tin user từ JWT (decoding)
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject());
    }
    
    
    public String getUserUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }
    
   //----------------------------------------------
    public boolean validateToken(String authToken) {
    	
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
        	System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
        	System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
        	System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
        	System.out.println("JWT claims string is empty.");
        }
        
        return false;
    }
}
