package RESTASSURED;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PRACTISE {

	@Test
	public void TC01() {
		
		Map<String,Object> payload = new HashMap<>();
		payload.put("name", "Hercule Poirot");
		payload.put("email", "HerculePoirot@testUser001");
		payload.put("gender", "male");
		payload.put("status", "inactive");
		
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://gorest.co.in");
		res.basePath("/public/v2/users");
		
		res.header("Content-Type","application/json");
		res.auth().oauth2("d5325f641a643e1478ad88a9f8f584c159aebac70a638239a66eaebbfedeb290");
		res.body(payload);
		
		Response response = res.post();
		System.out.println(response.asPrettyString());
		
		
		
		
	}
}
