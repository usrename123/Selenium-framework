package sfdc.pageobjmod.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmodutil.TestDataUtil;
import sfdc.pageobjmodutil.WaitUtil;

public class sfdcUserMenuPage extends SfdcBasePage {

	public sfdcUserMenuPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * This class contains all the page objects for the userMenu class
	 * 
	 * @author aruna bindra
	 * 
	 */

	@FindBy(xpath = "//li[@id='aboutTab']")
	public WebElement about_Tab;
	@FindBy(xpath = "//li[@id='contactTab']")
	public WebElement contact_Tab;
	@FindBy(xpath = "//a[contains( text(), 'My Profile')]")
	public WebElement myprofile_click;
	@FindBy(css = "body.hasMotif.userTab.UserProfilePage.ext-webkit.ext-chrome.sfdcBody.brandQuaternaryBgr:nth-child(2) div.bodyDiv.brdPalette.brandPrimaryBrd:nth-child(2) table.outerNoSidebar td.noSidebarCell div.profilePage.userProfilePage:nth-child(3) div.leftContent div.contactInfo.profileSection:nth-child(4) div.vfButtonBar h3:nth-child(1) div.vfButtonBarButton div.editPen a.contactInfoLaunch.editLink > img:nth-child(1)")
	public WebElement profiledit_button;
	@FindBy(css = "#listItem-shortBio > a > img")
	public WebElement about_me;
	@FindBy(xpath = "//ul[@class='publisherFeedItemTypeChoices']/li[1]")
	public WebElement post_link;
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement post_iframe;
	@FindBy(tagName = "body")
	public WebElement editable_Body;
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement postshare_button;
	@FindBy(xpath = "//ul[@class='publisherFeedItemTypeChoices']/li[2]")
	public WebElement file_button;
	@FindBy(xpath = "//ul[@class='publisherFeedItemTypeChoices']/li[2]")
	WebElement file_uploadtab;
	@FindBy(xpath = "//input[@type='file']")
	public WebElement choose_file;
	@FindBy(id = "chatterUploadFileAction")
	public WebElement addPhoto_link;

