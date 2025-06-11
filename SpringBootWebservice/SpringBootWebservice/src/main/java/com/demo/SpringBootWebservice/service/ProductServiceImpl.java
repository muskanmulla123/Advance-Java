package com.demo.SpringBootWebservice.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootWebservice.dao.ProductDao;
import com.demo.SpringBootWebservice.dto.ProductDTO;
import com.demo.SpringBootWebservice.mapper.ProductDTOMapper;
import com.demo.SpringBootWebservice.model.Product;



@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	public List<ProductDTO> getAllProduct() {
		List<Product> plist= pdao.findAll();
		List<ProductDTO> newplist=plist.stream()
				        .map(prod->ProductDTOMapper.maptoProductDTO(prod))
				        .collect(Collectors.toList());
		return newplist;
	}
	
	//@Override
	public ProductDTO getById(int pid) {
			Product p= pdao.getById(pid);
			if(p!=null) {
			    return ProductDTOMapper.maptoProductDTO(p);
			 }
			return null;
		}

	//@Override
	/*public void saveProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		pdao.insertProduct(product);
		
	}

	

	//@Override
	public void updateProduct(ProductDTO pdto) {
		Product product=ProductDTOMapper.mapToProduct(pdto);
		pdao.modifyProduct(product);
		
	}

	//@Override
	public void deleteProduct(int pid) {
		pdao.removeById(pid);
		
	}*/
}
