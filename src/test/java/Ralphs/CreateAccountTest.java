package Ralphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObject.CreateAccountPage;
import resources.base;


public class CreateAccountTest extends base {
	
	@BeforeTest
	public void Initialize456() throws IOException {
		driver = initializeDriver();
		
	}
	
	
	@Test (dataProvider = "Location", priority = 1) 
	public void YourLocation(String LocationPassed) throws InterruptedException {
     	driver.get(prop.getProperty("CreateAccounturl"));
		CreateAccountPage CAP1 = new CreateAccountPage(driver);
		Thread.sleep(2000);
		CAP1.CreateAccountLocationSearch().click();
		Thread.sleep(1000);
		CAP1.CreateAccountLocationSearch().sendKeys("Location");
		CAP1.CreateAccountLocationButton().click();
		System.out.println("Click Successful");
	
	}
	
	// ShoppingList button url Testing on Create Account Page
    @Test (priority =2)
	  public void CreateAccountShoppingList() throws InterruptedException {
		driver.get(prop.getProperty("CreateAccounturl"));
		CreateAccountPage CAP2 = new CreateAccountPage(driver);
		Thread.sleep(1000);
		CAP2.CreateAccountShoppingList().click();
		Thread.sleep(2000);
		String Curl= driver.getCurrentUrl();
		System.out.println("Shopping List URL is "+ Curl);
		
	  }
	  
    // Terms and Condition link test on Create Account Page and Validate text on the page
    @Test (priority =3)
	  public void TermsAndCondition () throws InterruptedException {
		driver.get(prop.getProperty("CreateAccounturl"));
		CreateAccountPage CAP3 = new CreateAccountPage(driver);
		Thread.sleep(1000);
		CAP3.TermsAndCondition().click();
		Thread.sleep(2000);
		String TCLink = driver.getCurrentUrl();
		System.out.println("Shopping Terms and Conditions URL is "+ TCLink);
		Assert.assertEquals("Terms and Conditions", "Terms and Conditions");
		
	  }
	
    // Department Menu dropdown test to make sure that all the links exist.This is Bootstrap dropdown test
	 @Test (priority= 4)
	   public void DepartmentMenu1() throws InterruptedException{
		 driver.get(prop.getProperty("CreateAccounturl"));
		 CreateAccountPage CAP4 = new CreateAccountPage(driver);
		 Thread.sleep(1000);
		 CAP4.DepartmentMenu().click();
		 Thread.sleep(1000);
		 System.out.println("Testing dept menu");
	
		 List <WebElement> dd_menu = driver.findElements(By.xpath(".//*[@id='grid-wrap']/div/div/header/div/div[3]/div/span[1]/ul/li[1]/ul/li/a/span"));
		
		 for (int i=0; i<dd_menu.size();i++) {
			 
			 WebElement element = dd_menu.get(i);
			 String innerhtml = element.getAttribute("innerHTML");
			 System.out.println("Values from Depatment dropdown is ======"+ innerhtml);
    
		     }
		 }
		 
	// Department Menu bootstrap dropdown sublink testing
		 @Test (priority= 5)
		   public void DepartmentSubMenu() throws InterruptedException{
			 driver.get(prop.getProperty("CreateAccounturl"));
			 CreateAccountPage CAP5 = new CreateAccountPage(driver);
			 Thread.sleep(1000);
			 CAP5.SavingMenu().click();
			 Thread.sleep(1000);
			 System.out.println("Testing Saving menu");
			 Thread.sleep(1000);
			 
			 List <WebElement> dd_menu = driver.findElements(By.xpath(".//*[@id='grid-wrap']/div/div/header/div/div[3]/div/span[1]/ul/li[2]/ul/li[5]/a/span"));

			 for (WebElement element: dd_menu) {
				 
				 String innerhtml2 = element.getAttribute("innerHTML");
				
				 if(innerhtml2.contentEquals("Promotions")){
					 
					 element.click();
					 break;
				 }
				 
			     }
			 
			 }
		 
		 //Method to create Random emailid
			private static String randomEmail() {
				return "Tim"+Math.random()+"@mailinator.com";
		    }
		 
		
			//Creating a testcase to create unique emailid and password and use it to create account
		 @Test (priority= 6)
		 public void CreateAccount() throws InterruptedException {
			 
			 final String randomEmail = randomEmail();
			 
			 driver.get(prop.getProperty("CreateAccounturl"));
			 CreateAccountPage CAP6 = new CreateAccountPage(driver);
			 Thread.sleep(2000);
			 CAP6.CreateAccountLocationSearch().click();
		 	 Thread.sleep(1000);
			 CAP6.CreateAccountLocationSearch().sendKeys("95035");
			 CAP6.CreateAccountLocationButton().click();
			 CAP6.EmailId().sendKeys(randomEmail);
			 //System.out.println(randomEmail);
			 Thread.sleep(1000);
			 CAP6.ConfirmEmailId().sendKeys(randomEmail);
			 Thread.sleep(1000);
			 CAP6.Password().sendKeys("Ozark@1234");
			 Thread.sleep(1000);
			 CAP6.CreateAccountButton().click();
			//System.out.println("Account created");
			 Thread.sleep(4000);
			 String x= driver.getCurrentUrl();
             System.out.println(x);
		     String lop=  CAP6.CreateAccountSuccessmsg().getText();
		     System.out.println(lop);
		 }
	 
    
    @AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] Location(){
			
		return new Object[][]{
				
			new Object[] {"Los Angeles"},
			new Object[] {"Torrance"},
		
			};
	}
}
