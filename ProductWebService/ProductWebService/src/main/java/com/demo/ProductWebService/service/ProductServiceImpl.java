package com.demo.ProductWebService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ProductWebService.dao.ProductDao;
import com.demo.ProductWebService.dto.ProductDTO;
import com.demo.ProductWebService.mapper.ProductDTOMapper;
import com.demo.ProductWebService.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	@Override
	public List<ProductDTO> getByCid(int cid) {
		List<Product> plist=pdao.findByCid(cid);
		List<ProductDTO> newplist=plist.stream().map(prod->ProductDTOMapper.maptoProductDTO(prod))
				.collect(Collectors.toList());
		return newplist;
	}
    
}
