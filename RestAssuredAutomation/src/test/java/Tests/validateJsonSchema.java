package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class validateJsonSchema {
	@Test
	public void getUsersApi() {
		baseURI = "https://reqres.in/";
		given().get("api/users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
	}

}
