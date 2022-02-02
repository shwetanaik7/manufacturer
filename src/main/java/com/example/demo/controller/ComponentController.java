package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Component;
import com.example.demo.service.ComponentService;

@RestController
public class ComponentController {
	@Autowired
	ComponentService componentService;
	
	@PostMapping("/component")
	void componentDetail(@RequestBody Component component, Integer id) {
		componentService.saveComponent(component, id);
	}
}
