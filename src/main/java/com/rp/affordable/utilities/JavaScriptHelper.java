package com.rp.affordable.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class JavaScriptHelper {

	private static Logger log = Logger.getLogger(JavaScriptHelper.class);
	private WebDriver driver;

	/**
	 * This is JavaScriptHelper Class constructor - used to initiate the WebDriver
	 * object
	 * 
	 * @param driver
	 */
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JavaScriptHelper has been initialised");
	}

	/**
	 * This method will execute the java script
	 * 
	 * @param script
	 * @return
	 */
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	/**
	 * This method will execute the java script with arguments
	 * 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	/**
	 * Notes: Above 2 executeScript methods base for the remaining (below) methods
	 */

	/**
	 * This method will scroll to the particular element
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		log.info("Scrolling to element");
		executeScript("window.scrollTo(argument[0],argument[1])", element.getLocation().x, element.getLocation().y);

	}

	/**
	 * This method will scroll to the particular element and then click
	 * 
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element is clicked :" + element.toString());

	}

	/**
	 * This method will scroll to the element view
	 * 
	 * @param element
	 */

	public void scrollIntoView(WebElement element) {
		log.info("Scroll till web element");
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * This method will scroll to element view and then click
	 * 
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("element is clicked :" + element.toString());
	}

	/**
	 * This method will scroll down vertically
	 * 
	 */
	public void scrollDownVertically() {
		log.info("Scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.ScrollHeight)");
	}

	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically() {
		log.info("Scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.ScrollHeight)");
	}

	/**
	 * This method will scroll down till given pixel(e.g=1500)
	 * 
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
		log.info("Scrolling down by pixel...");
	}

	/**
	 * This method will scroll up till given pixel
	 * 
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
		log.info("Scrolling up by pixel...");
	}

	/**
	 * this method will zoom screen by 100%
	 * 
	 */
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100'");
		log.info("Zoom in by 100 percentage");
	}

	/**
	 * this method will zoom screen by 60%
	 * 
	 */
	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='60'");
		log.info("Zoom in by 60 percentage");
	}

	/**
	 * This method will click on give element using java script method
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		executeScript("arguments[0].click();", element);
		log.info("Clicked on element " + element.toString());
	}

}
