package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Component;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.ComponentRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ComponentService {
	@Autowired
	ComponentRepository componentRepository;

	@Autowired
	ProductRepository productRepository;

	public void saveComponent(Component component) {
		componentRepository.save(component);
	}

	public List<Component> saveBook(List<Component> componentList, Integer id) {
		Component comp1 = componentRepository.findById(id).get();

		Supplier supplier1 = new Supplier();

		supplier1.setSupplier_name(supplier1.getSupplier_name());
		comp1.getSupplierSet().add(supplier1);
		supplier1.getComponentSet().add(comp1);

		List<Component> compResponse = (List<Component>) componentRepository.saveAll(componentList);
		return compResponse;
	}

	public Iterable<Component> getComponents() {
		return componentRepository.findAll();
	}

	public Optional<Component> getComponents(Integer id) {
		return componentRepository.findById(id);
	}

}
