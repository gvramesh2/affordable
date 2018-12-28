package com.rp.affordable.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

	private Logger log = Logger.getLogger(AlertHelper.class);
	private WebDriver driver;

	/**
	 * This is AlertHelper Class constructor - used to initiate the WebDriver object
	 * 
	 * @param driver
	 */
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("AlertHelper object is initialized");
	}

	/**
	 * This method will switch to Alter
	 * 
	 * @return
	 */
	public Alert getAlert() {
		log.info("alert text: " + driver.switchTo().alert().getText());
		return driver.switchTo().alert();

	}

	/**
	 * This method will accept alert (Ex: it will click on ACCEPT, OK, YES buttons)
	 */
	public void acceptAlert() {
		getAlert().accept();
		log.info("accept alert is done...");
	}

	/**
	 * This method will dismiss alert (Ex: it will click on CANCEL, NO buttons)
	 */
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("dismiss alert is done...");
	}

	/**
	 * This method will return text of the alert
	 * 
	 * @return
	 */
	public String getAlertText() {
		String alertText = getAlert().getText();
		log.info("Alert text: " + alertText);
		return alertText;
	}

	/**
	 * This method will check alert is present or not, if present returns TRUE
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			log.info(e.getCause());
			return false;
		}
	}

	/**
	 * This method will accept alert, If its present
	 */
	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			acceptAlert();
			log.info("Alert is present and accepted");
		} else {
			log.info("Alert is not present");
		}

	}

	/**
	 * This method will DISMISS alert, if its present
	 */
	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			dismissAlert();
			log.info("Alert is present and dismissed");
		} else {
			log.info("Alert is not present");
		}

	}

	/**
	 * This method will enter text into alert and then its accepts
	 * 
	 * @param text
	 */
	public void sendTextIntoAlert(String text) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text: " + text);
		}
	}
}
