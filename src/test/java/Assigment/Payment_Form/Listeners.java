package Assigment.Payment_Form;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base_config;

public class Listeners extends base_config implements ITestListener {
	//For ExtentReporting
	ExtentReports extRep= new ExtentReporterNG().getReportconfig();
	ExtentTest test;
	//For Handlling Parellel Testing.. Thread safe concept
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test= extRep.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Pass");

		extentTest.get().pass("Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		// TODO Auto-generated method stub
		String testMethodName=result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String getScreenShotPath=getScreenshot(driver,testMethodName);
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath,testMethodName);
			extentTest.get().fail(result.getThrowable());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		   extRep.flush();

	}

}
