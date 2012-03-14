package com.selng.wgenwebdriver.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.selng.wgenwebdriver.loginData.LoginData;
import com.selng.wgenwebdriver.utils.BasicLogin;

public class LoginTest extends CommonTest
{
	static WebDriver driver = new FirefoxDriver(); 
	@Test(groups={"sanity"})	
	public boolean LoginAdmin() throws Exception
	{
		boolean result;
		BasicLogin.login(LoginData.username_admin.get(),
		LoginData.password_admin.get());		
		result =  driver.findElement(By.tagName("Admin")) != null;			
		BasicLogin.logout();
		return result;
	}
	@Test(groups={"sanity"})	
	public boolean LoginNonAdmin() throws Exception
	{
		boolean result;
		BasicLogin.login(LoginData.username_nonadmin.get(),
		LoginData.password_nonadmin.get());	
		result = driver.findElement(By.tagName("Admin")) != null;		
		BasicLogin.logout();
		return !result;
	}
}
