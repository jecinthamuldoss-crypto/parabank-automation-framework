package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG {
	
	
	
	public static ExtentReports getreportObject(){
		
		String path = System.getProperty("user.dir") + "/reports/index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("PARA BANK SITE");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Jecintha", "Tester");
		return extent;
		
	}

}
