package com.uptake.online.lib.utils;

import java.util.List;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The WebDriver Utils will provide general utility methods to reuse on writing
 * product specific utility methods or test cases.
 *
 * @author seethar1
 *
 */

public class Common {

	private static final int DEFAULTTIMEOUT = 20;
	private WebDriver driver;
	private static ExtLogger logger = ExtLogger.getLogger(Common.class);
	
	/**
	 * Constructor.
	 *
	 * @param RemoteWebdriver
	 *            instance
	 */
	public Common(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * To wait till the element present on page.
	 *
	 * @param By
	 *            Element which has either the XPath or the ID or the Link Text
	 *
	 */
	public void waitForElementPresent(By byElement) {
		final By element = byElement;
		(new WebDriverWait(driver, DEFAULTTIMEOUT)).ignoring(StaleElementReferenceException.class)
				.until(new ExpectedCondition<WebElement>() {
					@Override
					public WebElement apply(WebDriver d) {
						return d.findElement(element);
					}
				});
	}

	/**
	 * To wait till the element present on page.
	 *
	 * @param By
	 *            Element which has the ID
	 *
	 */
	public void waitForElementPresentByID(String Id) {

		waitForElementPresent(By.id(Id));

	}

	/**
	 * To wait till the element present on page.
	 *
	 * @param By
	 *            Element which has the XPath
	 *
	 */
	public void waitForElementPresentByXPath(String XPath) {

		waitForElementPresent(By.xpath(XPath));

	}

	/**
	 * To wait till the element present on page.
	 *
	 * @param By
	 *            Element which has the Link Text
	 *
	 */

	public void waitForElementPresentByLinkText(String linkText) {

		waitForElementPresent(By.linkText(linkText));

	}

	/**
	 * To Verify the element present on the page passing the Id
	 * 
	 * @param Id
	 *            of the web element
	 */

	public boolean isElementPresentByID(String Id) {

		return isElementPresent(By.id(Id));

	}

	/**
	 * To Verify the element present on the page passing the XPath
	 * 
	 * @param XPath
	 *            of the web element
	 */

	public boolean isElementPresentByXPath(String XPath) {

		return isElementPresent(By.xpath(XPath));

	}

	/**
	 * To Verify the element present on the page passing the Link Text
	 * 
	 * @param Link
	 *            Text of the web element
	 */

	public boolean isElementPresentByLinkText(String linkText) {

		return isElementPresent(By.linkText(linkText));

	}

	/**
	 * To Verify the element present on the page
	 * 
	 * @param By
	 *            Element
	 */

	public boolean isElementPresent(By byElement) {
		try {
			if (driver.findElement(byElement).isDisplayed()) {

				logger.testLog(Level.INFO, "Element with the given xpath or ID exists: " + byElement.toString());
				return true;
			}
			logger.testLog(Level.INFO, "Could not find element with the given xpath or ID: " + byElement.toString());
			return false;

		} catch (NoSuchElementException ignored) {
			logger.testLog(Level.INFO, "Could not find element with the given xpath or ID: " + byElement.toString());
			return false;
		}

	}

    /**
     *  Click Option in a Select List
     *  @param WebElement selectElement, String optionValue
     * @throws InterruptedException
     */
    public void clickOptionInSelectList(WebElement selectElement, String optionValue) throws InterruptedException {
        // Then instantiate the Select class with that WebElement
        Select select = new Select(selectElement);

        // Get a list of the options
        List<WebElement> options = select.getOptions();
        // For each option in the list, verify if it's the one you want and then return that web element
        for (WebElement we : options) {
            logger.testLog(Level.INFO, we.getText());
            if (we.getText().equals(optionValue)) {
                we.click();
                break;
            }
        }

    }

}
