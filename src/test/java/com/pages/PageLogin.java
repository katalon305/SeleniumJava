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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	
	@FindBy(name = "userName")
	private WebElement userFieldElement;
	//private By userField;
	@FindBy(name = "password")
	private WebElement passwordFieldElement;
	//private By passwordField;
	@FindBy(name = "submit")
	private WebElement loginButtonElement;
	//private By loginButton;
	@FindBy(tagName = "input")
	private List<WebElement> fieldsElement;
	//private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		//userField = By.name("userName");
		//passwordField = By.name("password");
		//loginButton = By.name("submit");
		//fields = By.tagName("input");
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user, String password) {
		userFieldElement.sendKeys(user);
		//driver.findElement(userField).sendKeys(user);
		passwordFieldElement.sendKeys(password);
		//driver.findElement(passwordField).sendKeys(password);
		loginButtonElement.click();
		//driver.findElement(loginButton).click();
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
		//List<WebElement> loginFields = driver.findElements(fields);
		fieldsElement.get(1).sendKeys(user);
		fieldsElement.get(2).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyElements() {
		//List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(fieldsElement.size());
		Assert.assertTrue(fieldsElement.size() == 4);
	}
	
	public void putTitleInUserField() {
		String title = driver.getTitle();
		userFieldElement.sendKeys(title);
		Assert.assertEquals("Welcome: Mercury Tours", title);
	}

}
