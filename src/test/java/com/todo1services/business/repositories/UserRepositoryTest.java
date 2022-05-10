package com.todo1services.business.repositories;

import static org.mockito.Mockito.when;

import com.todo1services.model.entities.Account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class UserRepositoryTest {

	@InjectMock
	private UserRepository userRepository;

	@Test
	public void testGetCustomerList() {
		Assertions.assertNotNull(userRepository.getUserList(), "Test getCustomerList()");
	}

	@Test
	public void testFindItem() {
		when(userRepository.findItem(1l)).thenReturn(new Account());
		Assertions.assertNotNull(userRepository.findItem(1l), "validate repository");
	}

	@Test
	public void testCrud() {
		Account element = new Account();
		userRepository.create(element);
		userRepository.update(element);
		userRepository.remove(element);
		Assertions.assertNotNull(userRepository, "create new instance");
	}

}
