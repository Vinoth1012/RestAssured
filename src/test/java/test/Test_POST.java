package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test_POST {

	
	@Test
	public void testPost() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Raghav");
//		map.put("job", "Teacher");
		
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request);

		baseURI = "https://reqres.in/api";
		
		given()
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}

	
}
