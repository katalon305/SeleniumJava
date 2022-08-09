package com.demo;

import org.testng.annotations.Test;

import com.pages.PageLogin;

public class Fields extends Conditions{
	@Test(description = "Total fields test", enabled = false)
	public void testTotalFields() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyElements();
	}
}
