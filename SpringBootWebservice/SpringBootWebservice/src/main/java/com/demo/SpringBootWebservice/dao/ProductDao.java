package com.demo.SpringBootWebservice.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.SpringBootWebservice.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

}
