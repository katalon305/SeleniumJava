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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Login extends Conditions{
	
	@Test(description = "Login test by SIGN-ON", enabled = true)
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
	
	@Test(description = "Login test with assertPage", enabled = false)
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
}
