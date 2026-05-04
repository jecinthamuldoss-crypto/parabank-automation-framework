package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	int count = 0;
	int maxtry = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		if( count < maxtry) {
			count++;
			System.out.println("Retrying test : " + result.getName());
			return true;
		}
		return false;
		
	}
	
	
	
	
	

}
