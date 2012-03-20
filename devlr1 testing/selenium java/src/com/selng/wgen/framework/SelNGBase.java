package com.selng.wgen.framework;


import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.server.SeleniumServer;
import org.testng.Assert;


public class SelNGBase {
	static SeleniumServer selServer;
	public static Selenium sel;
	

	public static void startSeleniumServer() {
		try {
			selServer = new SeleniumServer();
			selServer.start();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void stopSeleniumServer() {
		selServer.stop();
	}
	
	public static void launchBrowser() {
		try {
			sel = new DefaultSelenium("localhost", 4444, "*chrome", "http://google.com");
			sel.start();
			sel.open("https://testlr1.slidev.org");
			sel.windowMaximize();
			Assert.assertTrue(waitForCondition("xpath=//form[@id='dummy']/select[@name='realmId']", 30));			
			sel.select("xpath=//form[@id='dummy']/select[@name='realmId']","label=SLI Realm");			
			sel.click("xpath=//input[@id='go']");
			//Assert.assertTrue(waitForCondition("xpath=//div/input[@id='IDToken1']", 30));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		try {
			sel.close();
			sel.stop();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean waitForCondition (String element, int sec) throws Exception 
	{
		while(true) 
		{
			if(sec > 0) 
			{			
				try 
				{
					if(sel.isElementPresent(element)) 
					{
						return true;
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				finally 
				{
					Thread.sleep(1000);
					sec--;
				}
			}
			else 
			{
				System.out.println("ELEMENT NOT FOUND" +element);
				return false;
			}
		}
	}
		
}
	
	


