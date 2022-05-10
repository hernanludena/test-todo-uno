package com.todo1services.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * JPA entity.
 * 
 * @author ffvb
 * 
 */
@Entity
public class Entrepreneurship implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "entrepreneurshipSeq", sequenceName = "entrepreneurship_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "entrepreneurshipSeq")
	private Long id;
	private Long capital;
	private Long income;
	private Long expenses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapital() {
		return capital;

	}

	public void setCapital(Long capital) {
		this.capital = capital;

	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	public Long getExpenses() {
		return expenses;
	}

	public void setExpenses(Long expenses) {
		this.expenses = expenses;
	}

}
