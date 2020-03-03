package com.project.services;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.project.utils.Log;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginControllerService {
	
	Response response;
	
	public void sendSigninServiceRequest(String serviceURI, String emailID, String password) {
		RestAssured.baseURI= serviceURI;
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("emailId", emailID); 
		requestParams.put("password", password);
		httpRequest.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());
		 
		// Post the request and check the response
		response = httpRequest.post("/rest/api/login/signin");
		Log.info("response : "+response.body().asString());
	}
	
	public void verifySigninServiceResponse(String statusCode, String name, String emailId, String description) {
		int statusCode_actual = response.getStatusCode();
		Assert.assertEquals(statusCode_actual+"", statusCode);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String name_actual =jsonPathEvaluator.get("body.name");
		Assert.assertEquals(name_actual, name);
		String emailId_actual = response.jsonPath().get("body.emailId");
		Assert.assertEquals(emailId_actual, emailId);
		String description_actual = response.jsonPath().get("body.role.description");
		Assert.assertEquals(description_actual, description);
	}
}