	@FindBy(id = "contactInfoContentId")
	public WebElement contactinfo_IframeId;
	@FindBy(id = "aboutMeContentId")
	public WebElement Aboutme_Iframe;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
	public WebElement Save_all;
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement share_file;
	@FindBy(xpath = "//a[contains(text(),'Add Photo')]")
	public WebElement add_Photo;
	@FindBy(id = "uploadPhotoContentId")
	public WebElement addphoto_iframe;
	@FindBy(xpath = "//input[@type='file']")
	public WebElement photoupload_button;
	@FindBy(xpath = "//body[1]/span[1]/form[1]/div[3]/input[3]")
	public WebElement cancel_button;
	@FindBy(xpath = "//input[@class='lastName zen-inputFull zen-input']")
	WebElement Last_Name;
	@FindBy(xpath = "//a[contains( text(), 'My Settings')]")
	public WebElement my_Settings;
	@FindBy(xpath = "//div[@id='PersonalInfo']")
	public WebElement personal_info;
	@FindBy(xpath = "//span[@id='LoginHistory_font']")
	public WebElement login_History;
	@FindBy(xpath = "//*[@id='RelatedUserLoginHistoryList_body']/div/a")
	public WebElement download_Link;
	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	public WebElement display_and_layout;
	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	public WebElement customize_myTab;
	@FindBy(xpath = "//*[@id=\"p4\"]")
	public WebElement customizeapp_dropdown;
	@FindBy(xpath = "//select[@id='duel_select_0']")
	public WebElement avalTabs_AtCustomapp;
	@FindBy(xpath = "//span[@id='EmailSetup_font']")
	public WebElement Email_tab;
	@FindBy(xpath = "//span[@id='EmailSettings_font']")
	public WebElement myEmail_setting;
	// input[@id='sender_name']
	@FindBy(xpath = "//input[@id='sender_name']")
	public WebElement Emailsender_name;
	@FindBy(xpath = "//input[@id='sender_email']")
	public WebElement Email_address;
	@FindBy(xpath = "//input[@id='auto_bcc1']")
	public WebElement BCC_button;
	@FindBy(xpath = "//td[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save_button;
	@FindBy(xpath = "//span[@id='CalendarAndReminders_font']")
	public WebElement calander_and_Reminders;
	@FindBy(xpath = "//span[@id='Reminders_font']")
	public WebElement Activity_reminders;
	@FindBy(xpath = "//input[@id='testbtn']")
	public WebElement Opena_Test_reminder;
	@FindBy(xpath = "//a[contains( text(), 'Developer Console')]")
	public WebElement developers_consol;
	@FindBy(xpath = "//a[contains( text(), 'Logout')]")
	public WebElement Log_out;

	public String getTittleHomepage(WebDriver driver) { // not required
		return driver.getTitle();

	}

	/**
	 * 
	 * @param driver
	 */

	public void AboutMeTabclick(WebDriver driver) {

		if (this.about_me.isDisplayed()) {
			about_me.click();
		} else {
			System.out.println("About me Tab did not click");
		}
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */

	public boolean verifyAbotmeIframeAvailability(WebDriver driver) {
		boolean Isiframeloaded2 = false;
		if (WaitUtil.WaitToClick(Aboutme_Iframe, driver)) {
			driver.switchTo().frame(Aboutme_Iframe);
			if (this.about_Tab.isDisplayed() && this.contact_Tab.isDisplayed()) {
				Isiframeloaded2 = true;

			} else {
				System.out.println("usermanu: About me iframe is not loaded");
			}
		}
		return Isiframeloaded2;

	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void AboutTabinIframe(WebDriver driver) throws InterruptedException {
		String lastname = TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "valid.lastname");
		if (lastname == null) {
			System.out.println("Error: valid.lastname property is missing");
		} else {

			if (this.Last_Name.isDisplayed()) {
				this.Last_Name.clear();

				System.out.println("last name cleared");
				this.Last_Name.sendKeys(lastname);
			} else {
				System.out.println("FAILED");
			}

			if (this.Save_all.isDisplayed()) {

				this.Save_all.click();

				System.out.println("save all button clicked ");

			} else {
				System.out.println("save all button not visible ");
			}
		}

	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void myprofileClick(WebDriver driver) throws InterruptedException {
		SfdcHomePage hp = new SfdcHomePage(driver);

		if (!myprofile_click.isDisplayed()) {
			WaitUtil.WaitToClick(hp.User_Menu, driver);
			hp.User_Menu.click();
			WaitUtil.WaitTobeVisible(this.myprofile_click, driver);
			// Thread.sleep(2000);
			myprofile_click.click();
		}
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public boolean IsMyProfilePage(WebDriver driver) {
		// Wait for title explicitly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains("User: Aruna Bindra ~ Salesforce - Developer Edition"));
	}

	public void mySettingsClick(WebDriver driver) throws InterruptedException {
		SfdcHomePage hp = new SfdcHomePage(driver);

		if (!this.my_Settings.isDisplayed()) {
			WaitUtil.WaitToClick(hp.User_Menu, driver);
			hp.User_Menu.click();
			WaitUtil.WaitTobeVisible(this.my_Settings, driver);
			// Thread.sleep(2000);
			my_Settings.click();
		}
		// Hello, Aruna Bindra! ~ Salesforce - Developer Edition
	}

	public boolean IsMySettingsPage(WebDriver driver) {
		// Wait for title explicitly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains("Hello, Aruna Bindra! ~ Salesforce - Developer Edition"));
	}

	public void PersonelInfoAndLoginHisoryDwnlod(WebDriver driver) {
		if (this.personal_info.isDisplayed()) {
			personal_info.click();
		} else {
			System.out.println("Personal info tab not visible");
		}
		if (this.login_History.isDisplayed()) {
			Actions action = new Actions(driver);

			action.moveToElement(login_History).click().perform();
			action.moveToElement(download_Link).click().perform();

		} else {
			System.out.println("Login history not visible and Download didn't click");
		}

	}

	/**
	 * 
	 * @param driver
	 */

	public void EditProfileIconbutton(WebDriver driver) {
		if (profiledit_button.isDisplayed()) {
			if (WaitUtil.WaitToClick(this.profiledit_button, driver)) {

			} else {
				System.out.println("usermenu editMyProfile button did not get clicked");
			}
			profiledit_button.click();
			int size = driver.getWindowHandles().size();// this is to check that it is not a new window ,for windows the
														// size should be >1/here it is 1 so not a new window
			System.out.println(size);

//			WebElement CloseEditpopup = driver.findElement(By.xpath("//a[@id='contactInfoX']"));
//			CloseEditpopup.click();
		}

	}

	/**
	 * 
	 * @return
	 */

	public boolean verifyContactIframeAvailability(WebDriver driver) {
		boolean Isiframeloaded = false;
		if (WaitUtil.WaitToClick(this.contactinfo_IframeId, driver)) {
			driver.switchTo().frame(this.contactinfo_IframeId);
			if (this.about_Tab.isDisplayed() && this.contact_Tab.isDisplayed()) {
				Isiframeloaded = true;

			} else {
				System.out.println("usermanu: contactIframe is not loaded");
			}
		}
		return Isiframeloaded;
	}

	/**
	 * 
	 * @param driver
	 * @author
	 */

	public void aboutmeupdate(WebDriver driver) {

		if (about_Tab.isDisplayed()) {
			WaitUtil.WaitTobeVisible(about_Tab, driver);
			about_Tab.click();
//			WebElement Aboutmepopup = driver.findElement(By.xpath("//a[@id='aboutMeX']"));
//			Aboutmepopup.click();
		}
	}

	/**
	 * 
	 */
	public void HoverOvermoderator(WebDriver driver) {

		WebElement hoveroveraddphoto = driver.findElement(By.xpath("//span[@id='displayBadge']"));
		Actions action = new Actions(driver);
		action.moveToElement(hoveroveraddphoto).build().perform();

		System.out.println("hoverover successful");
	}

	/**
	 * wait to ensure hover effect is rendered Now trying to find the actual
	 * clickable "Add Photo" element that appears after hover
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void AddPhoto(WebDriver driver) throws InterruptedException {
		if (add_Photo.isDisplayed()) {
			add_Photo.click();
		}
		driver.switchTo().frame(addphoto_iframe);
		Thread.sleep(1000);
		photoupload_button.sendKeys("C:\\Users\\annur\\OneDrive\\Pictures\\BeautyPlus_20200525205815590_save (2).jpg");
		Thread.sleep(1000);
		cancel_button.click();
		driver.switchTo().defaultContent();
		System.out.println("photo loaded and window closed");
	}

	/**
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void postLinkClick(WebDriver driver) throws InterruptedException {

		if (this.post_link.isDisplayed()) {
			post_link.click();
			System.out.println("post link get clicked");
		} else {
			System.out.println("postlink Failed");
		}

		if (this.post_iframe.isDisplayed()) {
			driver.switchTo().frame(post_iframe);
			System.out.println("iframe loaded");
			// WaitUtil.WaitTobeavailable(post_link, driver);
			Thread.sleep(5000);
		} else {

			System.out.println("waiting for the iframe to load");
		}

		if (this.editable_Body.isDisplayed()) {
			this.editable_Body.sendKeys("next venture is under discussion");
		} else {
			System.out.println("argument did not appear");
		}

		driver.switchTo().defaultContent();
		Thread.sleep(3000);

		if (this.postshare_button.isDisplayed()) {
			this.postshare_button.click();
		} else {
			System.out.println("FAILED to  share the post");
		}
	}

	public void FileLinkClick(WebDriver driver) throws InterruptedException {

		if (this.file_button.isDisplayed()) {
			file_button.click();
			System.out.println("file button got clicked");
		} else {
			System.out.println("filebutton not clicked");
		}
		if (this.file_uploadtab.isDisplayed()) {
			WaitUtil.WaitTobeVisible(file_uploadtab, driver);
			file_button.click();
			System.out.println("upload file button got clicked");
		} else {
			System.out.println("upload filebutton not clicked");
		}

		WebElement choosefile = driver.findElement(By.xpath("//input[@type='file']"));
		choosefile.sendKeys("C:\\Users\\annur\\OneDrive\\Documents\\DBTables.xlsx");
		if (this.share_file.isDisplayed()) {

			System.out.println("PASS  + share button skipped intentinally");
		} else {
			System.out.println("Sharing got FAIL");
		}

	}

	public void DisplayandlayoutAndCustomizeMyapp(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);

		if (this.display_and_layout.isDisplayed()) {
			this.display_and_layout.click();
			action.moveToElement(customize_myTab).click().perform();
		} else {
			System.out.println("Action failed for display&layout =>customize my app");

		}

		Select select = new Select(this.customizeapp_dropdown);
		select.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(3000);
		Select select2 = new Select(avalTabs_AtCustomapp);
		System.out.println("selected");
		WaitUtil.WaitTobeVisible(avalTabs_AtCustomapp, driver);
		select2.selectByValue("report");
		driver.findElement(By.xpath("//a[@id='duel_select_0_right']")).click();
	}

	public void ClickOnEmaillink(WebDriver driver) {
		if (this.Email_tab.isDisplayed()) {
			Email_tab.click();
		} else {
			System.out.println("Email clicked");
		}
		if (this.myEmail_setting.isDisplayed()) {
			myEmail_setting.click();

		} else {
			System.out.println("myemail setting page opened");
		}
		if (this.Emailsender_name.isDisplayed()) {
			Emailsender_name.clear();
			WaitUtil.WaitTobeavailable(Emailsender_name, driver);
			Emailsender_name.sendKeys("Aruna Bindra");
		} else {
			System.out.println("Email Sender not visible-Failed");
		}
		if (this.Email_address.isDisplayed()) {
			Email_address.clear();
			WaitUtil.WaitTobeavailable(Email_address, driver);
			Email_address.sendKeys("aruna.bindra@gmail.com");
			this.BCC_button.click();
		} else {
			System.out.println("Email address not visible-Failed");
		}
		if (this.save_button.isDisplayed()) {
			save_button.click();
		}

	}

	public void CalenderAndReminders(WebDriver driver) {
		if (this.calander_and_Reminders.isDisplayed()) {
			calander_and_Reminders.click();
		} else {
			System.out.println("calander_and_Reminders clicked");
		}
		if (this.Activity_reminders.isDisplayed()) {
			Activity_reminders.click();

		} else {
			System.out.println("Activity_reminders page opened");
		}
		if (this.Opena_Test_reminder.isDisplayed()) {
			Opena_Test_reminder.click();

		} else {
			System.out.println("Opena_Test_reminder not visible-Failed");
		}

	}

	public void DevelopersConsolClick(WebDriver driver) {
		SfdcHomePage hp = new SfdcHomePage(driver);
		if (hp.User_Menu.isDisplayed()) {
			hp.User_Menu.click();
		} else {
			System.out.println("usermenu not visible");
		}
		if (this.developers_consol.isDisplayed()) {
			this.developers_consol.click();
		} else {
			System.out.println("developers tool is not visible");
		}
		driver.manage().window().maximize();
		String parenthandle = driver.getWindowHandle();
		driver.switchTo().window(parenthandle);
		int size = driver.getWindowHandles().size();
		if (size > 1) {
			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				if (!handle.equals(parenthandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}
		}
	}

	public void UserMenudropdownclick(WebDriver driver) {

		SfdcHomePage hp = new SfdcHomePage(driver);
		if (hp.User_Menu.isDisplayed()) {
			hp.User_Menu.click();
		} else {
			System.out.println("usermenu not visible");
		}

	}

	public void LogOutclick(WebDriver driver) {
		SfdcHomePage hp = new SfdcHomePage(driver);
		if (hp.User_Menu.isDisplayed()) {
			hp.User_Menu.click();
		} else {
			System.out.println("usermenu not visible");
		}
		if (this.Log_out.isDisplayed()) {
			// WaitUtil.WaitTobeVisible(Log_out, driver);
			this.Log_out.click();
		} else {
			System.out.println("Logout not visible");
		}

	}

}
