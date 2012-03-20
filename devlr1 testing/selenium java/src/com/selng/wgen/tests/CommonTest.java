package com.selng.wgen.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.selng.wgen.framework.SelNGBase;

public class CommonTest extends SelNGBase 
{
	@BeforeSuite(groups={"abstract"})
	public static void startTest()
	{
		startSeleniumServer();
	}
	@AfterSuite(groups={"abstract"})
	public static void stopTest()
	{
		stopSeleniumServer();
	}
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
