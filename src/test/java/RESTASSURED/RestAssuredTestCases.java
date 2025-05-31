package RESTASSURED;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class RestAssuredTestCases {

	@Test
	public void getUser() {
		
		/*
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://reqres.in/");
		res.basePath("/api/users");
		res.queryParam("page", 2);
		
		Response response = res.get();
		System.out.println(response.getStatusCode());
		
		ResponseBody responseBody = response.getBody();
		
		/*
		 * PRINT RESPONSE BODY
		 */
		/*System.out.println(responseBody.asPrettyString());
		
		if(responseBody.asPrettyString().contains("George")) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		JsonPath path = responseBody.jsonPath();
		
		String actualName = path.get("data[1].last_name").toString();
		String expectedName = "Ferguson";
		
		System.out.println(actualName);
		System.out.println(expectedName);
		
		*/
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://reqres.in");
		res.basePath("/api/users");
		res.queryParam("page", 2);
		
		Response response = res.get();
		JsonPath path1 = response.jsonPath();
		
		ResponseBody responseBody = response.getBody();
		int responseCode = response.getStatusCode();
		
		System.out.println("Response Status line: "+response.getStatusLine());
		System.out.println("Response Body is: "+ responseBody.asPrettyString());
		
		int expectedId = 7;
		String expectedEmail="michael.lawson@reqres.in";
		String expectedFirstName = "Michael";
		String expectedLastName = "Lawson";
		
		
		JsonPath path = responseBody.jsonPath(); 
		
		int actualId = path.get("data[0].id");
		String actualFirstName = path.get("data[0].first_name");
		String actualLastName = path.get("data[0].last_name");
		String actualEmailId = path.get("data[0].email");
		
		Assert.assertEquals(actualId, expectedId);
		Assert.assertEquals(actualFirstName, expectedFirstName);
		Assert.assertEquals(actualLastName, expectedLastName);
		Assert.assertEquals(actualEmailId, expectedEmail);
		
		/************************
		 *  How can you check if the API response contains a key named "data"?
		 */
		
		/*if(responseBody.asString().contains(path.get("data").toString())) {
			System.out.println("HTTP response contains data keyword in it");
		}*/
		
		/********************************
		 * Q1: Rewrite your code to extract all user emails from the JSON response.
		 */
		/*List<String> userEmails = new ArrayList<>();
		for(int i=0; i<6; i++) {
			String currentEmail = path.get("data["+ i +"].email").toString();
			userEmails.add(currentEmail);
		}
		System.out.println(userEmails);*/
		
		
		List<String> userEmails = path.getList("data.email");
		System.out.println(userEmails);
		
		
		/*********************
		 * Q2: How can you check if the API response contains a key named "data"?
		 */
		System.out.println("\n");
		System.out.println("\n");
		// difference between responseBody.toString() and responseBody.asPrettyString()
		System.out.println("Printing response body as string: "+responseBody.toString());
		
		//first approach
		if( responseBody.asPrettyString().contains("data")  ) {
			System.out.println("data - keyword exists in response body");
		}else{
			System.out.println("data - keyword does not exists in response body");
		}
		
		//second approach 
		
		
		
	}
}
