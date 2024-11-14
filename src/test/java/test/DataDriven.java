package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriven {

	
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {
		
//		Object[][] data = new Object[2][3];
		
//		data[0][0] = "Albert";
//		data[0][1] = "Einstein";
//		data[0][2] = 2;
		
//		data[1][0] = "Thomas";
//		data[1][1] = "Edison";
//		data[1][2] = 1;
		
//		return data;
		
		
		return new Object[][] {
			{"Graham", "Bell", 1}, 
			{"Henry", "Ford", 2}
		};
	}
	
	
	@Test (dataProvider = "DataForPost")
	public void post(String strFirstName, String strLastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", strFirstName);
		request.put("lastName", strLastName);
		request.put("subjectId", subjectId);
	
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
		
	}
	
	
	@DataProvider(name = "DeleteData")
	public Object[] dataForDelete() {
		
		return new Object[] {
				7,8
		};
	}
	
	
	@Test (dataProvider = "DeleteData")
	public void delete(int userId) {
		
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/" + userId)
		.then()
			.statusCode(200);
		
	}
	
	
}
