package SpringBootMVC.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootMVC.dao.ProductDao;
import SpringBootMVC.model.Product;



@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
	ProductDao pdao;

	public List<Product> getAllProduct() {
		return pdao.findAll();
	}

	@Override
	public void saveProduct(@Valid Product product) {
		pdao.save(product);
		
	}

	@Override
	public Product getById(int pid) {
		Optional<Product> ob=pdao.findById(pid);
		if(ob.isPresent()) {
			Product p=ob.get();
			return p;
		}
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		Optional<Product> ob=pdao.findById(product.getPid());
		if(ob.isPresent()) {
			Product p=ob.get();
			p.setPname(product.getPname());
			p.setQty(product.getQty());
			p.setPrice(product.getPrice());
			p.setMfgdate(product.getMfgdate());
			pdao.save(p);
		}
		
	}

	@Override
	public void deleteProduct(int pid) {
		pdao.deleteById(pid);
		
	}
}
