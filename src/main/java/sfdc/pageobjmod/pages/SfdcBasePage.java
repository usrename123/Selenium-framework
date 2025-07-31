package sfdc.pageobjmod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import sfdc.pageobjmod.constants.FileConstants;
import sfdc.pageobjmod.tests.BaseTest;
import sfdc.pageobjmodutil.TestDataUtil;
import sfdc.pageobjmodutil.WaitUtil;

public class SfdcBasePage {

	public SfdcBasePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void laucnhApp(WebDriver driver) {
		
		driver.get(TestDataUtil.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PATH, "app.url"));
	}
}
