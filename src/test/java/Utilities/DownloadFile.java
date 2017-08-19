package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class DownloadFile extends base {
	
	@BeforeTest
	public void Initialize464() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test
	public void DownloadFileTest() throws InterruptedException, AWTException{
		driver.get("http://www.google.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#lst-ib")).click();
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys("java download");
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div._NId:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".jvdla0 > span:nth-child(2)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".jvdla0 > span:nth-child(2)")).click();
		Thread.sleep(1000);
		//Using Robot API to handle Windows Object
		Robot obj1 = new Robot();
		obj1.keyPress(KeyEvent.VK_TAB);
		System.out.println("VK_Tapped");
		Thread.sleep(1000);
		obj1.keyPress(KeyEvent.VK_ENTER);
		System.out.println("VK_Entered");
		
	}
	
	
	
	
	
	

	@AfterTest
	public void teardown(){
		driver.quit();
	}
	

}
