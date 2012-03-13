package com.selng.wgen.utils;

import org.junit.Assert;

import com.selng.wgen.framework.SelNGBase;

public class BasicLogin extends SelNGBase 
{
	public static boolean login(String UserName, String Password) throws Exception 
	{
		Assert.assertTrue(waitForCondition("xpath=//input[@id='IDToken1']", 20));
		sel.type("xpath=//input[@id='IDToken1']", UserName);
		Assert.assertTrue(waitForCondition("xpath=//input[@id='IDToken2']", 20));
		sel.type("xpath=//input[@id='IDToken2']", Password);
		
		sel.click("xpath=html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[5]/td[2]/div/input");
		sel.waitForPageToLoad("30000");
		//sel.type("xpath=//input[@id='_58_login']", "girish@wgen.com");
		//sel.type("xpath=//input[@id='_58_password']", "girish123");
		//sel.click("xpath=//div[@id='column-1']");
		return waitForCondition("xpath=//ul[@class='right_menu']/li/a", 20);
	}
	public static void logout()
	{
		sel.click("css=a['href='/c/portal/logout']");
	}

}
