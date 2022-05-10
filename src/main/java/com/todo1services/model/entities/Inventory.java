package com.todo1services.model.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * JPA entity.
 * 
 * @author ffvb
 * 
 */
@Entity
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "inventorySeq", sequenceName = "inventory_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "inventorySeq")
	private Long id;
	@ManyToOne
	private Product product;
	private Long amount;
	@Column(name = "total_cost")
	private Long totalCost;
	@Column(name = "unit_value")
	private Long unitValue;
	@Column(name = "date_durchase")
	private Instant dateDurchase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public Long getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Long unitValue) {
		this.unitValue = unitValue;
	}

	public Instant getDateDurchase() {
		return dateDurchase;
	}

	public void setDateDurchase(Instant dateDurchase) {
		this.dateDurchase = dateDurchase;
	}

}
