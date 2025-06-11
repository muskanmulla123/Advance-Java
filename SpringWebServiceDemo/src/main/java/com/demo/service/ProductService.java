package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.dto.ProductDTO;
import com.demo.model.Product;

public interface ProductService {

	List<ProductDTO> getAllProduct();

	void saveProduct(ProductDTO product);

	ProductDTO getById(int pid);

	void updateProduct(ProductDTO product);

	void deleteProduct(int pid);

}
