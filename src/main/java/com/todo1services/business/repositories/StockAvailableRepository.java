package com.todo1services.business.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.todo1services.model.entities.Inventory;
import com.todo1services.model.entities.Product;
import com.todo1services.model.entities.StockAvailable;

/**
 * 
 * @author ffvb
 * 
 */
@ApplicationScoped
public class StockAvailableRepository {

	@Inject
	private ProductRepository productRepository;
	@Inject
	private InventoryRepository inventoryRepository;

	@Transactional
	public List<StockAvailable> getStockAvailable() {
		List<StockAvailable> stockAvailableList = new ArrayList<>();
		for (Product element : productRepository.getProductList()) {
			stockAvailableList.add(addElement(element));
		}
		return stockAvailableList;
	}

	private StockAvailable addElement(Product element) {
		StockAvailable item = new StockAvailable();
		item.setProduct(element);
		item.setAmount(0l);
		for (Inventory itemInvetory : inventoryRepository.getByProduct(element)) {
			item.setAmount(item.getAmount().longValue() + itemInvetory.getAmount());
		}
		return item;
	}

}
