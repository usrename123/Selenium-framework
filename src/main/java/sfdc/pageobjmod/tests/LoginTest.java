package sfdc.pageobjmod.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;

import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmod.pages.SfdcHomePage;
import sfdc.pageobjmod.pages.SfdcLoginPage;
import sfdc.pageobjmodutil.TestDataUtil;
import sfdc.pageobjmodutil.TestListeners;
import sfdc.pageobjmodutil.WaitUtil;


@Listeners(TestListeners.class)

public class LoginTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	

	@BeforeMethod
	public void initMethod() {
		
		BaseTest.setDriver("chrome", false);
		//BaseTest.getDriver().manage().window().maximize();
		logger.info("chrome driver executed");
	}

	//@Test
	public void LoginErrorMessage() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);

		lp.laucnhApp(driver);
		lp.clearusername();
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.clearpassword();
		lp.loginbutton(driver);
		System.out.println("Actual error Message -> " + lp.geterrmsg().toString());
		logger.info("Actual error Message -> " + lp.geterrmsg().toString());
		Assert.assertTrue(lp.verifyEmptyPasswordErrMsg(), "Error message should match with the expected message");

	}

	 @Test
	public void LoginToSFDC() throws InterruptedException {

		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);

		lp.laucnhApp(driver);

		Assert.assertTrue(lp.IsLoginPage(driver), "Login page should be loaded");

		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));

		lp.clearpassword();

		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));

		lp.loginbutton(driver);

		Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
		logger.info("Test was successful");

	}

	 @Test
	public void RemembermeCheckBox() throws InterruptedException {

		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);

		lp.laucnhApp(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));

		lp.selectRemembermeCheckBox(driver);

		lp.loginbutton(driver);

		Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
		hp.logout(driver);
		WaitUtil.WaitTobeavailable(hp.Log_Out, driver);
		
		Assert.assertTrue(lp.IsLoginPage(driver));
		Thread.sleep(2000);
		System.out.println("logout was clicked");
		logger.info("logout was clicked");

	}

	// @Test
	public void forgotpasswordA() throws InterruptedException {

		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.forgotpassword(driver);

		lp.enterusernameOnpwdFogotbox(
				TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));

		lp.continueButton();
		System.out.println("continue button got clicked and email received");
		logger.info("continue button got clicked and email received");

	}

	// @Test
	public void forgotpasswordB() throws InterruptedException {

		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		lp.laucnhApp(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "invalid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		Thread.sleep(3000);
		lp.verifyerrormsgonlognPage();
		Assert.assertTrue(lp.verifyerrormsgonlognPage(), "actual message should match with ecpect3d");
		System.out.println("error message verified-PASS");
		logger.info("error message verified-PASS");
		

	}

	//@Test(dataProvider = "loginData", enabled = true)
	public void LoginToSFDC(String usr, String pswrd) throws InterruptedException {

		WebDriver driver = BaseTest.getBrowser();

		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);

		lp.laucnhApp(driver);

		Assert.assertTrue(lp.IsLoginPage(driver), "Login page should be loaded");

		lp.clearusername();

		lp.enterusername(usr);

		lp.clearpassword();

		lp.enterpasswrd(pswrd);

		lp.loginbutton(driver);

		Assert.assertTrue(hp.IsHomepage(driver), "Home page should be loaded");
		System.out.println("page loaded successfully");
		logger.info("page loaded successfully");

	}

	/**
	 * @implNote Mithun's login details are as sample,not acurate so the test may
	 *           fail ,therefore enabled =false the above test
	 * @return
	 */

	//@DataProvider(name = "loginData")
	public Object[][] getUsersData() {
		Object[][] data = { { "kafka@gmail.com", "MS$2025#" }, { "mithun@ta.com", "Mithun123" } };
		return data;

	}

	

	@AfterMethod
	public void teardown() {
		BaseTest.getBrowser().quit();
	}

}
