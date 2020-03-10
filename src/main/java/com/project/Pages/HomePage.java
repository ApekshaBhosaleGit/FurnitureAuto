package com.project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utils.SeleniumUtils;

public class HomePage extends BasePage {
	
	WebDriver driver;
	SeleniumUtils seleniumUtils = null;
	
	public HomePage (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils();
	}
	@FindBy(xpath="//button[@class='mat-button mat-button-base']//span[@class='mat-button-wrapper'][contains(text(),'Support')]")
	@CacheLookup
	WebElement buttonSupport;
	
	@FindBy(xpath="//div[@id='toast-container']") 
	@CacheLookup
	WebElement flyOut;
	
	public void clicksupport()
	{	
		seleniumUtils.clickElement(buttonSupport);;
	}
	public void clickflyout()
	{	
		seleniumUtils.clickElement(flyOut);
	}
}
