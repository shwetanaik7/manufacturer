package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Component;
import com.example.demo.entity.Product;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ComponentRepository componentRepository;

	public void saveDetail(Product product, Integer id) {
		Component component = componentRepository.findById(id).get();
		component.getProduct().add(product);
		productRepository.save(product);		
	}

}
