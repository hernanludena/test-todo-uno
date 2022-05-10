package com.todo1services.business.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Entrepreneurship;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class EntrepreneurshipDao extends GenericDao<Entrepreneurship> {

	@Transactional
	public Entrepreneurship findItem(Long identifier) {
		return entityManager.find(Entrepreneurship.class, identifier);
	}

	@Transactional
	public Entrepreneurship getEntrepreneurship() {
		List<Entrepreneurship> elements = entityManager
				.createQuery("select e from Entrepreneurship e", Entrepreneurship.class).getResultList();
		if (elements == null || elements.isEmpty()) {
			return new Entrepreneurship();
		} else {
			return elements.get(0);
		}
	}

}
