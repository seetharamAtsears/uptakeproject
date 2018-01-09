package com.uptake.online.lib.industries;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.uptake.online.lib.utils.Common;
import com.uptake.online.lib.utils.ExtLogger;

public class Demo {

	/** The driver. */
	private WebDriver driver;

	/** The common. */
	private Common common;

	/** The logger. */
	ExtLogger logger = ExtLogger.getLogger(Demo.class);

	/**
	 * Instantiates a new login.
	 *
	 * @param driver
	 *            the driver
	 */
	public Demo(WebDriver driver) {
		this.driver = driver;
		this.common = new Common(driver);
	}

	@FindBy(xpath = "//div[2]/div/a/span")
	private WebElement demoButton;


	@FindBy(xpath = "//input[starts-with(@id,'firstname')]")
	private WebElement firstName;

	
	@FindBy(xpath = "//input[starts-with(@id,'lastname')]")
	private WebElement lastName;

	@FindBy(xpath = "//input[starts-with(@id,'email')]")
	private WebElement email;
	
	@FindBy(xpath = "//input[starts-with(@id,'company')]")
	private WebElement company;
	
	@FindBy(xpath = "//select[starts-with(@id,'vertical')]")
	private WebElement industry;
	
	@FindBy(xpath = "//select[starts-with(@id,'number_of_employees')]")
	private WebElement numberOfEmployees;
	
	@FindBy(xpath = "//select[starts-with(@id,'what_is_your_function_role_in_your_company_')]")
	private WebElement FunctionRoleAtCompany;
	
	@FindBy(xpath = "//form/div[15]/div[2]/input")
	private WebElement letsTalkButton;

	/**
	 * @return the demoButton
	 */
	public WebElement getDemoButton() {
		return demoButton;
	}

	/**
	 * @return the firstName
	 */
	public WebElement getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public WebElement getLastName() {
		return lastName;
	}
	
	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @return the industry
	 */
	public WebElement getIndustry() {
		return industry;
	}

	/**
	 * @return the numberOfEmployees
	 */
	public WebElement getNumberOfEmployees() {
		return numberOfEmployees;
	}

	/**
	 * @return the company
	 */
	public WebElement getCompany() {
		return company;
	}

	/**
	 * @return the functionRoleAtCompany
	 */
	public WebElement getFunctionRoleAtCompany() {
		return FunctionRoleAtCompany;
	}

	/**
	 * @return the letsTalkButton
	 */
	public WebElement getLetsTalkButton() {
		return letsTalkButton;
	}
	
	public boolean collectCustomerDetails(HashMap<String,String> input) throws Exception {
		getFirstName().sendKeys(input.get("FirstName"));
		getLastName().sendKeys(input.get("LastName"));
		getEmail().sendKeys(input.get("Email"));
		getCompany().sendKeys(input.get("Company"));
		common.clickOptionInSelectList(getIndustry(), input.get("Industries"));
		common.clickOptionInSelectList(getNumberOfEmployees(), input.get("NumberOfEmployees"));
		common.clickOptionInSelectList(getFunctionRoleAtCompany(), input.get("FunctionRoleAtCompany"));
		return true;
	}

}
