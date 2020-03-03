package com.project.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.project.utils.CommonDriver;
import com.project.utils.TakeScreenShot;

public class BaseClass {
	public String baseurl = "http://okmry52647dns.eastus.cloudapp.azure.com:9090/";
//	public String user = "test123@gmail.com";
//	public String password = "Test@123";
	public String name = "Apeksha Bhosale";
//	public String email = "test123@gmail.com";
//	public String probType = "Shopping";
	public String msg = "test";
	public WebDriver driver;
	CommonDriver commonDriver = null;

	@BeforeClass
	public void setup() {
		// System.getProperty("webdriver.chrome.driver",(("user.dir")
		// +"//src//test//resources//Drivers//chromedriver.exe"));
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\x227650\\WS-SDET\\SeleniumProject\\src\\test\\resources\\Drivers\\chromedriver.exe");
		// driver = new ChromeDriver();
		commonDriver = new CommonDriver();
		driver = commonDriver.launchBrowser("chrome");
		
	}

	@AfterClass
	public void teardown() {
		commonDriver.closeBrowser(driver);

	}
	
	public TakeScreenShot ts = new TakeScreenShot();
	public ExtentTest extentTest; 
	
	public void report(WebDriver driver, String status, String message) {
		final Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
		
		extentTest = (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
		try {
		if(status.equalsIgnoreCase("info")) {
				String screenshotPath = ts.takeScreenShot(driver);
				extentTest.log(Status.INFO, message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void logOut() {

	}
}
