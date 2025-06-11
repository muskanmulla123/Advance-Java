package com.demo.SpringBootWebservice.service;

import java.util.List;

import com.demo.SpringBootWebservice.dto.ProductDTO;





public interface ProductService {

	List<ProductDTO> getAllProduct();
	ProductDTO getById(int pid);

	/*void saveProduct(ProductDTO product);

	

	void updateProduct(ProductDTO product);

	void deleteProduct(int pid);*/

}
