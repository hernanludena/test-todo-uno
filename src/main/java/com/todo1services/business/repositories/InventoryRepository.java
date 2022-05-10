package com.todo1services.business.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.todo1services.business.dao.InventoryDao;
import com.todo1services.model.entities.Entrepreneurship;
import com.todo1services.model.entities.Inventory;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class InventoryRepository extends InventoryDao {

	@Inject
	private AccountingRepository accountingRepository;
	@Inject
	private ProductRepository productRepository;

	@Transactional
	public String merchandiseEntry(Inventory element) {
		Entrepreneurship entrepreneurship = accountingRepository.getEntrepreneurship();
		element.setProduct(productRepository.findItem(element.getProduct().getId()));
		if (entrepreneurship.getCapital() == null || entrepreneurship.getCapital().longValue() == 0
				|| calculateAvailableCapital(element, entrepreneurship.getCapital())) {
			return "There is no investment capital";
		} else {
			element.setUnitValue(element.getProduct().getCost());
			this.create(element);
			this.updateCapital(entrepreneurship, element);
			accountingRepository.update(entrepreneurship);
		}
		return "Correct entry of merchandise";
	}

	private boolean calculateAvailableCapital(Inventory element, Long capital) {
		return calculateTotalCost(element) > capital.doubleValue();
	}

	private double calculateTotalCost(Inventory element) {
		double total = (element.getAmount().doubleValue() * element.getProduct().getCost().doubleValue());
		element.setTotalCost(Double.valueOf(total).longValue());
		return total;
	}

	private void updateCapital(Entrepreneurship entrepreneurship, Inventory element) {
		if (entrepreneurship.getExpenses() == null) {
			entrepreneurship.setExpenses(0l);
		}
		entrepreneurship.setExpenses(entrepreneurship.getExpenses().longValue() + element.getTotalCost().longValue());
		entrepreneurship.setCapital(entrepreneurship.getCapital().longValue() - element.getTotalCost().longValue());
	}

}