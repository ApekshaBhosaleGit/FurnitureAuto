package com.project.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.project.Pages.HomePage;
import com.project.Pages.LandingPage;
import com.project.Pages.LoginPage;
import com.project.Pages.SupportPage;

public class GeneralActions {

	public void Login(WebDriver driver, String userName, String pswd) {
		LandingPage lp = new LandingPage(driver);
		lp.clickLogin();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setusername(userName);
		loginPage.setpassword(pswd);
		loginPage.clicksignin();
		
		
	}
	
	public void GenerateSupportTicket( WebDriver driver, String fullName, String emailId, String probType, String msg) {

		HomePage hp = new HomePage(driver);
		hp.clicksupport();
		SupportPage sp = new SupportPage(driver);
		sp.enterName(fullName);
		sp.enterEmail(emailId);
		sp.selectTypeOfProb(probType);
		sp.enterMsg(msg);
		sp.clicksend();		
	}
}
