package com.todo1services.model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * JPA entity.
 * 
 * @author ffvb
 * 
 */
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "customerSeq", sequenceName = "customer_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "customerSeq")
	private Long id;
	private String names;
	private String surname;
	private String phone;
	private String address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Account account;

	public Customer() {
		this.account = new Account();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
