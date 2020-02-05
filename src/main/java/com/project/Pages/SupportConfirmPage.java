package com.project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utils.SeleniumUtils;

public class SupportConfirmPage extends BasePage {
	
	WebDriver driver;
	SeleniumUtils seleniumUtils = null;
	
	public SupportConfirmPage (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils();
	}
	
	@FindBy(xpath="//div[@class='card-header']")
	@CacheLookup
	public WebElement ConfirmSuccessHeader;
	
	@FindBy(xpath="//h5[@class='card-title']")
	@CacheLookup
	public WebElement ReferenceNum;
	

}
