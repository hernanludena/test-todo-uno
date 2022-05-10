package com.todo1services.business.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Customer;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class CustomerDao extends GenericDao<Customer> {

	@Transactional
	public Customer findItem(Long identifier) {
		return entityManager.find(Customer.class, identifier);
	}

	@Transactional
	public List<Customer> getCustomerList() {
		return entityManager.createQuery("select c from Customer c join fetch c.account ", Customer.class).getResultList();
	}

}
