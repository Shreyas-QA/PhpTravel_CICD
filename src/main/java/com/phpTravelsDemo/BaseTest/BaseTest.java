package com.phpTravelsDemo.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	public BaseTest() {

		try {
			prop = new Properties();
			FileInputStream fin;
			fin = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/phpTravelsDemo/Configs/AppConfig.properties");

			try {
				prop.load(fin);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	public static void ReadProperties() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");

			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {

//			System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	@DataProvider(name = "ValidLogin")
	public Object[][] validCredentials() {
		Object[][] objlist = { { prop.getProperty("username"), prop.getProperty("password") } };

		return objlist;
	}

	@DataProvider(name = "InvalidLogin")
	public Object[][] InvalidCredentials() {
		Object[][] objlist = { { "test", " " }, { "", "test" } };

		return objlist;
	}

	public void ClickElements(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void TypeInto(WebElement element, String text) {

		try {
			element.sendKeys(text);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
