package sfdc.pageobjmodutil;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;

import sfdc.pageobjmod.tests.BaseTest;

public class TestListeners extends BaseTest implements ITestListener  {
	
	 @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Test Suite started: " + context.getName());
	        InitializeReport(); // Safe singleton init
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("Test Suite ended: " + context.getName());
	        if (reports != null) {
	            reports.flush();
	        }
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        WebDriver driver = BaseTest.getBrowser();
	        ExtentTest test = reports.createTest(result.getName());
	        test.pass("Test passed successfully.");
	        System.out.println("✅ Test Passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        WebDriver driver = BaseTest.getBrowser();
	        try {
	            String screenshotPath = new BaseTest().takeScreenshot(driver, result.getName());
	            ExtentTest test = reports.createTest(result.getName());
	            test.fail("Test Failed: " + result.getThrowable());
	            test.addScreenCaptureFromPath(screenshotPath);
	            System.out.println("Test Failed: " + result.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }
}