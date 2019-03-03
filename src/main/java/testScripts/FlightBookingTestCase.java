package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageLibrary.FlightBookingPage;
import testBase.TestBase;
import utils.Constants;
import utils.Utility;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 */

public class FlightBookingTestCase extends TestBase {
	
	FlightBookingPage flightBookingPage;
	
	/**
	 * This method will call initBrowser method, where Chrome browser instance will 
	 * get created and "URL = https://www.cleartrip.com/" will be launched. This method 
	 * (browser initialization) will be executed before every Test and each test will be 
	 * independent from another test case. So that, If any test method gets failed then other test methods will
	 * not be affect because for every test method a new and fresh session will be created.
	 * @throws IOException  
	 */
		
	@Override
	@BeforeMethod
	public void setUp(){
		initBrowser();
		flightBookingPage = new FlightBookingPage(driver);
	}
	
	// This test method will search for flights between two cities on a particular date,
	// and will validate user successfully navigated to search result screen. 

	@Test
	public void testSearchFlight(){
		flightBookingPage.selectOneWayRadioButton();
		flightBookingPage.enterFromCityName(Constants.FROM_CITY_NAME);
		flightBookingPage.enterToCityName(Constants.TO_CITY_NAME);
		flightBookingPage.selectDay(Constants.CALENDAR_DATE);
		flightBookingPage.clickOnSearchButton();
		Utility.waitForElement(driver, 20, flightBookingPage.flightDealsLink);
		Assert.assertTrue(flightBookingPage.flightDealsLink.getText().contains(Constants.PLACE_HOLDER_TEXT_FLIGHT));
	}
	
	
	 // This method is used to close the browser after test complete.
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
