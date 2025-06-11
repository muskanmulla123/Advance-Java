package SpringBootMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootMVC.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

}
