package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.dto.ProductDTO;
import com.demo.mapper.ProductDTOMapper;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	public List<ProductDTO> getAllProduct() {
		List<Product> plist= pdao.findAllProduct();
		List<ProductDTO> newplist=plist.stream()
				        .map(prod->ProductDTOMapper.maptoProductDTO(prod))
				        .collect(Collectors.toList());
		return newplist;
	}

	//@Override
	public void saveProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		pdao.insertProduct(product);
		
	}

	//@Override
	public ProductDTO getById(int pid) {
		Product p= pdao.findById(pid);
		if(p!=null) {
		    return ProductDTOMapper.maptoProductDTO(p);
		 }
		return null;
	}

	//@Override
	public void updateProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		pdao.modifyProduct(product);
		
	}

	//@Override
	public void deleteProduct(int pid) {
		pdao.removeById(pid);
		
	}
}
