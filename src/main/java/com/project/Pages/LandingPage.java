package com.project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends BasePage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='mat-button mat-button-base ng-star-inserted']//span[@class='mat-button-wrapper'][contains(text(),'Sign In')]")
	@CacheLookup
	WebElement buttonLogin;
	
	public void clickLogin()
	{
		buttonLogin.click();
	}
	
	
}
