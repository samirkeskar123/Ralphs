package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class ScreenShot extends base {
	

	@BeforeTest
	public void Initialize46() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test
	public void CaptureScreenShot() throws IOException {
		driver.get("http://www.facebook.com");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Learn Automation");
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("C:\\Users\\Samir Personal\\Desktop\\Snapshot\\Facebook.png"));
		System.out.println("Screnshot Captured");
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	

}
