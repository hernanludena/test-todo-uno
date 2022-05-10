package com.todo1services.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.todo1services.model.entities.util.ProductType;

/**
 * JPA entity.
 * 
 * @author ffvb
 * 
 */
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "productSeq", sequenceName = "product_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "productSeq")
	private Long id;
	private String code;
	private String names;
	private String description;
	private Long price;
	private Long cost;
	@Enumerated(EnumType.STRING)
	@Column(name = "product_type")
	private ProductType productType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNames() {
		return names;

	}

	public void setNames(String names) {
		this.names = names;

	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

}