package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginButton;
	private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");
		fields = By.tagName("input");
	}
	
	public void login(String user, String password) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		/*File myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("./screenshots/LOGIN" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void fields_login(String user, String password) {
		List<WebElement> loginFields = driver.findElements(fields);
		loginFields.get(1).sendKeys(user);
		loginFields.get(2).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyElements() {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size() == 4);
	}

}
