package com.demo.ProductWebService.service;

import java.util.List;

import com.demo.ProductWebService.dto.ProductDTO;

public interface ProductService {

	List<ProductDTO> getByCid(int cid);

}
