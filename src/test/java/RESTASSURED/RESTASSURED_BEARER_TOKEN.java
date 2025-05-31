package RESTASSURED;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTASSURED_BEARER_TOKEN {

	@Test
	public void TC01() {
		
		   Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("name", "Kanak");
	        requestBody.put("gender", "male");
	        requestBody.put("email", "kanak.tandon@citizenbank.com");
	        requestBody.put("status", "active");

	        // Setting up RestAssured request
	        RequestSpecification res = RestAssured.given();
	        res.baseUri("https://gorest.co.in");
	        res.basePath("/public/v2/users");

	        // Authorization Token (Replace with a valid one)
	        res.auth().oauth2("d5325f641a643e1478ad88a9f8f584c159aebac70a638239a66eaebbfedeb290");

	        // Setting Header
	        res.header("Content-Type", "application/json");

	        // Attaching the request body
	        res.body(requestBody);

	        // Sending POST request
	        Response response = res.post();

	        // Printing response
	        System.out.println(response.asPrettyString());
	        
	        int id = response.jsonPath().getInt("id");
	        System.out.println("USER ID IS: "+ id);
	        res.basePath("/public/v2/users"+"/"+id);
	        Response newResponse = res.get();
	        System.out.println("response body: "+ newResponse.getBody().asPrettyString());
		
		
		
		

		
	}
}
