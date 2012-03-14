package com.selng.wgenwebdriver.framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class SelNGBase {
		static WebDriver driver = new FirefoxDriver();
	
		public static void launchBrowser() {
			try {			
				driver.get("https://testlr1.slidev.org");
				WebElement element = driver.findElement(
				By.xpath("//form[@id='dummy']/select[@name='realmId']"));
			
				Select select = new Select(driver.findElement(By.tagName("select")));
				select.selectByVisibleText("SLI Realm");
				element.submit();
						
			}catch (Exception e) {
				e.printStackTrace();
				}
			}
	
		public static void closeBrowser() {
			try {
				driver.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		/*(public static boolean isPresent(By element) throws Exception {
			boolean present;
			try {
			   driver.findElement(element);
			   present = true;
			} catch (NoSuchElementException e) {
			   present = false;
			}
			return false;
			
		}
	/*public static boolean waitForCondition (String element, int sec) throws Exception 
	{
		WebDriver driver = new FirefoxDriver();
		WebElement element1 = driver.findElement(By.xpath(element));
		while(true) 
		{
			if(sec > 0) 
			{			
				try 
				{
					if(element) 
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
	}*/
		
}
	
	


