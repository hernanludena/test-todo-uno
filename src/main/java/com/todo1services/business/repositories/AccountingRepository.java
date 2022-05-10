package com.todo1services.business.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.todo1services.business.dao.EntrepreneurshipDao;
import com.todo1services.model.entities.Entrepreneurship;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class AccountingRepository extends EntrepreneurshipDao {

	@Transactional
	public void capitalInvestment(Long capital) {
		Entrepreneurship entrepreneurship = this.getEntrepreneurship();
		if (entrepreneurship.getCapital() == null) {
			entrepreneurship.setCapital(0l);
		}
		entrepreneurship.setCapital(entrepreneurship.getCapital().longValue() + capital.longValue());
		if (entrepreneurship.getId() == null) {
			this.create(entrepreneurship);
		} else {
			this.update(entrepreneurship);
		}
	}

}
