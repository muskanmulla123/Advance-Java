package SpringBootMVC.service;

import java.util.List;

import javax.validation.Valid;

import SpringBootMVC.model.Product;



public interface ProductService {

	List<Product> getAllProduct();

	void saveProduct(Product product);

	Product getById(int pid);

	void updateProduct(Product product);

	void deleteProduct(int pid);

}
