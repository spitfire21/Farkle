package edu.plu.cs.farkle.server.auth;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.io.IOException;
import java.security.Key;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;

import edu.plu.cs.farkle.server.auth.UserPrincipalRequestWrapper;
import edu.plu.cs.farkle.server.core.FarkleServerApplication;
@WebFilter("/farkle/game")
public class SocketFilter implements Filter{



	/**
	 * This method is called prior to every request.  It reads the HTTP 
	 * Authorization header and attempts to authenticate the client.  If successful,
	 * it inserts a SecurityContext object into the request.  Otherwise, it does
	 * nothing.
	 */
	
	private String validateToken(String token) throws Exception {
		 Key key = FarkleServerApplication.getKey();
		
		try {
			System.out.println("Checking token");
			// TODO check if token is stored in database
		 
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			System.out.println("asd");
			
			

		} catch (InvalidClaimException e) {
			System.out.println("failed token");
		    //don't trust the JWT!
		}
		catch (MalformedJwtException e) {
			System.out.println("failed token");
		    //don't trust the JWT!
		}
		catch (UnsupportedJwtException e) {
			System.out.println("failed token");
		    //don't trust the JWT!
		}
		catch (SignatureException e){
			System.out.println("Signature is invalid");
		}
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		String userValidated = "";
		// Get the authorization header (if it exists)
		  HttpServletRequest request = (HttpServletRequest) arg0;
		String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
		String token = "fail";
		// If there is no authorization header, do nothing
		if( authorization == null || !authorization.startsWith("Bearer ")) 
			return;
		
		// Whether or not this request is over HTTPS
		boolean secure = request.isSecure();
		
		// Extract the token from the HTTP Authorization header
        token = authorization.substring("Bearer".length()).trim();
        System.out.println(token);
       
        
		try {

            // Validate the token
            userValidated = validateToken(token);
            
        } catch (Exception e) {
           
        }
		if(!userValidated.equals("")){
			
			
			
			
			
			
			arg2.doFilter(new UserPrincipalRequestWrapper(userValidated, null, request), arg1);
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}	
   
		
	
	}


