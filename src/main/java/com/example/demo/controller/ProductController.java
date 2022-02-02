package com.example.demo.controller;

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
	void productDetail(@RequestBody Product product, Integer id) {
		productService.saveDetail(product, id);
	}
}
