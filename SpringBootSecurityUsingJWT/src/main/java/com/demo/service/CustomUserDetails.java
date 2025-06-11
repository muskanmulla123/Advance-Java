package com.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.beans.User;

public class CustomUserDetails implements UserDetails{
     private User user;
     
	public User getUser() {
		System.out.println("in getuser CustomUserDetails");
		return user;
	}

	public void setUser(User user) {
		System.out.println("in setuser CustomUserDetails");
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("in getAuthorities CustomUserDetails");
		return new ArrayList<GrantedAuthority>();
	}

	public String getPassword() {
		System.out.println("in getPassword CustomUserDetails");
		return user.getPassword();
	}

	public String getUsername() {
		System.out.println("in getusername CustomUserDetails");
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
