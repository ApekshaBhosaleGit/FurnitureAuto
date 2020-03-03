package com.project.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;
import com.project.services.LoginControllerService;
import com.project.utils.Log;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_UserDetailsAPI_002 {
	
	@Test
	public void tc_UserDetailsAPI() {
		
		String serviceURI = "http://okmry52647dns.eastus.cloudapp.azure.com:8089";
		String emailID = "test123@gmail.com";
		String password = "Test@123";
		String statusCode_expected = "202";
		String name_expected = "Apeksha Bhosale";
		String description_expected = "Has customer access";
		
//		Log.info("Before Submittingrequest");
		
		LoginControllerService loginControllerService = new LoginControllerService();
		loginControllerService.sendSigninServiceRequest(serviceURI, emailID, password);
		
//		Log.info("Got Response");
		
		loginControllerService.verifySigninServiceResponse(statusCode_expected, name_expected, emailID, description_expected);
		
//		Log.info("Response Verified");
	}
	

}
