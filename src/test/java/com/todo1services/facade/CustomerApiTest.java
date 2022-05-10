package com.todo1services.facade;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CustomerApiTest {

	@Test
	public void testList() {
		given().when().get("/customer").then().statusCode(200);
	}

	@Test
	public void testGetById() {
		given().when().get("/customer/1").then().statusCode(200);
	}
	
}
