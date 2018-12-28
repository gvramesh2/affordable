package com.rp.affordable.utilities;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

	private Logger log = Logger.getLogger(DropDownHelper.class);
	private WebDriver driver;

	/**
	 * This is DropDownHelper Class constructor - used to initiate the WebDriver
	 * object
	 * 
	 * @param driver
	 */
	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDownHelper object is created");
	}

	/**
	 * This method will select the value by using VALUE
	 * 
	 * @param element
	 * @param value
	 */
	public void selectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("selectUsingValue and values is " + value);
		select.selectByValue(value);
	}

	/**
	 * This method will select the value by using Index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("selectUsingIndex and index is " + index);
		select.selectByIndex(index);
	}

	/**
	 * This method will select the value by using Visible text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void selectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		log.info("selectUsingVisibleText and text is " + visibleText);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This method will deselect the value by using VALUE
	 * 
	 * @param element
	 * @param value
	 */
	public void deSelectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("deSelectUsingValue and values is " + value);
		select.deselectByValue(value);
	}

	/**
	 * This method will deselect the value by using index
	 * 
	 * @param element
	 * @param index
	 */
	public void deSelectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("deSelectUsingIndex and index is " + index);
		select.deselectByIndex(index);
	}

	/**
	 * This method will deselect the value by using VISIBLE TEXT
	 * 
	 * @param element
	 * @param visibleText
	 */
	public void deSelectUsingVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		log.info("deSelectUsingVisibleText and text is " + visibleText);
		select.deselectByVisibleText(visibleText);
	}

	/**
	 * This method will give all values from the dropdown as a list
	 * 
	 * @param element
	 * @return
	 */
	public List<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementList) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}

}
