package sfdc.steps;

import io.cucumber.java.en.Given;
import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmod.pages.SfdcHomePage;
import sfdc.pageobjmod.pages.SfdcLoginPage;
import sfdc.pageobjmod.tests.BaseTest;
import sfdc.pageobjmodutil.TestDataUtil;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver;
	SfdcLoginPage login;

	@Given("User in on the login page")
	public void user_in_on_the_login_page() {
		driver = BaseTest.getDriver("chrome", false);
		driver.get("https://login.salesforce.com/");
		Assert.assertTrue(driver.getTitle().contains("Login | Salesforce"));
		System.out.println("test passed");
		login = new SfdcLoginPage(driver);

	}

	@Given("user enters valid {string} and valid {string}")
	public void user_enters_valid_username_and_valid_password(String username, String password) {

		login.enterusername(username);
		login.enterpasswrd(password);

	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		login.loginbutton(driver);

	}

	@Then("User should see the Home page")
	public void user_should_see_the_home_page() {
		SfdcHomePage hp = new SfdcHomePage(driver);
		hp.IsHomepage(driver);

	}

	@Given("user enters invalid {string} and valid {string}")
	public void user_enters_invalid_username_and_valid_password(String username, String password) {
//		login.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "invalid.username"));
//		login.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.password"));
		login.enterusername(username);
		login.enterpasswrd(password);
	}

	@Then("User should see the Error message")
	public void user_should_see_the_error_message() {
		login.geterrmsg();
		login.verifyerrormsgonlognPage();

	}

	@Given("user enters invalid {string} and invalid {string}")
	public void user_enters_invalid_username_and_invalid_password(String username, String password) {
//		login.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "invalid.username"));
//		login.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "invalid.password"));
		login.enterusername(username);
		login.enterpasswrd(password);

	}

	@Given("user enters valid {string} and invalid {string}")
	public void user_enters_valid_username_and_invalid_password(String username, String password) {
		login.enterusername(username);
		login.enterpasswrd(password);
//		login.enterusername(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.username"));
//		login.enterpasswrd(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "invalid.password"));

	}

}
