package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/viewproducts")
	public ModelAndView getAllProducts(HttpSession session) {
		MyUser u=(MyUser)session.getAttribute("user");
		if(u!=null) {
		   List<Product> plist=pservice.getAllProduct();
		   return new ModelAndView("displayproduct","plist",plist);
		}
		return new ModelAndView("redirect:/mylogin");
		
	}
	
	@GetMapping("/addnewproduct")
	public ModelAndView shownewform() {
		Product p=new Product();
		return new ModelAndView("productform","product",p);
		
	}
	
	@PostMapping("/insertproduct")
	public String save(@Valid @ModelAttribute Product product, BindingResult result) throws IllegalStateException, IOException {
		//public String save(@ModelAttribute Product product) throws IllegalStateException, IOException {
       if (result.hasErrors()) {
        	System.out.println("in if");
        	System.out.println(result.getFieldErrors("image"));
        	System.out.println(result.getFieldErrors("field"));
            return "productform";
        }
		MultipartFile file = product.getFile();
	    if (file != null && !file.isEmpty()) {
	        String path = context.getRealPath("/resources/images/");
	        System.out.println(path);
	        String newfname = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	        file.transferTo(new File(path + newfname));
	        System.out.println("fname:  "+path + newfname);
	        product.setImage(newfname);
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
	public String updateProduct(@Valid @ModelAttribute Product product, BindingResult result) throws IllegalStateException, IOException {
        if (result.hasErrors()) {
            return "productform";
        }
        MultipartFile file=product.getFile();
        if(!file.isEmpty()) {
        	String path=context.getRealPath("/resources/images/");
        	String newfname=System.currentTimeMillis()+"_"+file.getOriginalFilename();
        	file.transferTo(new File(path+newfname));
        	product.setImage(newfname);
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
