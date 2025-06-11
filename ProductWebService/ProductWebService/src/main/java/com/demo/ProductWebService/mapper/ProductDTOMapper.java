package com.demo.ProductWebService.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.ProductWebService.dto.ProductDTO;
import com.demo.ProductWebService.model.Product;


public class ProductDTOMapper {
	
 public static ProductDTO maptoProductDTO(Product p) {
	 String ldt=p.getExpdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	return new ProductDTO(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),ldt,p.getCid()); 
	 
 }
 
 public static Product mapToProduct(ProductDTO pdto) {
	 LocalDate ldt=LocalDate.parse(pdto.getExpdatestr(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	 return new Product(pdto.getPid(),pdto.getPname(),pdto.getQty(),pdto.getPrice(),ldt,pdto.getCid());
 }
	
}
