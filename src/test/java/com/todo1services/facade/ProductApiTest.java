package com.todo1services.facade;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductApiTest {

	@Test
	public void testList() {
		given().when().get("/product").then().statusCode(200);
	}

	@Test
	public void testGetById() {
		given().when().get("/product/3").then().statusCode(204);
	}
	
}
