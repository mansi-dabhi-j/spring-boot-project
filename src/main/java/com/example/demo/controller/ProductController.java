package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	
	public String showProducts(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
		return "products";
		
	}

	
}
