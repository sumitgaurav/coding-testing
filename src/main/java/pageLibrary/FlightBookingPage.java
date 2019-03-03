package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;
import utils.Utility;

/**
 * @author Sumit Kumar Sharma
 * Created Nov 19, 2018
 * This java class contains all the web elements presents in Flight Booking page and the methods to interact with those web elements.
 */

public class FlightBookingPage {
	  WebDriver driver;
	 
	 @FindBy(id = "OneWay")
	  private WebElement oneWayRadioBtn;
	 
	 @FindBy(id = "FromTag")
	  private WebElement fromTextField;
	 
	 @FindBy(id = "ToTag")
	  private WebElement toTextField;
	 
	 @FindBy(id="DepartDate")
	 private WebElement calendar;
	 
	 @FindBy(xpath = "//td[not(contains(@class,'ui-datepicker-unselectable'))]")
	  private WebElement calendarDate;
	 
	 @FindBy(id = "SearchBtn")
	  private WebElement searchButton;
	 
	 @FindBy(xpath = "//div[@class='mDeal clearFix']//a")
	  public WebElement flightDealsLink;
	 
	 @FindBy(xpath="//ul[@id='ui-id-1']//li[@class='list']")
	 private WebElement fromList;
	 
	 @FindBy(xpath="//ul[@id='ui-id-2']//li[@class='list']")
	 private WebElement toList;
	 
	/**
	 * Class constructor to initialize the web elements
	 * @param driver
	 */ 
	  public FlightBookingPage(WebDriver driver){
		  this.driver=driver;
	      PageFactory.initElements(driver, this);
	    }
	  
	  /**
	   * This method is used to select one way radio button.
	   */
	  public void selectOneWayRadioButton(){
		  oneWayRadioBtn.click();
	  }
	  
	  /**
	   * This method is used to enter the city name in "From" text field.
	   * @param cityName
	   */
	  public void enterFromCityName(String cityName){
		  fromTextField.clear();
		  fromTextField.sendKeys(cityName);
		  Utility.waitForElementToVisible(driver, 20, fromList);
	      fromTextField.sendKeys(Keys.ENTER);	  
	  }
	  
	  /**
	   * This method is used to enter the city name in "To" text field.
	   * @param cityName
	   * @param index
	   */
	  public void enterToCityName(String cityName){
		  toTextField.clear();
		  toTextField.sendKeys(cityName);
		  Utility.waitForElementToVisible(driver, 20, toList);
	      toTextField.sendKeys(Keys.ENTER);
	  }
	  
	  /**
	   * Thie method is used to select calendar date from calendar popup
	   * @param day
	   */
	  public void selectDay(int day){
	    	calendar.click();
	    	calendarDate.findElement(By.xpath("//a[text()='"+day+ "']")).click();
	    }
	  
	  /**
	   * This method is used to click on search button.
	   */
	  public void clickOnSearchButton(){
		  searchButton.click();
	  }
	  
	  
}
