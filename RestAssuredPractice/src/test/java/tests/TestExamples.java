package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

public class TestExamples {

	@Test
	public void testA() {
		useRelaxedHTTPSValidation();

		String apiKey = "reqres-free-v1";

		Response response = given()
				.header("x-api-key", apiKey)
				.get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 OK");
	}

	@Test 
	public void testB() {

		baseURI = "https://reqres.in/api";
		useRelaxedHTTPSValidation();

		String apiKey = "reqres-free-v1";

		given()
		.header("x-api-key", apiKey)
		.when()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8)); // BDD-style assertions only
	}
	
	
}