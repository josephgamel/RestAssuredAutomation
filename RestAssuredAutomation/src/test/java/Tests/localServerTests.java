package Tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class localServerTests {

	@Test
	public void getUsersApi() {
		baseURI = "http://localhost:3000/";
		given().get("/subjects").
		then().
		statusCode(200).log().all();
	}

	@Test
	public void postNewUser() {
		JSONObject request = new JSONObject();
		request.put("firstname" , "Rest");
		request.put("lastname" , "Assures");
		request.put("subjectid" , "1");

		baseURI = "http://localhost:3000/";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/users").
		then().statusCode(201).
		log().all();


	}
	@Test
	public void putNewUser() {
		JSONObject request = new JSONObject();
		request.put("firstname" , "Rest2");
		request.put("lastname" , "Assured");
		request.put("subjectid" , "4");

		baseURI = "http://localhost:3000/";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/users/4").
		then().statusCode(200).
		log().all();


	}
	
	@Test
	public void deleteNewUser() {
		baseURI = "http://localhost:3000/";
		when().delete("users/8").
		then().
		statusCode(200).
		log().all();
		


	}


}
