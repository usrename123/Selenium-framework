package sfdc.pageobjmod.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmodutil.TestDataUtil;
import sfdc.pageobjmodutil.WaitUtil;

public class SfdcLoginPage extends SfdcBasePage {

	public SfdcLoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "#error")
	public WebElement logn_errmsg;
	@FindBy(name = "username")
	public WebElement user_name;
	@FindBy(id = "password")
	public WebElement pass_word;
	@FindBy(xpath = "//input[@id='Login']")
	public WebElement login_button;
	@FindBy(css = "#rememberUn")
	public WebElement rememberme_checkBox;
	@FindBy(linkText = "Forgot Your Password?")
	public WebElement forgot_password;
	@FindBy(id = "Login")
	public WebElement loginwith_email;
	@FindBy(xpath = "//a[contains( text() , 'Use Custom Domain')]")
	WebElement custom_domain;
	@FindBy(xpath = "//a[@id='forgot_password_link']")
	public WebElement forgot_pwd;
	@FindBy(xpath = "//input[@id='un']")
	public WebElement usernamerefillOnForgotPassword_box;
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continue_buttonrefillusrename;
	@FindBy(xpath = "//div[@id='error']")
	public WebElement errorMsgOn_loginpage;

	public void enterusername(String userId) {
		if (user_name.isDisplayed()) {
			user_name.sendKeys(userId);
		} else {
			System.out.println("add wait or check the code");

		}
	}

	public void clearusername() {
		if (user_name.isDisplayed()) {
			user_name.clear();
			;
		} else {
			System.out.println("add wait or check the code");

		}
	}

	public void enterpasswrd(String Pwd) {
		if (pass_word.isDisplayed()) {
			pass_word.sendKeys(Pwd);
		} else {
			System.out.println("add wait or check the code");

		}
	}

	public void clearpassword() {
		if (pass_word.isDisplayed()) {
			pass_word.clear();
		} else {

		}
	}

	public void loginbutton(WebDriver driver) {

		if (login_button.isDisplayed()) {
			WaitUtil.WaitTobeVisible(login_button, driver);
			login_button.click();

		} else {
			System.out.println("login button is not displayed");

		}

	}

	public String geterrmsg() {
		if (logn_errmsg.isDisplayed()) {
			return logn_errmsg.getText();
		} else {
			return null;

		}

	}

	public boolean verifyEmptyPasswordErrMsg() {
		String actualerrmessage = logn_errmsg.getText();

		// System.out.println(actualerrmessage.toString());

		String Expectederrmsg = TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH,
				"error.emptypwdnmessage");

		if (actualerrmessage.equals(Expectederrmsg)) {
			return true;

		} else {
			System.out.println(
					"actual error Message : " + "" + actualerrmessage + "Expected error message: " + Expectederrmsg);
			return false;
		}

	}

	public void selectRemembermeCheckBox(WebDriver driver) {

		if (!rememberme_checkBox.isSelected()) {
			WaitUtil.WaitToClick(rememberme_checkBox, driver);
			rememberme_checkBox.click();
		} else {
			System.out.println(" it is already selected ");

		}
	}

	public void forgotpassword(WebDriver driver) {

		if (!forgot_pwd.isSelected()) {
			WaitUtil.WaitToClick(forgot_pwd, driver);
			forgot_pwd.click();
		} else {

		}

	}

	public void enterusernameOnpwdFogotbox(String string) {
		if (usernamerefillOnForgotPassword_box.isDisplayed()) {
			usernamerefillOnForgotPassword_box.clear();

			usernamerefillOnForgotPassword_box.sendKeys(string);
		} else {

		}

	}

	public void continueButton() {

		if (continue_buttonrefillusrename.isDisplayed()) {
			continue_buttonrefillusrename.click();
			;
		} else {
			System.out.println("FAILED");

		}

	}

	public boolean verifyerrormsgonlognPage() {

		String Actualmessage = errorMsgOn_loginpage.getText();
		System.out.println(Actualmessage);
		String Expectedmessage = "Error: Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if (Actualmessage.equals(Expectedmessage)) {
			return true;
		} else {
			System.out.println(Actualmessage + ":: ActualMesage");
			return false;
		}

	}

	public boolean IsLoginPage(WebDriver driver) {
		// Wait for title explicitly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.titleContains("Login | Salesforce"));
	}

}
