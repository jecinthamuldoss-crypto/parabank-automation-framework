package TestComponents;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentreportNG.getreportObject();
	ExtentTest Test;
	
	@Override
	//On start
	public void onTestStart(ITestResult result) {
		Test = extent.createTest(result.getMethod().getMethodName());
	}
	
	//On Success
	public void onTestSuccess(ITestResult result) {
		Test.pass("Test is passed");
	}
	
	public void onTestSkipped(ITestResult result) {
		Test.skip("Test Skipped because its failing" + result.getMethod().getMethodName());
	}
	
	//On Failure
	public void onTestFailure(ITestResult result) {
		Test.fail(result.getThrowable());
		
		try {
			String path = getScreenshot(result.getMethod().getMethodName());
			Test.addScreenCaptureFromPath(path);    	
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
	}
	 @Override
	    public void onFinish(org.testng.ITestContext context) {
	        extent.flush();

}
}
