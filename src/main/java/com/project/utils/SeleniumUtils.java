package com.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public void sendKeys(WebElement element, String valToSend) {
		element.sendKeys(valToSend);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void selectDropdown(WebElement element, String valToSelect) {
		Select select = new Select(element);
		select.selectByValue(valToSelect);
	}

	public void moveByOffset(WebDriver driver, int x, int y) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(x, y).build().perform();
	}

	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
