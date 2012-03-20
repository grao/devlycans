package com.selng.wgenwebdriver.framework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class SelNGBase {
	
		public static WebDriver launchBrowser(String Location) {
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("https://devlr1.slidev.org");
			Select select = new Select(driver.findElement(By.tagName("select")));
			select.selectByVisibleText(Location);
			driver.findElement(By.id("go")).click();						
			return driver;			
			}
	
		/*public static void closeBrowser() {
			try {
				driver.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		(public static boolean isPresent(By element) throws Exception {
			boolean present;
			try {
			   driver.findElement(element);
			   present = true;
			} catch (NoSuchElementException e) {
			   present = false;
			}
			return false;
			
		}*/
		
}
	
	


