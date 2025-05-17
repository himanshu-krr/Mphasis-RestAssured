package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetAndPostExamples {
	
	@Test
	public void testGet()
	{
		
		baseURI = "https://reqres.in/api";
		
		useRelaxedHTTPSValidation();

		String apiKey = "reqres-free-v1";

		
		given()
		.header("x-api-key", apiKey)
		.get("/users?page=2").then().statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
	 @Test
	 public void testPost()
	 {
		 
		 JSONObject request = new JSONObject();
		 
		 request.put("name", "Himanshu");
		 request.put("job", "Tester");
		 
//		 System.out.println(request.toJSONString());
		 
		 baseURI = "https://reqres.in/api";

		 useRelaxedHTTPSValidation();

		 String apiKey = "reqres-free-v1";


		 given()
		 	.header("x-api-key", apiKey)
		 	.body(request.toJSONString())
		 .when()
		 	.post("/user")
		 .then()
		 	.statusCode(201).log().all();
		 
	 }

}
