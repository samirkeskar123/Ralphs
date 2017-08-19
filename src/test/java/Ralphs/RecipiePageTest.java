package Ralphs;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;
import PageObject.LandingPage;
import PageObject.RecipiePage;


public class RecipiePageTest extends base {
	
	
	@BeforeTest
	public void Initialize511() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test 
	//Test Case to Validate ViewALLRecipie button
	public void ViewAllRecipies() throws InterruptedException{
		driver.get(prop.getProperty("url"));
		LandingPage lC = new LandingPage(driver);
		lC.ViewAllRecipies().click();
		Thread.sleep(1000);
		String Recipiepagevalidation= driver.getCurrentUrl();
		Assert.assertEquals("https://www.ralphs.com/recipes", Recipiepagevalidation);
	
	}
	
	@Test
	//Test Case to Validate FreshPicks Dropdown Menu
	public void FreshPicks() throws InterruptedException{
		driver.get(prop.getProperty("Recipieurl"));
		RecipiePage RP = new RecipiePage(driver);
		RP.FreshPick().click();
		Thread.sleep(1000);
		System.out.println("1");
		RP.SummerCheckBox().click();
		RP.SummerCheckBox().isSelected();
		System.out.println("2");
		Thread.sleep(3000);
		String oti=RP.RecipieTagg().getText();
    	System.out.println(oti);
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test
	//Test to validate all the drop down menu items
	public void WorldCusines() throws InterruptedException{
		driver.get(prop.getProperty("Recipieurl"));
		RecipiePage RP1 = new RecipiePage(driver);
		RP1.WorldCusine().click();
		Thread.sleep(2000);
List<WebElement> checkbox = driver.findElements(By.xpath(".//*[@id='root']/div/div[5]/div/div/div[2]/div[1]/div/section/ul/li[2]/div/ul/li"));
		for(int i=0; i<checkbox.size(); i++){
			WebElement Local = checkbox.get(i);
			String cus= Local.getAttribute("innerHTML");
			System.out.println("Values of checkboxes are----->"+ cus );
		}
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
	
	
	}

