package com.demo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.helpers.Helpers;
import com.pages.PageLogin;
import com.pages.PageReservation;

public class Flight extends Conditions{
	@Test(description = "Flight test and select airport")
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
}
