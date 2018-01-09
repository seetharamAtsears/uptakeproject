package com.uptake.online.lib.utils;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.xml.XmlTest;

/**
 * Driver Web Driver instance for specific browser.
 *
 * @throws MalformedURLException
 *
 * @author seethar1
 */

public class Driver {

	public static String browserName;
	public static String browserVersion;
	public static String geckoDriverPath;
	private static ExtLogger logger = ExtLogger.getLogger(Driver.class);
	public static WebDriver driver;

	public static WebDriver getDriver(XmlTest Config) throws MalformedURLException {

		int driverTimeout = 20;
		
		browserName = Config.getParameter("client_browser").toLowerCase();
		browserVersion = Config.getParameter("client_browserversion").toLowerCase();
		geckoDriverPath = Config.getParameter("gecko_driver_path").toLowerCase();
		logger.info("Setting default driver timeout to " + driverTimeout);

		logger.info("Client browser name:" + browserName);
		logger.info("Client browser Version:" + browserVersion);
		
		if (browserName.contains("firefox") || browserName.equalsIgnoreCase("firefox")) {
			
			// Firefox Driver

			logger.info("Configuring settings for Firefox");
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
	    	FirefoxOptions ffOptions = new FirefoxOptions();
	    	ffOptions.setCapability("marionette", false);
		   driver= new FirefoxDriver(ffOptions);
			
		
		} else if (browserName.contains("internet explorer") || browserName.equalsIgnoreCase("internet explorer")) {

			logger.info("Configuring settings for IE");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(options);

		} else if (browserName.contains("chrome") || browserName.equalsIgnoreCase("chrome")) {

			logger.info("Configuring settings for Chrome");
			// Google Chrome Driver
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			
			WebDriver driver = new ChromeDriver(options);
			driver.get("http://www.google.com");
			
		} else if (browserName.contains("opera") || browserName.equalsIgnoreCase("opera")) {

			// Safari Safari Driver
			logger.info("Configuring settings for Safari");
			SafariOptions safariPptions = new SafariOptions();
			driver = new SafariDriver(safariPptions);

		}
		
		driver.manage().timeouts().implicitlyWait(driverTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
