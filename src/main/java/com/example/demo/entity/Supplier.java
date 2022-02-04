package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer supplier_id;
	
	@NotBlank
	String supplier_name;
	
	@ManyToMany(mappedBy = "supplierSet", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("supplierSet")
	private Set<Component> componentSet = new HashSet<>() ;

	public Set<Component> getComponentSet() {
		return componentSet;
	}

	public void setComponentSet(Set<Component> componentSet) {
		this.componentSet = componentSet;
	}

	public Integer getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	
}
