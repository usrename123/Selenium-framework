package sfdc.pageobjmod.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Set;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sfdc.pageobjmod.pages.SfdcHomePage;
import sfdc.pageobjmod.pages.SfdcLoginPage;
import sfdc.pageobjmod.pages.sfdcUserMenuPage;
import sfdc.pageobjmodutil.WaitUtil;

public class HomepageTestSudoCode extends BaseTest {
	WebDriver driver;
	
	@BeforeMethod
	public void initMethod() {
		driver=BaseTest.getDriver("chrome", false);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// @Test
	public void LoginErrorMessage() throws InterruptedException {
		// WebDriver driver=BaseTest.getDriver("chrome", false);
	    SfdcLoginPage lp = new SfdcLoginPage(driver);
        lp.laucnhApp(driver);
		lp.enterusername("kafka@gmail.com");
		lp.enterpasswrd("MS$2025#");

		lp.loginbutton(driver);
		System.out.println("page loaded successfully");

	}

	@Test
	public void myProfileclick() throws InterruptedException {
	    SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um =new sfdcUserMenuPage(driver);
        lp.laucnhApp(driver);
		lp.enterusername("kafka@gmail.com");
		lp.enterpasswrd("MS$2025#");

		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement view=driver.findElement(By.xpath("//input[@id='fname']"));
		view.sendKeys("Amazone");
		WebElement Uniqueview=driver.findElement(By.xpath("//input[@id='devname']"));
		Uniqueview.sendKeys("Amazone_TrueLife");
		WebElement SaveView=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		SaveView.click();
		
		//Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		//============================================//For window
//		WebElement usermenu=driver.findElement(By.xpath("//div[@id='userNavButton']"));
//		usermenu.click();
//		Thread.sleep(3000);
//		
//		WebElement devtools=driver.findElement(By.xpath("//a[contains( text(), 'Developer Console')]"));
//		Thread.sleep(3000);
//		devtools.click();
//		driver.manage().window().maximize();
//		String parenthandle=driver.getWindowHandle();
//		//driver.manage().window().getSize()
//		driver.switchTo().window(parenthandle);
//		int size = driver.getWindowHandles().size();
//		Set<String> handles=driver.getWindowHandles();
//		for(String handle:handles) {
//			if(!handle.equals(parenthandle)) {
//				driver.switchTo().window(handle);
//				
//				Thread.sleep(2000);
//				driver.close();
//			}
//		}
		//==============================================================
		//System.out.println(size);
		
		
//		um.mySettingsClick(driver);
//		WebElement personalinfo=driver.findElement(By.xpath("//div[@id='PersonalInfo']"));
//		personalinfo.click();
//		
//		WebElement loginHistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
//		//WebElement downloadLink=driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »"));
//		
//		
//		
//		Actions action=new Actions(driver);
//		
//			action.moveToElement(loginHistory).click().perform();
//			WebElement downloadLink=driver.findElement(By.xpath("//*[@id='RelatedUserLoginHistoryList_body']/div/a"));
//			downloadLink.click();
//			
		//action.moveToElement(downloadLink).click().perform();
        //um.myprofileClick(driver)
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("#listItem-shortBio > a > img")).click();
//        driver.switchTo().frame("aboutMeContentId");
//        WebElement lastname=driver.findElement(By.xpath("//input[@class='lastName zen-inputFull zen-input']"));
//        lastname.clear();
//        lastname.sendKeys("Bindra");
//        WebElement SaveAllButton=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"));
//        SaveAllButton.click();
       // um.IsMyProfilePage(driver);
        //um.HoverOvermoderator(driver);
        
		 //Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
        
        //=============================================Below one i sfor photo upload
//		 driver.findElement(By.xpath("//a[contains(text(),'Add Photo')]")).click();
//		 driver.switchTo().frame("uploadPhotoContentId");
//		 System.out.println("switched to iframe");
//		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\\\Users\\\\annur\\\\OneDrive\\\\Pictures\\\\BeautyPlus_20200525205815590_save (2).jpg");
//		 System.out.println("photo uploaded successfully");
//		 driver.findElement(By.xpath("//body[1]/span[1]/form[1]/div[3]/input[3]")).click();
		 
		 
//		 public WebElement file_button;
//			@FindBy(xpath = "//ul[@class='publisherFeedItemTypeChoices']/li[2]")
//			WebElement file_upload;
//			@FindBy(xpath = "//input[@type='file']")
       // ====================================================below is for file upload
        
//        driver.findElement(By.xpath("//ul[@class='publisherFeedItemTypeChoices']/li[2]")).click();
//        driver.findElement(By.id("chatterUploadFileAction")).click();
//        WebElement choosefile=driver.findElement(By.xpath("//input[@type='file']"));
//        choosefile.sendKeys("C:\\Users\\annur\\OneDrive\\Documents\\DBTables.xlsx");
//        //driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]")).click();  
//        WebElement post=driver.findElement(By.xpath("//ul[@class='publisherFeedItemTypeChoices']/li[1]"));
//        Thread.sleep(3000);
//        post.click();
//        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
//        driver.switchTo().frame(iframe);
//		System.out.println("iframe loaded");
//		Thread.sleep(3000);
//		WebElement editableBody = driver.findElement(By.tagName("body"));
//		editableBody.sendKeys("Project progress is good");
//		driver.switchTo().defaultContent();
//		 Thread.sleep(2000);
//		WebElement postsharebutton=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
//		
//		postsharebutton.click();		
		
	}

	// @AfterMethod
	public void teardown() {
		driver.quit();

	}

}
