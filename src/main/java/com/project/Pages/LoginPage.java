package com.project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utils.SeleniumUtils;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	SeleniumUtils seleniumUtils = null;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils();
	}
	
	@FindBy(id="emailId")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement signIn;
	
	public void setusername(String user)
	{
		seleniumUtils.sendKeys(emailId, user);
	}
	
	public void setpassword(String pswd)
	{
		seleniumUtils.sendKeys(password, pswd);
	}
	
	public void clicksignin()
	{
		seleniumUtils.clickElement(signIn);
		seleniumUtils.moveByOffset(driver,80,90);
	}
	
	
	
}
