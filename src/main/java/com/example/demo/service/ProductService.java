package com.example.demo.service;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ComponentRepository componentRepository;

	public Product save(@Valid Product product) {
		return productRepository.save(product);
	}

	public Iterable<Product> getProducts() {
		return productRepository.findAll();
	}



}
