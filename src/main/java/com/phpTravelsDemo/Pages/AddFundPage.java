package com.phpTravelsDemo.Pages;

import org.openqa.selenium.support.PageFactory;

import com.phpTravelsDemo.BaseTest.BaseTest;

public class AddFundPage extends BaseTest {

	public AddFundPage() {

		PageFactory.initElements(driver, this);

	}

	public String ValidatePageTitle() {

		return driver.getTitle();
	}

}
