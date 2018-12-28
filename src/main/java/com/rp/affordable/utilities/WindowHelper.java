package com.rp.affordable.utilities;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {

	private Logger log = Logger.getLogger(WindowHelper.class);
	private WebDriver driver;

	/**
	 * This is WindowHelper Class constructor - used to initiate the WebDriver
	 * object
	 * 
	 * @param driver
	 */
	public WindowHelper(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * This method will switch to parent window
	 */
	public void switchToParentWindow() {
		log.info("Switching to prarent window...");
		driver.switchTo().defaultContent();
		log.info("Switched to prarent window");
	}

	/**
	 * This method will switch to child window based on index
	 * 
	 * @param windowIndex
	 */

	public void swtichToWindow(int windowIndex) {

		log.info("Getting all the windows information...");
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == windowIndex) {
				log.info("Switched to " + windowIndex + " window");
				driver.switchTo().window(window);
			} else {
				i++;
			}

		}
		log.info("Switch to :" + windowIndex + " window");
	}

	/**
	 * this method will close all the windows and switched to parent window
	 * 
	 */
	public void closeAllTabsAndSwitchToMainWindow() {

		// Getting parent window
		String mainWindow = driver.getWindowHandle();

		// Getting all windows
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		log.info("Switch to main window");
	}

	public void moveToChildWindowAndCloseParentWindow() throws Exception {

		// Getting parent window
		/*
		 * String mainWindow = driver.getWindowHandle();
		 * System.out.println(mainWindow.toString()); String childWindow =
		 * driver.getWindowHandle(); System.out.println(childWindow.toString()); //
		 * Getting all windows Set<String> windows = driver.getWindowHandles(); for
		 * (String window : windows) { if (!window.equalsIgnoreCase(childWindow)) {
		 * driver.close(); } } driver.switchTo().window(childWindow);
		 * log.info("Switch to child window"); System.out.println(driver.getTitle());
		 */

		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> itr = allWindowHandles.iterator();

		String mainWindow = itr.next();
		String childWindow = itr.next();
		System.out.println(mainWindow);
		System.out.println(childWindow);
		driver.switchTo().window(mainWindow);
		System.out.println("switched to child window");

		Thread.sleep(5000);
		for (String window : allWindowHandles) {
			System.out.println(driver.getTitle());
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
	}

	/**
	 * This method will do browser back navigation
	 */
	public void navigateBack() {
		driver.navigate().back();
		log.info("Navigating browser back");
	}

	/**
	 * This method will do browser forward navigation
	 */
	public void navigateForward() {
		driver.navigate().forward();
		log.info("Navigating browser forward");
	}

}
