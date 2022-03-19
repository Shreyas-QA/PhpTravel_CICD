package com.phpTravelsDemo.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.phpTravelsDemo.BaseTest.BaseTest;

public class DashboardPage extends BaseTest {

	@FindBy(xpath = "//div[@class = 'main-menu-content']/nav/ul/li")
	List<WebElement> MainMenuContents;

	@FindBy(xpath = "//p[@id = 'ct']")
	WebElement GetCurrentTimeStamp;

	@FindBy(xpath = "//h4[@class='author__title']/strong[contains(text() ,'Demo')]")
	WebElement GetCurrentAuthorName;

	@FindBy(xpath = "//h4[@class='info__title' and contains(text(),'99')]")
	WebElement CheckTotalBookings;

	@FindBy(xpath = "//h4[@class='info__title' and contains(text(),'USD 1500')]")
	WebElement CheckWalletBalance;

	public DashboardPage() {

		PageFactory.initElements(driver, this);

	}

	public String ValidatePageTitle() {

		return driver.getTitle();
	}

	public void DisplayCurrentTimeStamp() {

		String getTimeStamp = GetCurrentTimeStamp.getText();
		System.out.println(getTimeStamp);
	}
	
	public String GetTimeZone() {
		
		String getTimeStamp = GetCurrentTimeStamp.getText();
		
		System.out.println(getTimeStamp.substring(getTimeStamp.lastIndexOf("/") + 1));
		
		return getTimeStamp;
		
		
	}
	
}
