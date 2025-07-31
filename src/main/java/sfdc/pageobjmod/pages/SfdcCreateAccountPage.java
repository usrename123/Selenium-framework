package sfdc.pageobjmod.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.pageobjmod.tests.BaseTest;
import sfdc.pageobjmodutil.WaitUtil;



public class SfdcCreateAccountPage extends SfdcBasePage {


	public SfdcCreateAccountPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * @author annur This Page contains all the Elements and Functions for the
	 *         Create Account Pagee
	 * //body[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]
	 * //ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']
	 * //*[@id="editPage"]/div[1]/table/tbody/tr/td[2]/input[1]
	 */

	@FindBy(xpath = "//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']")
	public WebElement account_Tab;

	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	public WebElement Create_new_View;

	@FindBy(xpath = "//input[@id='fname']")
	public WebElement View_name;

	@FindBy(xpath = "//input[@id='devname']")
	public WebElement View_unique_name;

	@FindBy(xpath = "//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")
	public WebElement save_Viewuniquename;
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public boolean IsAccountPage(WebDriver driver) {
		SfdcHomePage hp = new SfdcHomePage(driver);
		SfdcLoginPage lp = new SfdcLoginPage(driver);
		sfdcUserMenuPage um = new sfdcUserMenuPage(driver);
		SfdcCreateAccountPage ac=new SfdcCreateAccountPage(driver);
		if(!WaitUtil.WaitTobeVisible(driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']")), driver)){
			System.out.println("Login page failed to load");
		}
	    String expectedAccountpage="Accounts: Create New View ~ Salesforce - Developer Edition";
	    
	    String actualtittle=driver.getTitle();
	    System.out.println(actualtittle);
	    WaitUtil.WaitTobeVisible(account_Tab, driver);
	    
		return this.getTitle(driver).equals(expectedAccountpage);
			
	}
	
	public void AccountTabOnly(WebDriver driver) {
		driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']")).click();
		
	}

	public void AccountTabClickTC12(WebDriver driver) throws InterruptedException {
		driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
		WebElement view=driver.findElement(By.xpath("//input[@id='fname']"));
		view.sendKeys("Amazone");
		WebElement Uniqueview=driver.findElement(By.xpath("//input[@id='devname']"));
		Uniqueview.sendKeys("Amazone_TrueLife");
		WebElement SaveView=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		SaveView.click();
	}
	public void ClickOnViewDropdownTC12(WebDriver driver) throws InterruptedException {
		WebElement accountTab=driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']"));
		accountTab.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement viewdropdown=driver.findElement(By.id("fcf"));
		viewdropdown.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select selec=new Select(viewdropdown);
		selec.selectByValue("00Baj00000RbFQ7");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Now retrieve and print the displayed text of the selected option:
		WebElement selectedOption = selec.getFirstSelectedOption();
		System.out.println("Selected option text: " + selectedOption.getText());
		
		WebElement viewedit=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		viewedit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement view=driver.findElement(By.xpath("//input[@id='fname']"));
		view.clear();
		view.sendKeys("Delhi Emporium");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Uniqueview=driver.findElement(By.xpath("//input[@id='devname']"));
		Uniqueview.clear();
		Uniqueview.sendKeys("Delhi_Emporium");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement FilterByAdditionalFieldsDropdown=driver.findElement(By.id("fcol1"));
		FilterByAdditionalFieldsDropdown.click();
		Select selec2=new Select(FilterByAdditionalFieldsDropdown);
		selec2.selectByValue("ACCOUNT.LAST_ACTIVITY");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement availabeFieldDropdown=driver.findElement(By.id("colselector_select_0"));
		Select selec3=new Select(availabeFieldDropdown);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selec3.selectByValue("ACCOUNT.LAST_ACTIVITY");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement addButton=driver.findElement(By.id("//a[@id='colselector_select_0_right']"));
		addButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement SaveView=driver.findElement(By.xpath("//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]"));
		SaveView.click();
		
		
		
		
	}
	
public void MergeAccountsTC13(WebDriver driver) throws InterruptedException {
	WebElement accountTab=driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']"));
	accountTab.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement mergeAccounts=driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
	mergeAccounts.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement accountFindsrcBox=driver.findElement(By.id("srch"));
	accountFindsrcBox.clear();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	accountFindsrcBox.sendKeys("United Oil & Gas");
	WebElement findAcountButton=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
	findAcountButton.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement next=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
	next.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement mergeButton=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
	mergeButton.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	
	}
public void CreateAccountReportTC14(WebDriver driver) throws InterruptedException {
	WebElement accountTab=driver .findElement(By.xpath("//ul[@id='tabBar']//following-sibling::li[@id='Account_Tab']"));
	accountTab.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement accountReport=driver.findElement(By.linkText("Accounts with last activity > 30 days"));
	accountReport.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement reportdroparrow=driver.findElement(By.xpath("//img[@id='ext-gen148']"));
	reportdroparrow.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement createdDate=driver.findElement(By.xpath("//*[@id='ext-gen265']/div[3]"));
	createdDate.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement FromcalanderDrpDwn=driver.findElement(By.xpath("//*[@id='ext-gen152']"));
	FromcalanderDrpDwn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement selectcustomdate=driver.findElement(By.xpath("//*[@id='ext-gen271']/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/a/em/span"));
	selectcustomdate.click();
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement TocalanderDrpDwn=driver.findElement(By.xpath("//*[@id='ext-gen154']"));
	TocalanderDrpDwn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement selectTodaydate2=driver.findElement(By.xpath("//*[@id='ext-gen295']"));
	selectTodaydate2.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebElement save=driver.findElement(By.xpath("//*[@id='ext-gen49']"));
	save.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	
	
	
}
}

