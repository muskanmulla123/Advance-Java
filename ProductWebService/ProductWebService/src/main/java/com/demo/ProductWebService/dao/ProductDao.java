package com.demo.ProductWebService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.ProductWebService.model.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

	@Query(value="select * from product where cid=:cid",nativeQuery=true) 
	List<Product> findByCid(int cid);

}
