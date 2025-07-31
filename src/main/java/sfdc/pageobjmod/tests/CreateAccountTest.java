package sfdc.pageobjmod.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmod.pages.SfdcCreateAccountPage;
import sfdc.pageobjmod.pages.SfdcHomePage;
import sfdc.pageobjmod.pages.SfdcLoginPage;

import sfdc.pageobjmod.pages.sfdcUserMenuPage;
import sfdc.pageobjmodutil.TestDataUtil;

public class CreateAccountTest extends BaseTest {

	@BeforeMethod
	public void initMethod() {
		BaseTest.setDriver("chrome", false);

	}

	@Test
	public void AccoutTabClick() throws InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		SfdcHomePage hp = new SfdcHomePage(driver);

		SfdcCreateAccountPage ac = new SfdcCreateAccountPage(driver);

		lp.laucnhApp(driver);
		lp.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
		lp.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		lp.loginbutton(driver);
		System.out.println("page loaded successfully");
		Assert.assertTrue(hp.IsHomepage(driver), "landed on Home page");
		Thread.sleep(3000);
		//ac.AccountTabClickTC12(driver);// *To run this test need to update the data in send keys for view and unique view*
		//ac.ClickOnViewDropdownTC12(driver);// * To run this test need to update the data in send keys for view and unique view*
		//ac.MergeAccountsTC13(driver);
		ac.CreateAccountReportTC14(driver);


	}

	@AfterMethod(enabled = true)
	public void teardown() {
		BaseTest.getBrowser().quit();

	}

}
