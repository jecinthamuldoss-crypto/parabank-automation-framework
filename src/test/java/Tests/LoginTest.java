package Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import Utils.ExcelUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
	
	public class LoginTest extends BaseTest {

	    @Test(groups = {"smoke", "regression"}, retryAnalyzer = TestComponents.Retry.class)
	    @Description("Verify user can login successfully using Excel credentials")
	    @Severity(SeverityLevel.CRITICAL)
	    public void launchTest() throws IOException {
	    	Assert.assertTrue(loginpage.loginsuccess(), "Login failed");
	    	
	    	
	    	//Assert.assertTrue(false, "Testing screenshot on failure");
	    	String username = ExcelUtils.getCellData("Login", 1, 0);
	    	String password = ExcelUtils.getCellData("Login", 1, 1);
	    	
	    	System.out.println("Username from Excel: " + username);
	        System.out.println("Password from Excel: " + password);

	    	
	    	loginpage.loginApplication(username, password);
	    	//Assert.assertTrue(loginpage.loginsuccess(), "Loginfailed");
	    	Assert.assertTrue(false, "Testing screenshot on failure");
	    	
	    	
	    	
	        System.out.println("login happened successfully");
	    }
	}

