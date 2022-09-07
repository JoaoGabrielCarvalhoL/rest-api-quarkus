package org.acme.dto;

import java.math.BigDecimal;

public class ProductDTO {

	private String name;
	
	private String description; 
	
	private String category; 
	
	private String model; 
	
	private BigDecimal unitPrice;
	
	public ProductDTO(String name, String description, String category, String model, BigDecimal unitPrice) {
		this.name = name;
		this.description = description; 
		this.category = category; 
		this.model = model; 
		this.unitPrice = unitPrice;
	}

	public ProductDTO() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
