package com.demo.SpringBootWebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootWebservice.dto.ProductDTO;
import com.demo.SpringBootWebservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllproducts(){
		List<ProductDTO> plist=pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDTO> getById(@PathVariable int pid){
		ProductDTO prod=pservice.getById(pid);
		return ResponseEntity.ok(prod);
	}

}
