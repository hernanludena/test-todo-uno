package com.todo1services.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.todo1services.business.repositories.UserRepository;
import com.todo1services.model.entities.Account;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserApi {

	@Inject
	private UserRepository userRepository;

	@GET
	public List<Account> list() {
		return userRepository.getUserList();
	}

}
