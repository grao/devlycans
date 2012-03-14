package com.selng.wgenwebdriver.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.selng.wgenwebdriver.framework.SelNGBase;
import com.selng.wgenwebdriver.loginData.LoginData;

public class BasicLogin extends SelNGBase {
		static WebDriver driver = new FirefoxDriver();
		public static boolean login(String UserName, String Password) throws Exception {
		boolean present;
		WebElement element = driver.findElement(By.id("IDToken1")); 
		element.sendKeys(LoginData.username_admin.get(),LoginData.password_admin.get());
		WebElement element1 = driver.findElement(By.id("IDToken2"));
		element1.sendKeys(LoginData.username_nonadmin.get(),LoginData.password_nonadmin.get());
		
		try {
			driver.findElement(By.xpath("//ul[@class='right_menu']/li/a"));
			present = true;
		}catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}
	public static void logout()
	{
		WebElement element = driver.findElement(By.cssSelector("a[href=/c/portal/logout])"));
		element.click();
	}

}
