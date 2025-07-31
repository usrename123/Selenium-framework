package sfdc.pageobjmodutil;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.pageobjmod.tests.BaseTest;

public class WaitUtil extends BaseTest {

	public static boolean WaitToClick(WebElement element, WebDriver driver) {

		boolean IsElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));

			IsElementClickable = true;
		} catch (WebDriverException e) {
			e.printStackTrace();

		}

		return IsElementClickable;

	}
	
	public static boolean WaitTobeVisible(WebElement element, WebDriver driver) {

		boolean IsEleVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));

			IsEleVisible = true;
		} catch (WebDriverException e) {
			e.printStackTrace();

		}

		return IsEleVisible;
	
	}
	
	public static boolean fluentWait(WebDriver driver,String Xpath) {
		
		 Wait<WebDriver>fwait=new FluentWait<WebDriver>(driver)
	    		 .withTimeout(Duration.ofSeconds(30))
	    		 .pollingEvery(Duration.ofMillis(2000))
	    		 .ignoring(NoSuchElementException.class);
	     WebElement ele = fwait.until(new Function<WebDriver,WebElement>(){
	    	 public WebElement apply(WebDriver driver) {
	    		 return driver.findElement(By.xpath("Xpath"));
	    	 }
	    	 
	     });
		return ele.isDisplayed();	
		}
	
	public static boolean WaitTobeavailable(WebElement element, WebDriver driver) {

		boolean IsEleVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));

			IsEleVisible = true;
		} catch (WebDriverException e) {
			e.printStackTrace();

		} 

		return IsEleVisible;
	
	}
	

	
	
	

}
