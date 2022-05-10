package com.todo1services.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.todo1services.business.repositories.CustomerRepository;
import com.todo1services.model.entities.Customer;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerApi {

	@Inject
	private CustomerRepository customerRepository;

	@GET
	public List<Customer> list() {
		return customerRepository.getCustomerList();
	}

	@GET
	@Path("/{id}")
	public Customer getById(@PathParam("id") Long id) {
		return customerRepository.findItem(id);
	}

	@POST
	public Response add(Customer element) {
		customerRepository.create(element);
		return Response.ok().build();
	}

	@PUT
	public Response update(Customer element) {
		Customer customer = customerRepository.findItem(element.getId());
		customer.setNames(element.getNames());
		customer.setSurname(element.getSurname());
		customer.setPhone(element.getPhone());
		customer.setAddress(element.getAddress());
		customerRepository.update(customer);
		return Response.ok().build();
	}

}
