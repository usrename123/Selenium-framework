package sfdc.pageobjmod.tests;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




public class BaseTest {
	//private static WebDriver driver = null;
	  public static WebDriver driver;
	  public static ExtentReports reports;
	
public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
	
	public static void setDriver(String bName, boolean headless) {
		driver = BaseTest.getDriver(bName, headless);
		try {
			threadLocal.set(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver getBrowser() {
		return threadLocal.get();
	}


	public static WebDriver getDriver(String browserName, boolean isHeadless) {
		WebDriver driver = null;

		String browser = browserName.toLowerCase();

		switch (browser) {
		case "chrome":
			if (isHeadless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);

			} else {
				driver = new ChromeDriver();
			}

			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			if (isHeadless) {
				FirefoxOptions fo = new FirefoxOptions();
				
				fo.addArguments("--headless");
				
				driver = new FirefoxDriver(fo);

			} else {
				driver = new FirefoxDriver();
			}
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println(browser + "is not supported");
			break;

		}
		return driver;

	}

	
	public void InitializeReport() {
	    if (reports == null) {
	        String reportPath = System.getProperty("user.dir") +
	            "/report/SalesForceReport_" +
	            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) +
	            ".html";
	     // Create the Spark Reporter with the file path
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	     // Create ExtentReports and attach the reporter
	        reports = new ExtentReports();
	        reports.attachReporter(sparkReporter);
	        reports.setSystemInfo("Environment", "QA");
	        reports.setSystemInfo("User", "Annu");

	        System.out.println("Report will be generated at: " + reportPath);
	    }
	}

	
	public String takeScreenshot(WebDriver driver ,String testname) throws Exception {
	    // Ensure screenshot folder exists
	    String screenshotDir = System.getProperty("user.dir") + "/report/ScreenShots";
	    new File(screenshotDir).mkdirs(); // Create folder if it doesn't exist

	    // Take screenshot
	    TakesScreenshot srcShot = (TakesScreenshot) driver;
	    File srcFile = srcShot.getScreenshotAs(OutputType.FILE);

	   
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imagePath = screenshotDir + "/Image_" + timestamp + ".png";

	    // Save file
	    File destFile = new File(imagePath);
	    FileUtils.copyFile(srcFile, destFile);

	    return imagePath;
	}
	


}
