package RESTASSURED;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTASSURED_BASIC_AUTHORIZATION {

	@Test
	public void TC01() {
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://postman-echo.com");
		res.basePath("/basic-auth");
		Response response = res.get();
		
		System.out.println("BEFORE AUHTORIZATION");
		
		System.out.println("Response Body: "+response.asPrettyString());
		System.out.println("Response Code: "+ response.getStatusLine());
		System.out.println("\n");
		
		res.auth().basic("postman", "password");
		Response newResponse = res.get();
		System.out.println("AFTER AUHTORIZATION");
		System.out.println("Response Body: "+newResponse.asPrettyString());
		System.out.println("Response Code: "+ newResponse.getStatusLine());
		
		
		
		
		/**************************************************************
		 * How would you add an Authorization header if the API required authentication?
		 */
		
		

		
	}
}
