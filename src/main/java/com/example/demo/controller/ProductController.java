package com.example.demo.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public Product addProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }
}
