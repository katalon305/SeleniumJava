package com.demo;

import org.testng.annotations.Test;

import com.helpers.Helpers;
import com.helpers.Screenshooter;
import com.helpers.WebDriverManager;
import com.pages.PageLogin;
import com.pages.PageLogon;
import com.pages.PageReservation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Project {
	private WebDriver driver;
	ArrayList<String> tabs;
	//By logintrue = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

	@BeforeMethod
	public void beforeMethod() {
		Helpers helpers = new Helpers();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/selenium/newtours/");//https://demo.guru99.com/test/newtours/
		helpers.newTab("https://selenium-python.readthedocs.io/api.html#module-selenium.webdriver.support.expected_conditions", driver);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		helpers.sleepSeconds(3);
	}
	
	@Test
	public void testLogin() {
		//WebDriverManager.setWindowSize(driver, "fullscreen");
		driver.switchTo().window(tabs.get(1)).navigate().to("https://www.selenium.dev/downloads/");
		driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		Helpers helpers = new Helpers();
		PageLogon pageLogon = new PageLogon(driver);
		
		pageLogin.login("user", "user");
		driver.findElement(By.linkText("SIGN-ON")).click();
		helpers.sleepSeconds(3);
		pageLogon.assertLogonPage();
	}
	
	@Test
	public void testFlight() {
		//WebDriverManager.setWindowSize(driver, "fullscreen");
		driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		Helpers helpers = new Helpers();
		PageReservation pageReservation = new PageReservation(driver);
		
		pageLogin.login("mercury", "mercury");
		driver.findElement(By.linkText("Flights")).click();
		helpers.sleepSeconds(3);
		helpers.scrollTo(0, 500, driver);
		pageReservation.assertPage();
	}
	
	@Test
	public void testDropdown() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		Helpers helpers = new Helpers();
		PageReservation pageReservation = new PageReservation(driver);
		
		pageLogin.login("mercury", "mercury");
		driver.findElement(By.linkText("Flights")).click();
		helpers.sleepSeconds(3);
		helpers.scrollTo(0, 500, driver);
		pageReservation.assertPage();
		helpers.sleepSeconds(2);
		pageReservation.selectPassengers(2);
		helpers.sleepSeconds(2);
		pageReservation.selectFromport(3);
		helpers.sleepSeconds(2);
		pageReservation.selectToPort("London");
	}
	
	@Test
	public void testCantidadCampos() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyElements();
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {
		if(!iTestResult.isSuccess()) {
			Screenshooter.takeScreenshot("Error", driver);
		}
		//driver.close();
		driver.switchTo().window(tabs.get(0)).close();
		driver.switchTo().window(tabs.get(1)).close();
	}

}
