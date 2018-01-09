package com.uptake.online.lib;

import java.util.List;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uptake.online.lib.constants.Constants;
import com.uptake.online.lib.industries.Agriculture;
import com.uptake.online.lib.industries.Wind;
import com.uptake.online.lib.utils.Common;
import com.uptake.online.lib.utils.ExtLogger;

// TODO: Auto-generated Javadoc
/**
 *
 * Login.java
 *
 *
 * Purpose: This class is for oncommand general methods which can be used in
 * various other class and methods.
 *
 * Example: PageFactory.initElements(driver,Login.class);
 *
 * @author seethar1
 *
 */
public class UpTake {

	/** The driver. */
	private WebDriver driver;

	/** The common. */
	private Common common;

	/** The logger. */
	ExtLogger logger = ExtLogger.getLogger(UpTake.class);

	/**
	 * Instantiates a new login.
	 *
	 * @param driver
	 *            the driver
	 */
	public UpTake(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
	}

	@FindBy(xpath = "//li[1]/a/span")
	private WebElement products;

	@FindBy(xpath = "//li[2]/a/span")
	private WebElement industries;

	@FindBy(xpath = "//li[3]/a/span")
	private WebElement about;

	@FindBy(xpath = "//li[4]/a/span")
	private WebElement expertise;

	@FindBy(xpath = "//li[5]/a/span")
	private WebElement newsAndInsights;

	@FindBy(xpath = "//li[6]/a/span")
	private WebElement careers;

	@FindBy(xpath = "//li[7]/a/span")
	private WebElement contact;

	@FindBy(xpath = "//li[2]/div/ul")
	private WebElement industriesSelectionList;


	@FindBy(css = ".hero-heading__subheading")
	private WebElement subHeader;
	
	
	/**
	 * @return the subHeader
	 */
	public WebElement getSubHeader() {
		return subHeader;
	}

	/**
	 * @return the industriesSelectionList
	 */
	public WebElement getIndustriesSelectionList() {
		return industriesSelectionList;
	}

	/**
	 * @return the products
	 */
	public WebElement getProducts() {
		return products;
	}

	/**
	 * @return the industries
	 */
	public WebElement getIndustries() {
		return industries;
	}

	/**
	 * @return the expertise
	 */
	public WebElement getExpertise() {
		return expertise;
	}

	/**
	 * @return the newsAndInsights
	 */
	public WebElement getNewsAndInsights() {
		return newsAndInsights;
	}

	/**
	 * @return the careers
	 */
	public WebElement getCareers() {
		return careers;
	}

	/**
	 * @return the contact
	 */
	public WebElement getContact() {
		return contact;
	}

	/**
	 * This method opens the login page Only. It does not log into the system.
	 *
	 * @param url
	 *            String URL of the OCUM server
	 *
	 * @return <code>true</code> or <code>false</code> depending on whether the
	 *         page was opened successfully or not
	 * @throws InterruptedException
	 */
	public boolean launchUpTake(String url) throws InterruptedException {

		driver.get(url);
		String title = driver.getTitle();
		logger.info(title);
		if (title.toUpperCase().contains(Constants.uptakeHeader)) {
			logger.testLog(Level.INFO, "Title From Page: " + title);
			return true;
		} else {
			logger.testLog(Level.ERROR, "Failed: Launch "+Constants.uptakeHeader);
			driver.quit();
			return false;
		}

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Wind navigateToIndustryWind() throws Exception {

		selectIndustriesList(Constants.IndustriesList.WIND.value);
		String pageSubHeader = getSubHeader().getText();
		String pageUrl = driver.getCurrentUrl();
		logger.info(pageSubHeader);
		logger.info(pageUrl);
		if(pageSubHeader.contains(Constants.IndustriesList.WIND.value) && pageUrl.contains(Constants.windNavigationURL)){
			logger.info("Successfully Navigated to "+Constants.IndustriesList.WIND.value+" Industies");
		}else {
			throw new Exception("Failed to load the "+Constants.IndustriesList.WIND.value+" industries");
		}
		return PageFactory.initElements(driver, Wind.class);
		
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Agriculture navigateToIndustryAgriculture() throws Exception {

		selectIndustriesList(Constants.IndustriesList.WIND.value);
		String pageSubHeader = getSubHeader().getText();
		String pageUrl = driver.getCurrentUrl();
		logger.info(pageSubHeader);
		logger.info(pageUrl);
		if(pageSubHeader.contains(Constants.IndustriesList.WIND.value) && pageUrl.contains(Constants.agricultureNavigationURL)){
			logger.info("Successfully Navigated to "+Constants.IndustriesList.AGRICULTURE.value+" Industies");
		}else {
			throw new Exception("Failed to load the "+Constants.IndustriesList.AGRICULTURE.value+" industries");
		}
		return PageFactory.initElements(driver, Agriculture.class);
		
	}

	/**
	 * 
	 * @param industry
	 * @throws InterruptedException
	 */
	public void selectIndustriesList(String industry) throws InterruptedException {

		getIndustries().click();
		List<WebElement> industiresList=getIndustriesSelectionList().findElements(By.tagName("li"));
		for (WebElement li : industiresList) {
		if (li.getText().equalsIgnoreCase(industry.toUpperCase())) {
		     li.click();
		   }
		}
	}

}
