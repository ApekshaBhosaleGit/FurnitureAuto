package com.project.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.utils.SeleniumUtils;

public class SupportPage extends BasePage {
	WebDriver driver;
	SeleniumUtils seleniumUtils = null;

	public SupportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		seleniumUtils = new SeleniumUtils();
	}

	@FindBy(xpath = "//input[@id='userName']")
	@CacheLookup
	WebElement fullName;

	@FindBy(xpath = "//input[@id='emailId']")
	@CacheLookup
	WebElement emailId;

	@FindBy(xpath = "//select[@formcontrolname='type']")
	@CacheLookup
	WebElement typeOfProbDropDown;

	@FindBy(xpath = "//textarea[@id='message']")
	@CacheLookup
	WebElement message;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	@CacheLookup
	WebElement buttonSend;
	
	@FindBy(xpath = "//h3[@class='customer-header']")
	@CacheLookup
	WebElement pageHeader;
	

	public void enterName(String name) {
		seleniumUtils.sendKeys(fullName, name);
	}

	public void enterEmail(String email) {
		seleniumUtils.sendKeys(emailId, email);
	}

	public void selectTypeOfProb(String typeOfProb) {
		// System.out.println(typeOfProbDropDown);
		seleniumUtils.selectDropdown(typeOfProbDropDown, typeOfProb);
	}

	public void enterMsg(String msg) {
		seleniumUtils.sendKeys(message, msg);
	}

	public void clicksend() {
		seleniumUtils.clickElement(buttonSend);
	}
	
	public void explicitWait() {
		seleniumUtils.explicitWait(driver, pageHeader);
	}
}
