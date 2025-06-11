package com.demo.ProductWebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ProductWebService.dto.ProductDTO;
import com.demo.ProductWebService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products/{cid}")
	public ResponseEntity<List<ProductDTO>> getAllproductByCid(@PathVariable int cid){
		List<ProductDTO> plist=pservice.getByCid(cid);
		return ResponseEntity.ok(plist);
		
	}
	

}
