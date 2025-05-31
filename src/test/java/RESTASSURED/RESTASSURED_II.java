package RESTASSURED;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTASSURED_II {

	@Test
	public void TC01() {
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://reqres.in");
		res.basePath("/api/users");
		res.queryParam("page", 2);
		Response response = res.get();
		
		JsonPath path = response.jsonPath();
		System.out.print("RESPONSE BODY");
		System.out.println("\n");
		System.out.println(response.getBody().asPrettyString());
		System.out.println("\n");
		
		/*******************************************
		 * Q1: extract all user emails from the JSON response.
		 */
		System.out.print("EXTRACT ALL USER EMAILS FROM RESPONSE BODY");
		System.out.println("\n");
		List<String> userEmails= path.getList("data.email");
		System.out.println(userEmails);
		System.out.println("\n");
		
		
		/***********************************************
		 * Q2: check if the API response contains a key named "data"?
		 */
		
		System.out.print("validate whether the keyword data is present or not");
		System.out.println("\n");
		
		
		if (path.get("data") != null) {
		    System.out.println("data - key exists in response body");
		} else {
		    System.out.println("data - key does not exist in response body");
		}
		System.out.println("\n");
		
		
		/****************************************************
		 * extract all first_name values from the response
		 */
		
		List<String> firstNameList = path.getList("data.first_name");

		System.out.println("PRINT ALL FIRST NAMES FROM RESPONSE BODY");
		System.out.println(firstNameList);
		System.out.println("\n");
		
		
		/**************************************************************
		 * How would you add an Authorization header if the API required authentication?
		 */
		
		

		
	}
}
