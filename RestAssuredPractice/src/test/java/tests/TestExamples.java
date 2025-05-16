package tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

public class TestExamples {

	@Test
	public void testA() {
		RestAssured.useRelaxedHTTPSValidation();

		// Add your API key here
		String apiKey = "reqres-free-v1";

		Response response = RestAssured
				.given()
				.header("x-api-key", apiKey) // Use the correct header name provided by reqres.in
				.get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		

		// Inside your testA method, after the request:
		assertEquals(response.getStatusCode(), 200, "Expected HTTP 200 OK");
	}
}