package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

public class PutPatchDelete {
	
	@Test
	public void testPut()
	{
		JSONObject r = new JSONObject();
		r.put("name","harry");
		r.put("job","automation tester");
		
		
		
		baseURI = "https://reqres.in/api";
		
		useRelaxedHTTPSValidation();
		
		String key = "reqres-free-v1";
		
		given()
			.header("x-api-key", key)
			.body(r.toJSONString())
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testPatch()
	{
		JSONObject r = new JSONObject();
		r.put("name","messi");
		r.put("job","footballer");
		
		
		
		baseURI = "https://reqres.in/api";
		
		useRelaxedHTTPSValidation();
		
		String key = "reqres-free-v1";
		
		given()
			.header("x-api-key", key)
			.body(r.toJSONString())
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testDelete()
	{		
		
		baseURI = "https://reqres.in/api";
		
		useRelaxedHTTPSValidation();
		
		String key = "reqres-free-v1";
		
		given()
			.contentType(ContentType.JSON)
			.header("x-api-key", key)
		.when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}
	
}
