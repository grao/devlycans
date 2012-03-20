package com.selng.wgenwebdriver.tests;

import org.openqa.selenium.WebDriver;
import com.selng.wgenwebdriver.framework.SelNGBase;
import com.selng.wgenwebdriver.loginData.LoginData;
import com.selng.wgenwebdriver.utils.BasicLogin;

public class LoginTest extends SelNGBase
{
	
	public static void LoginAdmin(String Location,LoginData Username,LoginData Password) throws Exception {
		WebDriver driver = launchBrowser(Location);
		BasicLogin.login(Username,Password,driver);			
	}
	
	public static void LoginNonAdmin(String Location,LoginData Username,LoginData Password) throws Exception {
		WebDriver driver = launchBrowser(Location);
		BasicLogin.login(Username,Password,driver);				
	}
		
}
