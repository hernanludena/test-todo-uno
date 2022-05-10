package com.todo1services.business.repositories;

import static org.mockito.Mockito.when;

import com.todo1services.model.entities.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class ProductRepositoryTest {

	@InjectMock
	private ProductRepository productRepository;

	@Test
	public void testGetProductList() {
		Assertions.assertNotNull(productRepository.getProductList(), "Test getProductList()");
	}

	@Test
	public void testFindItem() {
		when(productRepository.findItem(1l)).thenReturn(new Product());
		Assertions.assertNotNull(productRepository.findItem(1l), "validate repository");
	}

	@Test
	public void testCrud() {
		Product element = new Product();
		productRepository.create(element);
		productRepository.update(element);
		productRepository.remove(element);
		Assertions.assertNotNull(productRepository, "create new instance");
	}

}