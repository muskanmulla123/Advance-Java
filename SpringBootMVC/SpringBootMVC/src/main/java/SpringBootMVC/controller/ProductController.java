package SpringBootMVC.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import SpringBootMVC.model.Product;
import SpringBootMVC.service.ProductService;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/viewproducts")
	public ModelAndView getAllProducts(HttpSession session) {
		   List<Product> plist=pservice.getAllProduct();
		   return new ModelAndView("displayproduct","plist",plist);
		
		
	}
	
	@GetMapping("/addnewproduct")
	public ModelAndView shownewform() {
		Product p=new Product();
		return new ModelAndView("productform","product",p);
		
	}
	
	@PostMapping("/insertproduct")
	public String save(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "productform";
        }
        pservice.saveProduct(product);
        return "redirect:/product/viewproducts";
    }
	
	@GetMapping("edit/{pid}")
	public String editProduct(@PathVariable("pid") int pid,Model model) {
		Product p=pservice.getById(pid);
		System.out.println(p);
		model.addAttribute("product",p);
		return "productupdateform";
		
		
	}
	
	@PostMapping("/updateproduct")
	public String updateProduct(@Valid @ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "productform";
        }
        pservice.updateProduct(product);
        return "redirect:/product/viewproducts";
    }
	
	@GetMapping("/delete/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		pservice.deleteProduct(pid);
		return new ModelAndView("redirect:/product/viewproducts");
	}
	
	
	

}
