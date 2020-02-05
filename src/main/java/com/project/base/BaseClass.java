package com.project.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.project.utils.CommonDriver;

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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {
		commonDriver.closeBrowser(driver);

	}

	@AfterTest
	public void logOut() {

	}
}
