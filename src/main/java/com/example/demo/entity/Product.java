package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer product_id;
	
	@NotBlank
	@Size(max=25)
	String product_name;
	
	@Range(min=1)
	Integer quantity;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	@JoinTable(name = "product_component",
    joinColumns = { @JoinColumn(name = "product_id") },
    inverseJoinColumns = { @JoinColumn(name = "component_id") })
	Set<Component> component = new HashSet<>();

	public Set<Component> getComponent() {
		return component;
	}

	public void setComponent(Set<Component> component) {
		this.component = component;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
