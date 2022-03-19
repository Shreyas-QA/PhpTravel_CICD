package com.phpTravelsDemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.phpTravelsDemo.BaseTest.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(name = "email")
	WebElement emailId;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//button/span[contains(text(),'Login')]")
	WebElement LoginButton;

	@FindBy(xpath = "//a/span[contains(text(),'Signup')]")
	WebElement SignUpButton;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public String ValidatePageTitle() {

		return driver.getTitle();
	}

	public void InvalidateSignIn(String username , String password) {
		TypeInto(emailId, username);
		TypeInto(Password, password);
		ClickElements(LoginButton);
		Assert.assertEquals(driver.getTitle(), "Login - PHPTRAVELS");
		
	}

	public void Login(String usn, String pwd) {

		emailId.sendKeys(usn);
		Password.sendKeys(pwd);
		LoginButton.click();
		Assert.assertEquals(driver.getTitle(), "Dashboard - PHPTRAVELS");
	}
}
