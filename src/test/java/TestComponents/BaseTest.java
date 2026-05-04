package TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//public WebDriver driver;
	public LoginPage loginpage;
	public Properties prop;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();  //when you implement listeners we have to create ThreadLocal
	
	
	public WebDriver initializeDriver() throws IOException  {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/globaldata.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		
		//return driver;
		return getDriver();
		
	}
	public static WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeMethod (alwaysRun = true)
	public LoginPage launchapplication() throws IOException {
		initializeDriver();
		getDriver().get(prop.getProperty("url"));
		loginpage = new LoginPage(getDriver()); 
		return loginpage;
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void teardownpage() {
		if(getDriver()!= null) {
			getDriver().quit();
		}
		
	}
	
	public String getScreenshot(String TestcaseName) throws IOException {
	    TakesScreenshot ts = (TakesScreenshot) getDriver();
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String folderPath = System.getProperty("user.dir") + "/reports";
	    File folder = new File(folderPath);

	    if (!folder.exists()) {
	        folder.mkdir();
	    }

	    String filepath = folderPath + "/" + TestcaseName + ".png";
	    File destination = new File(filepath);

	    FileUtils.copyFile(source, destination);
	    return filepath;
	
		
		
	}   
	
	

}
