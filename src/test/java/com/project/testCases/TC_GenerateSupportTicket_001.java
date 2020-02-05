package com.project.testCases;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.actions.GeneralActions;
import com.project.base.BaseClass;
import com.project.utils.CommonDriver;
import com.project.utils.DBUtils;
import com.project.utils.ReadExcel;

public class TC_GenerateSupportTicket_001 extends BaseClass {
	
	ReadExcel readExcel = null;
	
	@Test(priority = 1, dataProvider = "testData")
	public void generateSupportTicketTest(Map<String, String> testDataMap) throws Exception {
		driver.get(baseurl);
		GeneralActions.Login(driver, testDataMap.get("User_Name"), testDataMap.get("Password"));
		driver.getCurrentUrl();
		Thread.sleep(25000);
		GeneralActions.GenerateSupportTicket(driver, name, testDataMap.get("User_Name"),
				testDataMap.get("Support_ProbType"), msg);

//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert simpleAlert = driver.switchTo().alert();
//		String alertText = simpleAlert.getText();
//		System.out.println("Alert text is" + alertText);
		String actual = null;//call gettext
		String referenceNumber =null ;//read ref
		//JDBC Connection
		Assert.assertEquals("actual", "Thank you "+name);
		DBUtils db = new DBUtils();
		Map<String, String> suppDetails = db.getSupportDetails();
		Assert.assertEquals(suppDetails.get("email"), testDataMap.get("email"));

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
