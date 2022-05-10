package com.todo1services.business.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Account;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class UserDao extends GenericDao<Account> {

	@Transactional
	public Account findItem(Long identifier) {
		return entityManager.find(Account.class, identifier);
	}

	@Transactional
	public List<Account> getUserList() {
		return entityManager.createQuery("select u from User u", Account.class).getResultList();
	}
}
