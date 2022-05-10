package com.todo1services.business.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Inventory;
import com.todo1services.model.entities.Product;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class InventoryDao extends GenericDao<Inventory> {

	@Transactional
	public List<Inventory> getInventoryList() {
		return entityManager.createQuery("select c from Inventory c ", Inventory.class).getResultList();
	}

	@Transactional
	public List<Inventory> getByProduct(Product element) {
		return entityManager.createQuery("select c from Inventory c where c.product = :element", Inventory.class)
				.setParameter("element", element).getResultList();
	}

}
