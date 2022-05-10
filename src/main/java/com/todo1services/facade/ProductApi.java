package com.todo1services.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.todo1services.business.repositories.ProductRepository;
import com.todo1services.model.entities.Product;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApi {

	@Inject
	private ProductRepository productRepository;

	@GET
	public List<Product> list() {
		return productRepository.getProductList();
	}

	@GET
	@Path("/{id}")
	public Product getById(@PathParam("id") Long id) {
		return productRepository.findItem(id);
	}

	@POST
	public Response add(Product element) {
		productRepository.create(element);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Long id) {
		productRepository.remove(productRepository.findItem(id));
		return Response.ok().build();
	}

	@PUT
	public Response update(Product element) {
		Product product = productRepository.findItem(element.getId());
		product.setCode(element.getCode());
		product.setNames(element.getNames());
		product.setDescription(element.getDescription());
		product.setPrice(element.getPrice());
		product.setProductType(element.getProductType());
		productRepository.update(product);
		return Response.ok().build();
	}

}