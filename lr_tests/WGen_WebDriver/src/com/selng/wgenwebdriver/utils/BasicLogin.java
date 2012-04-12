package com.selng.wgenwebdriver.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.selng.wgenwebdriver.framework.SelNGBase;
import com.selng.wgenwebdriver.loginData.LoginData;

public class BasicLogin extends SelNGBase {
		
		public static void login(LoginData Username,LoginData Password, WebDriver driver) throws Exception {
			
		driver.findElement(By.id("IDToken1")).sendKeys(Username.toString());
		driver.findElement(By.id("IDToken2")).sendKeys(Password.toString());
		driver.findElement(By.name("Login.Submit")).click();
		
	}
	/*public static void logout() {
		driver.findElement(By.cssSelector("a[href=/c/portal/logout])")).click();
	}*/

}
