package com.project.testCases;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Pages.SupportConfirmPage;
import com.project.actions.GeneralActions;
import com.project.base.BaseClass;
import com.project.utils.DBUtils;
import com.project.utils.ReadExcel;
import com.project.utils.TakeScreenShot;

public class TC_GenerateSupportTicket_001 extends BaseClass {
	
	ReadExcel readExcel = null;
	
	@Test(priority = 1, dataProvider = "testData")
	public void generateSupportTicketWeb(Map<String, String> testDataMap) throws Exception {
		driver.get(baseurl);
		GeneralActions ga = new GeneralActions();
		ga.Login(driver, testDataMap.get("User_Name"), testDataMap.get("Password"));
		driver.getCurrentUrl();
		ga.GenerateSupportTicket(driver, name, testDataMap.get("User_Name"),
				testDataMap.get("Support_ProbType"), msg);
	/*	WebDriverWait wait = new WebDriverWait(driver, 25);*/
}

	@Test(priority = 2, dataProvider = "testData")
	public void successValidation(Map<String, String> testDataMap) {
		SupportConfirmPage scp = new SupportConfirmPage(driver);
		String actual = scp.ConfirmSuccessHeader.getText();

		Assert.assertTrue(true == true);
		Assert.assertEquals(actual, "Thank you-"+name+"!");
		report(driver,"INFO", "Ticket Created");
		TakeScreenShot tss = new TakeScreenShot();
		try {
			tss.takeScreenShot(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test(priority = 3, dataProvider = "testData")
	public void ReferenceNumValidation(Map<String, String> testDataMap) {
		SupportConfirmPage scp = new SupportConfirmPage(driver);
		String referenceNumber = scp.ReferenceNum.getText();
		//JDBC Connection
		DBUtils db = new DBUtils();
		Map<String, String> suppDetails = db.getSupportDetails(referenceNumber);
		db.closeConnection();		
		if (null == suppDetails || suppDetails.isEmpty()) {
			System.out.println("No data fetch");
			Assert.assertFalse(false == false, "No data fetched from db");
		}
		else {
		Assert.assertEquals(suppDetails.get("email_id"), testDataMap.get("User_Name"));
		Assert.assertEquals(suppDetails.get("type"), testDataMap.get("Support_ProbType"));
		}
	}

			


	@DataProvider
	public Object[][] testData() throws Exception {
		readExcel = new ReadExcel();
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\project\\testData\\Test_Data.xlsx";
		List<Map<String, String>> testData = readExcel.getAllDataIntoMapList(path, "Sheet1");
		Object[][] objArr = new Object[testData.size()][1];

		for (int i = 0; i < testData.size(); i++) {
			objArr[i][0] = testData.get(i);
		}
		return objArr;
	}

}
