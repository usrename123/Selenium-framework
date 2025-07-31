package sfdc.pageobjmod.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
import sfdc.pageobjmodutil.WaitUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Listeners(TestListeners.class)
public class HomepageTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(HomepageTest.class);

	@BeforeMethod
	public void initMethod() {
		BaseTest.setDriver("chrome", false);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	 @Test
	public void Login() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));

		lp.loginbutton(driver);
		WaitUtil.WaitToClick(lp.login_button, driver);
		System.out.println("Home page loaded successfully");
		logger.info("Home page loaded successfully");
		

	}

	@Test
	public void myProfileclick() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));

		lp.loginbutton(driver);
		WaitUtil.WaitToClick(lp.login_button, driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		System.out.println("PASSED");

	}

    @AfterMethod
	public void teardown() {
		driver.quit();

	}

}
