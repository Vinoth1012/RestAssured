package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class FirstTest_API {

	
	@Test
	void test_01() {
		Response resp = get("https://reqres.in/api/users?page=2");
		
		System.out.println(resp.asString());
		System.out.println(resp.getBody().asString());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getHeader("content-type"));
		System.out.println(resp.getTime());
		
		
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	
	@Test
	void test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
		.body("data.id[0]", equalTo(7));
		
		
	}
	
	
}