package com.todo1services.facade;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.todo1services.business.repositories.AccountingRepository;
import com.todo1services.model.entities.Entrepreneurship;

@Path("/accounting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountingApi {

	@Inject
	private AccountingRepository accountingRepository;

	@GET
	public Entrepreneurship list() {
		return accountingRepository.getEntrepreneurship();
	}

	@POST
	@Path("/{capital}")
	public Response getById(@PathParam("capital") Long capital) {
		accountingRepository.capitalInvestment(capital);
		return Response.ok().build();
	}

}
