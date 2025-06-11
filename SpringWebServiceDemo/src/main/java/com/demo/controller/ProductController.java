package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ProductDTO;
import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    
	@Autowired
	ProductService pservice;
	
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> plist=pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDTO> getById(@PathVariable int pid){
		ProductDTO p=pservice.getById(pid);
		if(p!=null)
		    return ResponseEntity.ok(p);
		else {
			return ResponseEntity.status(500).body(null);
		}
	}
	
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> insertProduct(@RequestBody ProductDTO pdto){
		pservice.saveProduct(pdto);
		return ResponseEntity.ok("Data added successfully");
		
	}
	
	
	//update data
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO pdto){
		pservice.updateProduct(pdto);
		return ResponseEntity.ok("Data updated successfully");
		
	}
	
	
	//delete data
		@DeleteMapping("/products/{pid}")
		public ResponseEntity<String> deleteProduct(@PathVariable int pid){
			pservice.deleteProduct(pid);
			return ResponseEntity.ok("Data deleted successfully");
			
		}
	
}
