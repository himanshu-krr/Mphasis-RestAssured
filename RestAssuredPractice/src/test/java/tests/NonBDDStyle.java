package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class NonBDDStyle {

    String baseUrl = "https://reqres.in/api";
    String key = "reqres-free-v1";

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "harry");
        request.put("job", "automation tester");

        baseURI = baseUrl;
        useRelaxedHTTPSValidation();

        Response res = given()
                .header("x-api-key", key)
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
            .when()
                .put("/users/2");

        System.out.println("Response: " + res.asPrettyString());

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(res.asString().contains("harry"));
        Assert.assertTrue(res.asString().contains("automation tester"));
    }

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "messi");
        request.put("job", "footballer");

        baseURI = baseUrl;
        useRelaxedHTTPSValidation();

        Response res = given()
                .header("x-api-key", key)
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
            .when()
                .patch("/users/2");

        System.out.println("Response: " + res.asPrettyString());

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertTrue(res.asString().contains("messi"));
        Assert.assertTrue(res.asString().contains("footballer"));
    }

    @Test
    public void testDelete() {
        baseURI = baseUrl;
        useRelaxedHTTPSValidation();

        Response res = given()
                .contentType(ContentType.JSON)
                .header("x-api-key", key)
            .when()
                .delete("/users/2");

        System.out.println("Response: " + res.getStatusCode());

        Assert.assertEquals(res.getStatusCode(), 204); // No content expected
        Assert.assertEquals(res.getBody().asString(), ""); // Confirming empty response
    }
}
