package sfdc.pageobjmod.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmod.pages.SfdcHomePage;
import sfdc.pageobjmod.pages.SfdcLoginPage;
import sfdc.pageobjmod.pages.sfdcUserMenuPage;
import sfdc.pageobjmodutil.TestDataUtil;
import sfdc.pageobjmodutil.TestListeners;


@Listeners(TestListeners.class)
public class UserMenuTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(UserMenuTest.class);
	//WebDriver driver;

	@BeforeMethod
	public void initMethod() {
		BaseTest.setDriver("chrome", false);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(enabled = true)
	public void myProfileclickAddPhoto() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));

		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		um.myprofileClick(driver);
		um.IsMyProfilePage(driver);
		um.HoverOvermoderator(driver);
		um.AddPhoto(driver);
		Thread.sleep(2000);

	}

	@Test(enabled = true)
	public void FileclickAndFileupload() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		um.myprofileClick(driver);
		um.IsMyProfilePage(driver);
		um.FileLinkClick(driver);

	}

	@Test(enabled=true)
	public void postLink() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		um.myprofileClick(driver);
		um.IsMyProfilePage(driver);
		um.postLinkClick(driver);

	}
	
	@Test(enabled=true)
	public void Aboutme() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		um.myprofileClick(driver);
		um.IsMyProfilePage(driver);
		um.AboutMeTabclick(driver);
		um.verifyAbotmeIframeAvailability(driver);
		um.AboutTabinIframe(driver);

	}
	
	@Test
	public void MysettingDropdown() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		Assert.assertTrue(lp.IsLoginPage(driver), "Login page should be loaded");
		lp.clearusername();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
		System.out.println("page loaded successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		um.mySettingsClick(driver);
		System.out.println("mysettings opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Assert.assertTrue(um.IsMySettingsPage(driver), "Landed on the MySettings page");
		um.PersonelInfoAndLoginHisoryDwnlod(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		//um.DisplayandlayoutAndCustomizeMyapp(driver);
		//um.ClickOnEmaillink(driver);
		um.CalenderAndReminders(driver);
	}
		
		@Test
		public void DevelopersConsol() throws InterruptedException {
			WebDriver driver = BaseTest.getBrowser();

			SfdcLoginPage lp = new SfdcLoginPage(driver);
			SfdcHomePage hp = new SfdcHomePage(driver);
			sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
			lp.laucnhApp(driver);
			Assert.assertTrue(lp.IsLoginPage(driver), "Login page should be loaded");
			lp.clearusername();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
			lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
			lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
			lp.loginbutton(driver);
			Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
			System.out.println("page loaded successfully");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
			um.DevelopersConsolClick(driver);
		}
			
			@Test
			public void LogOutClick() throws InterruptedException {
				WebDriver driver = BaseTest.getBrowser();

				SfdcLoginPage lp = new SfdcLoginPage(driver);
				SfdcHomePage hp = new SfdcHomePage(driver);
				sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
				lp.laucnhApp(driver);
				Assert.assertTrue(lp.IsLoginPage(driver), "Login page should be loaded");
				lp.clearusername();
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
				lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
				lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
				lp.loginbutton(driver);
				Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
				System.out.println("page loaded successfully");
				um.LogOutclick(driver);
				Assert.assertTrue(lp.IsLoginPage(driver), "home tittle should match");
			}
		       
		       
		    
		
		
	
	@AfterMethod(enabled = true)
	public void teardown() {
		driver.quit();

	}

}
