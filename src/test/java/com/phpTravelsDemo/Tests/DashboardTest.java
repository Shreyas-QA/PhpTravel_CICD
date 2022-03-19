package com.phpTravelsDemo.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.phpTravelsDemo.BaseTest.BaseTest;
import com.phpTravelsDemo.Pages.DashboardPage;
import com.phpTravelsDemo.Pages.LoginPage;

public class DashboardTest extends BaseTest {

	DashboardPage dpage;

	public DashboardTest() {

		super();
	}
	
	@BeforeMethod
	public void SetUp() {

		ReadProperties();
		dpage = new DashboardPage();
	}
	
	
	
	@AfterMethod
	public void TearDown() {

		driver.quit();

	}

}
