package com.todo1services.business.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Product;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class ProductDao extends GenericDao<Product> {

	@Transactional
	public Product findItem(Long identifier) {
		return entityManager.find(Product.class, identifier);
	}

	@Transactional
	public List<Product> getProductList() {
		return entityManager.createQuery("select p from Product p", Product.class).getResultList();
	}

}