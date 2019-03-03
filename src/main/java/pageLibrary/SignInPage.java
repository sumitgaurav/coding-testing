package pageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;


/**
 * @author Sumit Kumar Sharma
 * Created Nov 19, 2018
 * This java class contains all the web elements presents in Sign In page and the methods to interact with those web elements.
 */

public class SignInPage {
	
	WebDriver driver;
	
	@FindBy(linkText ="Your trips")
	private WebElement yourTrips;
	
	@FindBy(id = "SignIn")
	private WebElement signInBtn;
	
	@FindBy(id = "signInButton")
	private WebElement signInBtn1;
	
	@FindBy(id = "errors1")
	private WebElement error;
	
	/**
	 * 	Class constructor to initialize the web elements
	 * @param driver
	 */
	public SignInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 	This method is used to click on Your trips and Sign In button present under drop down list.
	 */	
	public void clickOnSignInButtonPresentUnderYourTrips(){
		yourTrips.click();
		signInBtn.click();
	}
	
	/**
	 * This method is used to click on Sign In button present in "Sign in to Cleartrip" popup 
	 */
	public void clickOnSignInBtnInLoginWindow(){
		signInBtn1.click();
	}
	
	/**
	 * This method is used to return the error from "Sign in to Cleartrip" popup.
	 * @return
	 */
	public String getError(){
		return error.getText();
	}

}
