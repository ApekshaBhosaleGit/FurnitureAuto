package com.project.Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.project.utils.TakeScreenShot;

public class BasePage {
	public TakeScreenShot ts = new TakeScreenShot();
	public ExtentTest extentTest; 
	public void report(WebDriver driver, String status, String message) {
		final Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
		extentTest = (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
		boolean retryStatus = false;
		do {
			try {
				if(status.equalsIgnoreCase("info")) {
						String screenshotPath = ts.takeScreenShot(driver);
						extentTest.log(Status.INFO, message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
					}
				retryStatus = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Exception occured : "+e.getMessage());
				}
		}while(retryStatus);
		
	}
}
