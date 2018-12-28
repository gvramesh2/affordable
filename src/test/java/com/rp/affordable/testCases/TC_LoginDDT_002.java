package com.rp.affordable.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rp.affordable.excelUtilities.ExcelHelper;
import com.rp.affordable.pageObjects.LoginPage;
import com.rp.affordable.testBase.TestBase;

public class TC_LoginDDT_002 extends TestBase {

	private final Logger log = Logger.getLogger(TC_LoginDDT_002.class);

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		log.info("user name provided");
		lp.setPassword(pwd);
		log.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			captureScreen(driver, "LoginTestWithDataDriven");
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");

		} else {
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/main/java/com/rp/affordable/testData/LoginData.xlsx";

		int rownum = ExcelHelper.getRowCount(path, "Sheet1");
		int colcount = ExcelHelper.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = ExcelHelper.getCellData(path, "Sheet1", i, j);// 1 0
				// logindata[][] - is 2 dimentional object which starts from 0,0
				// Sheet1 - is actual excel sheet rows and columns are starting from 0,0 but 0th
				// row 0th column. Excelsheet 0th row is header information, hence we are
				// avaiding. So Excelsheet row starts with 1 and column 0.

				// But logindata[][] object starts from 0,0 hence we are assigning excel sheet
				// 1,0 value to the logindata[][] object 0,0
			}

		}
		return logindata;
	}

}
