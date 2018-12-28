package com.rp.affordable.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

	private Logger log = Logger.getLogger(FrameHelper.class);
	private WebDriver driver;

	/**
	 * This is FrameHelper Class constructor - used to initiate the WebDriver object
	 * 
	 * @param driver
	 */
	public FrameHelper(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * This method will switchToFrame based on frame index
	 * 
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
		log.info("Switched to :" + frameIndex + " frame");
	}

	/**
	 * This method will switchToFrame based on frame name
	 * 
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
		log.info("Switched to :" + frameName + " frame");
	}

	/**
	 * This method will switchToFrame based on frame web element
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
		log.info("Switched to frame :" + element.toString());
	}

	public void switchToDefault() {
		driver.switchTo().defaultContent();
		log.info("Switched to default content");
	}

}
