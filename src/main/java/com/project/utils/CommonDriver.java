package com.project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class CommonDriver {

	public WebDriver launchBrowser(String browserName) {
		WebDriver driver = null;
		switch (browserName) {
		case "chrome":
//			String a = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
//			System.out.println(a);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
		
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\x227650\\WS-SDET\\SeleniumProject\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "opera":
			System.setProperty("webdriver.opera.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\operadriver.exe");
			driver = new OperaDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
//		case "edge":
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\x227650\\WS-SDET\\SeleniumProject\\src\\test\\resources\\Drivers\\chromedriver.exe");
//			// driver = new MicrosoftEdgeDriver();
//			break;
		}
		return driver;
	}

	public void closeBrowser(WebDriver driver) {
		try {
			if (driver != null) {
				driver.quit();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}