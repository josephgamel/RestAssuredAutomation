package Tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetAndPostRequests {
	@Test
	public void testPostRequest() {
		Map<String,Object> map = new HashMap<String, Object>();

		JSONObject request = new JSONObject();
		request.put("name", "Joseph");
		request.put("job", "QC");

		baseURI = "https://reqres.in/api" ; 
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/users").
		then().
		statusCode(201).
		log().all();


	}
	@Test
	public void testPutRequest() {
		Map<String,Object> map = new HashMap<String, Object>();

		JSONObject request = new JSONObject();
		request.put("name", "Joseph");
		request.put("job", "QC");

		baseURI = "https://reqres.in/api" ; 
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/users/2").
		then().
		statusCode(200).
		log().all();


	}
	@Test
	public void testDeleteRequest() {
		
		baseURI = "https://reqres.in/api" ; 
		when().delete("/users/2").
		then().
		statusCode(204).
		log().all();


	}

}
