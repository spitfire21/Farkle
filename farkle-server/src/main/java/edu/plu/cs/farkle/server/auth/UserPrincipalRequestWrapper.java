package edu.plu.cs.farkle.server.auth;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserPrincipalRequestWrapper extends HttpServletRequestWrapper{

		 
		 
		  String user;
		  List<String> roles = null;
		  HttpServletRequest realRequest;
		   
		  public UserPrincipalRequestWrapper(String user, List<String> roles, HttpServletRequest request) {
		    super(request);
		    this.user = user;
		    this.roles = roles;
		    this.realRequest = request;
//		    if (this.roles == null) {
//		      this.roles = new ArrayList<String>();
//		    }
		  }
		 
		  @Override
		  public boolean isUserInRole(String role) {
		    if (roles == null) {
		      return this.realRequest.isUserInRole(role);
		    }
		    return roles.contains(role);
		  }
		 
		  @Override
		  public UserPrincipal getUserPrincipal() {
		    if (this.user == null) {
		      return (UserPrincipal) realRequest.getUserPrincipal();
		    }
		     
		    // make an anonymous implementation to just return our user
		    return new UserPrincipal(user) {
		      @Override
		      public String getName() {     
		        return user;
		      }
		    };
		  }
		
}
