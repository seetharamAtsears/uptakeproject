package com.uptake;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.uptake.online.lib.UpTake;
import com.uptake.online.lib.industries.Demo;
import com.uptake.online.lib.industries.Wind;
import com.uptake.online.lib.utils.Driver;
import com.uptake.online.lib.utils.ExtLogger;

public class UpTakeTest {

	private WebDriver driver;
	private Wind windPageObj;
	private Demo demoPageObj;
	private UpTake uptakePageObj;
	ExtLogger logger = ExtLogger.getLogger(UpTakeTest.class);

	@BeforeClass
	public void Setup(XmlTest Config) throws MalformedURLException{
	}

	/**
	 * AfterClass
	 * 
	 * @throws Exception
	 */
	@AfterClass(description = "Tear Down")
	public void tearDownAfterClass() throws Exception {
	driver.quit();
	}

	@AfterMethod
	public void cleanupAfterMethod(Method method) {
	driver.close();
	}

	@BeforeMethod
	public void setUpBeforeMethod(Method method, XmlTest Config) throws Exception {
		driver = Driver.getDriver(Config);
	}

	/**
	 * TC:VserverNameFilter
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(groups = { "uptake Functioanal" }, description = "Uptake Request a product demo of Wind Industrie ")
	public void UpTakeTest1() throws Exception {
		
		logger.testStepLog("Step1: Launching uptake http://www.uptake.com/");
		uptakePageObj = PageFactory.initElements(driver, UpTake.class);
		Assert.assertTrue(uptakePageObj.launchUpTake("http://www.uptake.com/"),
				"Unable to Lanuch Update site");
		
		logger.testStepLog("Step2: Navigting to Wind Industry");
		windPageObj = uptakePageObj.navigateToIndustryWind();
		
		logger.testStepLog("Step3: Click on Demo button of Wind Industry");
		demoPageObj = windPageObj.launchDemo();

		/** This Data supply part can be implemented with dataprovider or xml file, but for now i am giving a hashmap from the test case itselg due to time constraint.
		 * 
		 */
		HashMap<String,String> customerDetails = new HashMap<String,String>();
		customerDetails.put("FirstName", "FirstName");
		customerDetails.put("LastName", "LastName");
		customerDetails.put("Email", "email");
		customerDetails.put("Company", "company");
		customerDetails.put("Industries", "Wind");
		customerDetails.put("NumberOfEmployees", "Under 500");
		customerDetails.put("FunctionRoleAtCompany", "Others");
		
		logger.testStepLog("Step4: Enter the Customer details for Demo of Wind Industry");
		Assert.assertTrue(demoPageObj.collectCustomerDetails(customerDetails),"Failed to enter the customer Details");		
	}

}
