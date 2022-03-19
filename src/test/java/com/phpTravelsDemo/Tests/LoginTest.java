package com.phpTravelsDemo.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.phpTravelsDemo.BaseTest.BaseTest;
import com.phpTravelsDemo.Pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage lpage;

	public LoginTest() {

		super();
	}

	@BeforeMethod
	public void SetUp() {

		ReadProperties();
		lpage = new LoginPage();
	}

	@Test(priority = 1)
	public void CheckPageTitleBeforeLoggedIn() {

		String title = lpage.ValidatePageTitle();
		Assert.assertEquals(title, "Login - PHPTRAVELS");

	}

	@Test(priority = 2, dataProvider = "InvalidLogin",enabled = true)
	public void CheckForInvalidLogin(String username, String password) {

		lpage.InvalidateSignIn(username, password);

	}

	@Test(priority = 3, dataProvider = "ValidLogin")
	public void CheckForValidLogin(String username, String password) {

		driver.navigate().refresh();
		lpage.Login(username, password);

	}

	@AfterMethod
	public void TearDown() {

		driver.quit();

	}

}
