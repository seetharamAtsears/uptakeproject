package com.uptake.online.lib.industries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uptake.online.lib.constants.Constants;
import com.uptake.online.lib.utils.ExtLogger;

public class Wind {

	/** The driver. */
	private WebDriver driver;

	/** The logger. */
	ExtLogger logger = ExtLogger.getLogger(Wind.class);

	/**
	 * Instantiates a new login.
	 *
	 * @param driver
	 *            the driver
	 */
	public Wind(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[2]/div/a/span")
	private WebElement demoButton;

	@FindBy(how = How.CLASS_NAME, using = "h-type-h3")
	private WebElement demoHeader;

	/**
	 * @return the demoHeader
	 */
	public WebElement getDemoHeader() {
		return demoHeader;
	}

	/**
	 * @return the getDemoButton
	 */
	public WebElement getDemoButton() {
		return demoButton;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Demo launchDemo() throws Exception {

		getDemoButton().click();
		String demoPageheader = getDemoHeader().getText();
		logger.info(demoPageheader);
		if (demoPageheader.contains(Constants.demoHeader)) {
			logger.info("Successfully Navigated to Demo customer collection Details");
		} else {
			throw new Exception("Failed to Navigated to Demo customer collection Details");
		}
		return PageFactory.initElements(driver, Demo.class);
	}

}
