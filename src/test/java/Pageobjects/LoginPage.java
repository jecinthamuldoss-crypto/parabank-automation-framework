package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="username")
	WebElement namefield;
	@FindBy(name="password")
	WebElement passwordfield;
	
	@FindBy(xpath= "//input[@value='Log In']")
	WebElement loginbutton;

	@FindBy(linkText = "Accounts Overview")
	WebElement Accountsoverview;
	
	public void loginApplication(String username, String password) {
		namefield.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbutton.click();
	}
	
	public boolean loginsuccess() {
		Accountsoverview.click();
		return Accountsoverview.isDisplayed() ;
	}
	
	
	
	
	
	}

