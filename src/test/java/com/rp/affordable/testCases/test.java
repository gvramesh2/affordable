package com.rp.affordable.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rp.affordable.pageObjects.LoginPage;
import com.rp.affordable.testBase.TestBase;
import com.rp.affordable.utilities.AlertHelper;
import com.rp.affordable.utilities.FrameHelper;

public class test extends TestBase {
	
	private final Logger log = Logger.getLogger(test.class);

	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		
		log.info("URL is opened");
		captureScreen(driver,"LoginTest");

		LoginPage lp = new LoginPage(driver);
		AlertHelper alehelp = new AlertHelper(driver);
		FrameHelper fmHelp = new FrameHelper(driver);
		
		
		
		lp.setUserName(username);
		log.info("Entered username");

		lp.setPassword(password);
		log.info("Entered password");

		lp.clickSubmit();
		log.info("Submit button clicked");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Login test passed");
			//captureScreen(driver,"LoginTest");
		} else {
			Thread.sleep(3000);
			alehelp.acceptAlert();
			//driver.switchTo().alert().accept();
			Assert.assertTrue(false);
			log.info("Login test failed");
			captureScreen(driver,"LoginTest");
		}

	}
}
