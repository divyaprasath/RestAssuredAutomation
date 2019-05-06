package com.rest.test;

import com.rest.base.BaseApiTest;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

import io.restassured.response.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuresApiTest extends BaseApiTest {

	@Test(priority = 0)
	public void get() {

		given().when().get(endPoint + "?page=2").then().statusCode(200);
	}

	@Test(priority = 1)
	public void getResponse() {

		Response response;
		response = given().when().get(endPoint + "?page=2").then().statusCode(200).extract().response();
		System.out.println("this is a response-->" + response.asString());
	}

	/*
	 * @Test public void getResponseFromParticularUser() {
	 * 
	 * ResponseBody response;
	 * given().when().get(endPoint+"?page=2").then().assertThat().statusCode(200).
	 * body("[2].id", equalTo(6)).body("[2].first_name",equalTo("Tracey"));
	 * 
	 * }
	 */
	@Test(priority = 2)
	public void postMethod() {
		given().contentType(ContentType.JSON)
				.body("{\"id\":\"3\"," + "\"first_name\":\"Div\"," + "\"last_name\":\"Vi\"}").when()
				.post(endPoint + "?page=2").then().statusCode(201);
	}

	@Test(priority = 3)
	public void postMethodResponse() {
		Response response;
		response = given().contentType(ContentType.JSON)
				.body("{\"id\":\"3\"," + "\"first_name\":\"Div\"," + "\"last_name\":\"Vi\"}").when()
				.post(endPoint + "?page=2").then().statusCode(201).extract().response();
		System.out.println("this is a response-->" + response.asString());
		System.out.println("created id no: " + response.path("id"));
		System.out.println("created first_name: " + response.path("first_name"));

	}

	@Test(priority = 4)
	public void postMethodResponse1() {
		Response response;
		response = given().contentType(ContentType.JSON)
				.body("{\"id\":\"3\"," + "\"first_name\":\"Div\"," + "\"last_name\":\"Vi\"}").when()
				.post(endPoint + "?page=2").then().statusCode(201).extract().response();
		// System.out.println("this is a response-->" + response.asString());
		System.out.println("created id no: " + response.path("id"));

		// System.out.println("created first_name: " + response.path("first_name"));
		Assert.assertEquals(response.path("id"), "3");
	}

	@Test(priority = 5)
	public void putMethod() {
		Response response;
		response = given().contentType(ContentType.JSON)
				.body("{\"id\":\"3\"," + "\"first_name\":\"pra\"," + "\"last_name\":\"Vi\"}").when()
				.put(endPoint + "?page=2").then().statusCode(200).extract().response();
		System.out.println("mofified first_name: " + response.path("first_name"));

	}

	@Test(priority = 6)
	public void delete() {
		Response response;
		response = given().contentType(ContentType.JSON).delete(endPoint + "/3?page=2").then().statusCode(204).extract()
				.response();
		System.out.println("response after delete method-->" + response.asString());
	}
}
