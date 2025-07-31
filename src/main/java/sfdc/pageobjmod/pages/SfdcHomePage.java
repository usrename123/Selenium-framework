package sfdc.pageobjmod.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.pageobjmodutil.WaitUtil;

public class SfdcHomePage extends SfdcBasePage {
	
	WebDriver driver;

	public SfdcHomePage(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	public WebElement Log_Out;
	@FindBy(xpath = "//div[@id='userNavButton']")
	public WebElement User_Menu;
	
	
/**
 * This Function is to verify if we are landed on the correct page
 * @param driver
 * @return
 */
	public boolean IsHomepage(WebDriver driver) {
		// Wait for title explicitly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.titleContains("Home Page ~ Salesforce - Developer Edition"));
	}
     /**
      * This function i sfor Logout from the Homepge
      * 
      * @param driver
      * @throws InterruptedException
      */
	public void logout(WebDriver driver) throws InterruptedException {
		if (User_Menu.isDisplayed()) {
			WaitUtil.WaitTobeVisible(this.Log_Out, driver);
			User_Menu.click();
			WaitUtil.WaitTobeVisible(this.Log_Out, driver);
			Log_Out.click();
		}
		
		
	}	
		
	}


