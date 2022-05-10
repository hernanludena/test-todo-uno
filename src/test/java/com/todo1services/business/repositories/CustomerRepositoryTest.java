package com.todo1services.business.repositories;

import static org.mockito.Mockito.when;

import com.todo1services.model.entities.Customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class CustomerRepositoryTest {

	@InjectMock
	private CustomerRepository customerRepository;

	@Test
	public void testGetCustomerList() {
		Assertions.assertNotNull(customerRepository.getCustomerList(), "Test getCustomerList()");
	}

	@Test
	public void testFindItem() {
		when(customerRepository.findItem(1l)).thenReturn(new Customer());
		Assertions.assertNotNull(customerRepository.findItem(1l), "validate repository");
	}

	@Test
	public void testCrud() {
		Customer element = new Customer();
		customerRepository.create(element);
		customerRepository.update(element);
		customerRepository.remove(element);
		Assertions.assertNotNull(customerRepository, "create new instance");
	}

}
