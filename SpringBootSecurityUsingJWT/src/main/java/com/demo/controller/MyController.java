package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AuthRequest;
import com.demo.util.JwtUtil;

@RestController
public class MyController {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!!";
	}
	
	 @PostMapping("/authenticate")
	  public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
	        try {
	        	//it will check whether username and password is valid
	        	//if valid, then it will call generateToken method
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        String jwttoken=jwtUtil.generateToken(authRequest.getUserName());
	        return jwttoken;
	    }

}
