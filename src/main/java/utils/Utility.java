package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sumit Kumar Sharma
 * @created at 20-Nov-2018
 */
public class Utility {
	
	/**
	 * This method is used for hard wait 
	 * @param sec
	 */
	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to wait explicitly for some time duration until element to be clickable.
	 * @param driver 
	 * @param time
	 * @param element
	 * @return
	 */
	public static WebElement waitForElement(WebDriver driver,long time, WebElement element ){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait explicitly for some time duration until element to be visible.
	 * @param driver 
	 * @param time
	 * @param element
	 * @return
	 */
	public static WebElement waitForElementToVisible(WebDriver driver, int time, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
}
