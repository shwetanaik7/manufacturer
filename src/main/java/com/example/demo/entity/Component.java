package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Component {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer component_id;

	@NotBlank
	@NotEmpty
	@Size(max = 25)
	String component_name;

	@NotBlank
	@Size(max = 50)
	String description;

	String supplier_name;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "product_id")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("product_id")
	private Product product;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "component_supplier", joinColumns = @JoinColumn(name = "component_id"), inverseJoinColumns = @JoinColumn(name = "suppler_id"))
	private Set<Supplier> supplierSet = new HashSet<>();
	
	public Set<Supplier> getSupplierSet() {
		return supplierSet;
	}

	public void setSupplierSet(Set<Supplier> supplierSet) {
		this.supplierSet = supplierSet;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getComponent_id() {
		return component_id;
	}

	public void setComponent_id(Integer component_id) {
		this.component_id = component_id;
	}

	public String getComponent_name() {
		return component_name;
	}

	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

}
