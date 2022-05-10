package com.todo1services.model.entities;

import java.io.Serializable;

public class StockAvailable implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product product;
	private Long amount;

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

}
