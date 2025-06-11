package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myuser24")
public class User {
   @Id	
   private int uid;
   private String username;  
   private String Password;
   private String email;
   
	public User() {
		super();
	}

	public User(int uid, String userName, String password, String email) {
		super();
		this.uid = uid;
		this.username = userName;
		Password = password;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", Password=" + Password + ", email=" + email + "]";
	}

	
	
	
   
}
