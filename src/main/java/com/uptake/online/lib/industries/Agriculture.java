package com.uptake.online.lib.industries;

import org.openqa.selenium.WebDriver;

import com.uptake.online.lib.utils.Common;
import com.uptake.online.lib.utils.ExtLogger;

public class Agriculture {

	/** The driver. */
	private WebDriver driver;

	/** The common. */
	private Common common;

	/** The logger. */
	ExtLogger logger = ExtLogger.getLogger(Agriculture.class);

	/**
	 * Instantiates a new login.
	 *
	 * @param driver
	 *            the driver
	 */
	public Agriculture(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
	}

}
