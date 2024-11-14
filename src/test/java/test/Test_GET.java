package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Test_GET {

	@Test
	public void test_01() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
		.body("data.id[1]", equalTo(8))
			.log().all();
		
	}
	
	
	@Test
	public void testHeadRequest() {
	    given()
	        .pathParam("userId", 1)
	    .when()
	        .head("https://jsonplaceholder.typicode.com/users/{userId}")
	    .then()
	        .statusCode(200);
	}

	
}
