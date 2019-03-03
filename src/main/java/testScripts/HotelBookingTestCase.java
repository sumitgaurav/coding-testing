package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageLibrary.HotelBookingPage;
import testBase.TestBase;
import utils.Constants;
import utils.Utility;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 */

public class HotelBookingTestCase extends TestBase {

	HotelBookingPage hotelBookingPage;
	
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
		hotelBookingPage = new HotelBookingPage(driver);
	}
	
	// This test method will search for hotels in a particular city and validating user successful navigated to search result screen.
	@Test
	public void testSearchHotels() throws InterruptedException{
		hotelBookingPage.clickOnHotelsTab();
		Utility.waitForElement(driver, 20,hotelBookingPage.localityTextBox);
		hotelBookingPage.enterLocalityAndCityName(Constants.CITY_NAME);
		hotelBookingPage.selectDay(Constants.CHECK_IN_DATE);
		hotelBookingPage.selectDay(Constants.CHECK_OUT_DATE);
		hotelBookingPage.selectTravellers(Constants.TRAVELLER);
		hotelBookingPage.clickOnSearchButton();
		Utility.waitForElement(driver, 20, hotelBookingPage.searchTextBox);
		Assert.assertEquals(hotelBookingPage.searchTextBox.getAttribute("placeholder"), Constants.PLACE_HOLDER_TEXT_HOTEL);
	}
	
	
	//This method is used to close the browser after test complete.

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
