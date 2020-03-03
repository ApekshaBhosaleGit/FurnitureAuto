package com.project.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.services.UserDetails;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_UserDetailsAPI_002_2 {
	 
	@Test
	public void tc_UserDetailsAPI_002_2() {
		
		String serviceURI = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/login/signin";
		String statusCode_expected = "202";
		String emailID = "test123@gmail.com";
		String password = "Test@123";
		
		Response response = null;
		
		UserDetails userDetails = new UserDetails(emailID, password);
		
		response = RestAssured.given()
	            .contentType("application/json")
	            .body(userDetails)
	            .when()
	            .post(serviceURI);
		
		System.out.println("response : "+response.body().asString());
		int statusCode_actual = response.getStatusCode();
		Assert.assertEquals(statusCode_actual+"", statusCode_expected);

	}

}
