package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageReservation {
	private WebDriver driver;
	private By titleText;
	private By passengersDrop;
	private By fromDrop;
	private By toDrop;
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td");
		passengersDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}
	
	public void assertPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().trim().contains("Flight Details"));
	}
	
	public void selectPassengers(int cantidad) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement locatorPassengers = wait.until(ExpectedConditions.presenceOfElementLocated(passengersDrop));
		Select selectPassengers = new Select(locatorPassengers);
		selectPassengers.selectByVisibleText(cantidad+"");
	}
	
	public void selectFromport(int index) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement locatorFrom = wait.until(ExpectedConditions.presenceOfElementLocated(fromDrop));
		Select selectFrom = new Select(locatorFrom);
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement locatorTo = wait.until(ExpectedConditions.presenceOfElementLocated(toDrop));
		Select selectToport = new Select(locatorTo);
		selectToport.selectByValue(city);
	}

}
