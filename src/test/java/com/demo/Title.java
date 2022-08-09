package com.demo;

import org.testng.annotations.Test;

import com.pages.PageLogin;

public class Title extends Conditions{
	@Test(description = "Title in user fields test", enabled = false)
	public void testTitleInUserField() {
		driver.switchTo().window(tabs.get(0));

		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.putTitleInUserField();
		//Screenshooter.takeScreenshot("TitleInUserField", driver);
	}
}
