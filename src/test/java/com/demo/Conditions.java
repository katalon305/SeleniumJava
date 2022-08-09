package com.demo;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.helpers.Helpers;
import com.helpers.Screenshooter;

public class Conditions {
	protected WebDriver driver;
	ArrayList<String> tabs;
	//By logintrue = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

	@BeforeMethod
	public void beforeMethod() {
		String DriverByOS = "";
		
		if(System.getProperty("os.name").equals("Windows 10")) {
			DriverByOS = "drivers/chromedriver.exe";
		}else {
			DriverByOS = "drivers/chromedriver";
		}
		
		System.out.println(System.getProperty("os.name"));
		Helpers helpers = new Helpers();
		System.setProperty("webdriver.chrome.driver", DriverByOS);
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		//driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/selenium/newtours/");//https://demo.guru99.com/test/newtours/
		helpers.newTab("https://selenium-python.readthedocs.io/api.html#module-selenium.webdriver.support.expected_conditions", driver);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		helpers.sleepSeconds(3);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {
		System.out.println("Test " + iTestResult.getMethod().getDescription() + ", by status " + iTestResult.getStatus());
		if(!iTestResult.isSuccess()) {
			Screenshooter.takeScreenshot("Error", driver);
		}
		//driver.close();
		driver.switchTo().window(tabs.get(0)).close();
		driver.switchTo().window(tabs.get(1)).close();
	}
}
