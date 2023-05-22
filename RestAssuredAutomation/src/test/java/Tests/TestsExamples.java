package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestsExamples {
	
	@Test
	public void firstTest() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void secondTest() {
		baseURI = "https://reqres.in/api" ; 
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).
		  body("data[1].id", equalTo(8))
		  .body("data[2].first_name", equalTo("Tobias")).
			log().all();
		
		
	}
	

}
