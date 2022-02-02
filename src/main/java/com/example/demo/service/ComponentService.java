package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Component;
import com.example.demo.entity.Product;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ComponentService {
	@Autowired
	ComponentRepository componentRepository;
	
	@Autowired
	ProductRepository productRepository;

	public void saveComponent(Component component, Integer id) {
		Product product = productRepository.findById(id).get();
		product.getComponent().add(component);
		componentRepository.save(component);
	}

}
