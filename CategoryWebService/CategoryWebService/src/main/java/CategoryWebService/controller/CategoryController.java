package CategoryWebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import CategoryWebService.dto.ProductCategoryDTO;
import CategoryWebService.dto.ProductDTO;
import CategoryWebService.model.Category;
import CategoryWebService.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/categories/{cid}")
	public ResponseEntity<ProductCategoryDTO> getById(@PathVariable int cid) {
		Category c=cservice.findById(cid);
		
		//get all products from the given category List<ProductDTO>
		String url = "http://localhost:8686/product/products/"+cid;
		//RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>() {}
        );
		List<ProductDTO> plist=response.getBody();
		System.out.println(plist);
		System.out.println(c);
        ProductCategoryDTO newprod=new ProductCategoryDTO(c, plist);
		
		return ResponseEntity.ok(newprod);
		
		
	}

}
