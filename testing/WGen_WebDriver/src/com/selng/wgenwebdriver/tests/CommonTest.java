package com.selng.wgenwebdriver.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selng.wgenwebdriver.framework.SelNGBase;

public class CommonTest extends SelNGBase 
{
	/*@BeforeSuite(groups={"abstract"})
	public static void startTest()
	{
		startSeleniumServer();
	}
	@AfterSuite(groups={"abstract"})
	public static void stopTest()
	{
		stopSeleniumServer();
	}*/
	@BeforeMethod(groups={"abstract"})
	public void runTestCase()
	{
		launchBrowser();
	}
	@AfterMethod(groups={"abstract"})
	public void stopTestCase()
	{
		closeBrowser();
	}
}

