package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PUTPOSTDELETE {

	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request);

		baseURI = "https://reqres.in/api";
		
		given()
			.body(request.toJSONString())
		.when()
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job1", "Teacher");
		
		System.out.println(request);

		baseURI = "https://reqres.in";
		
		given()
			.body(request.toJSONString())
		.when()
			.patch("/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	@Test
	public void testDelete() {

		baseURI = "https://reqres.in";
		
		given()
			.when()
		.delete("/api/users/2")
			.then()
		.statusCode(204)
			.log().all();
		
	}
	
	
}
