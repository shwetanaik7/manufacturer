package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Component;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ComponentService;

@RestController
public class ComponentController {
	@Autowired
	ComponentService componentService;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ComponentRepository componentRepository;

	@PostMapping("/component/{id}")
	public Component addComponent(@PathVariable(value = "id") Integer id, @Valid @RequestBody Component component) {
		return productRepository.findById(id).map(product -> {
			component.setProduct(product);
			return componentRepository.save(component);
		}).orElseThrow(() -> new ResourceNotFoundException("id " + id + " not found"));
	}
	
	@PostMapping("/comp/{id}")
	public List<Component> saveBook(@RequestBody List<Component> componentList, Integer id) {
		List<Component> compResponse = (List<Component>) componentService.saveBook(componentList, id);
		return compResponse;
	}
}
