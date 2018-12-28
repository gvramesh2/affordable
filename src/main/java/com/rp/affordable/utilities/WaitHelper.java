package com.rp.affordable.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private Logger log = Logger.getLogger(WaitHelper.class);

	private WebDriver driver;

	/**
	 * This is WaitHelper Class constructor - used to initiate the WebDriver object
	 * 
	 * @param driver
	 */
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WaitHelper object is created...");

	}

	/**
	 * This is Implicit wait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to :" + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);

	}

	/**
	 * 
	 * This will help us to get WebDriverWait Object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSeconds
	 * @return
	 */
	private WebDriverWait getWait(long timeOutInSeconds, long pollingEveryInMiliSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSeconds));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(StaleElementReferenceException.class);

		return wait;
	}

	/**
	 * This methods will help us to waitForElementVisibleWithPollingTime
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSeconds
	 */

	public void waitForElementVisibleWithPollingTime(WebElement element, long timeOutInSeconds,
			long pollingEveryInMiliSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element.toString() + " is visible now");

	}

	/**
	 * this method will help us to waitForElementClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */

	public void waitForElementClickable(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(element.toString() + " is clickable now");

	}

	/**
	 * This method will make sure of invisibility of an element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(element.toString() + " is invisible now");
		return status;

	}

	/**
	 * This method will wait for frame and switched to it
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */

	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " Seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is invisible now and switched");

	}

	/**
	 * This is the PRIVATE method used within this class only and it will give
	 * Fluent wait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSeconds
	 * @return
	 */
	private Wait<WebDriver> getFluentWait(long timeOutInSeconds, long pollingEveryInMiliSeconds) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSeconds)).ignoring(NoSuchElementException.class);

		return fwait;
	}

	/**
	 * This is the method to use wait for element (within the method, we used above
	 * created PRIVATE method)
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSeconds
	 * @return
	 */
	public WebElement waitForElement(WebElement element, long timeOutInSeconds, long pollingEveryInMiliSeconds) {
		log.info("Waiting for element to be visible...");
		Wait<WebDriver> fWait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSeconds);
		fWait.until(ExpectedConditions.visibilityOf(element));

		return element;
	}

	/**
	 * This is the method to use page load timout
	 * 
	 * @param timeout
	 * @param unit
	 */

	public void waitForPageLoad(long timeout, TimeUnit unit) {
		log.info("Waiting for page to load for : " + timeout + " Seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page loaded successfully");
	}

}
