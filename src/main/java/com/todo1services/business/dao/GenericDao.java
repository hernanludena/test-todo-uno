package com.todo1services.business.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class GenericDao<T> {

	@Inject
	protected EntityManager entityManager;

	@Transactional
	public T create(final T entityTable) {
		entityManager.persist(entityTable);
		entityManager.flush();
		entityManager.refresh(entityTable);
		return entityTable;
	}

	@Transactional
	public void update(final T entityTable) {
		entityManager.merge(entityTable);
		entityManager.flush();
	}

	@Transactional
	public void remove(final T entityTable) {
		entityManager.remove(entityManager.contains(entityTable) ? entityTable : entityManager.merge(entityTable));
	}

}
