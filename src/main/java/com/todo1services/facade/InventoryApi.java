package com.todo1services.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.todo1services.business.repositories.InventoryRepository;
import com.todo1services.business.repositories.StockAvailableRepository;
import com.todo1services.model.entities.Inventory;
import com.todo1services.model.entities.StockAvailable;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryApi {

	@Inject
	private InventoryRepository inventoryRepository;
	@Inject
	private StockAvailableRepository stockAvailableRepository;

	@GET
	public List<Inventory> list() {
		return inventoryRepository.getInventoryList();
	}

	@GET
	@Path("/stock-available")
	public List<StockAvailable> getStockAvailableList() {
		return stockAvailableRepository.getStockAvailable();
	}

	@POST
	public Response add(Inventory element) {
		return Response.ok(inventoryRepository.merchandiseEntry(element)).build();
	}

}
