package com.vivek.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Login {

	  private String username;
	  private String password;
	  
	  public String getUsername() {
	  return username;
	  }
	  public void setUsername(String username) {
	  this.username = username;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public Login(String username, String password) {
		
		this.username = username;
		this.password = password;
	  }
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
	  

}
