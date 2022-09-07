package org.acme.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name; 
	
	private String description; 
	
	private String category; 
	
	private String model; 
	
	private BigDecimal unitPrice;
	
	private LocalDateTime createAt;
	
	private LocalDateTime updateAt;
	
	public Product() {
		
	}
	
	public Product(String name, String description, String category, String model, BigDecimal unitPrice) {
		this.name = name;
		this.description = description; 
		this.category = category; 
		this.model = model; 
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setUnitPrince(BigDecimal unitPrince) {
		this.unitPrice = unitPrince;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist
	public void dateCreateEntity() {
		setCreateAt(LocalDateTime.now());
	}
	
	@PreUpdate
	public void dateUpdateEntity() {
		setUpdateAt(LocalDateTime.now());
	}
}
