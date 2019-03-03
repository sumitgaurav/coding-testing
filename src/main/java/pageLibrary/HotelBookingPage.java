package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;
import utils.Constants;
import utils.Utility;

/**
 * @author Sumit Kumar Sharma
 * Created Nov 19, 2018
 * This java class contains all the web elements presents in Hotel booking page and the methods to interact with those web elements.
 */

public class HotelBookingPage {

    WebDriver driver;
    
    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;
    
    @FindBy(id = "CheckInDate")
    public WebElement CheckInDateField;
    
    @FindBy(id = "CheckOutDate")
    public WebElement CheckOutDateField;

    
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;
    
    @FindBy(xpath = "//ul[@id='ui-id-1']//li[@class='list']")
    private WebElement localityList;
     
    @FindBy(xpath = "//td[not(contains(@class,'ui-datepicker-unselectable'))]")
    private WebElement calendarDate;
    
    @FindBy(id = "showNearByBox")
    public WebElement searchTextBox;
    
    
	/**
	 * 	Class constructor to initialize the web elements
	 * @param driver
	 */
    public HotelBookingPage(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    /**
     * This method is used to click on Hotels tab present in Home page.
     */
    public void clickOnHotelsTab(){
    	hotelLink.click();
    }
    
    
    /**
     * This method is used to enter the location/City names in "Where" text field.
     * @param name
     */
    public void enterLocalityAndCityName(String name){
    	localityTextBox.sendKeys(name);
    	Utility.waitForElementToVisible(driver, 20, localityList);
    	localityTextBox.sendKeys(Keys.ENTER);
    }
    
    /**
     * This method is used to select calendar date from calendar popup.
     * @param day
     */
    public void selectDay(int day){
    	CheckInDateField.click();
    	calendarDate.findElement(By.xpath("//a[text()='"+day+ "']")).click();
    }
    
    /**
     * This method is used to select travellers from Travellers drop down list.
     * @param traveller
     */
    public void selectTravellers(String traveller){
    	new Select(travellerSelection).selectByVisibleText(traveller);
    }
    
    /**
     * This method is used to click on "Search Hotels" button.
     */
    public void clickOnSearchButton(){
    	searchButton.click();
    }
    
}
