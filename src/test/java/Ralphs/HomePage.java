package Ralphs;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.base;

public class HomePage extends base {

	//public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize123() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@Test (dataProvider = "Signindata")
	public void basePageNavigation(String Username,String Password) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();;
		Thread.sleep(2000);
		System.out.println("Login is clicked");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getloginbutton().click();
	}
	
	//Test to search for data on Landing page
	@Test (dataProvider = "SearchData")
	public void search(String Search) throws InterruptedException {

		driver.get(prop.getProperty("url"));
		LandingPage l2 = new LandingPage(driver);
		l2.getSearch().click();
		Thread.sleep(1000);
		System.out.println("Searchbutton is clicked");
		l2.getSearch().sendKeys(Search);
		l2.SearchButton().click();
	}
	
	//Test to search store by using Zipcode using City
	@Test (dataProvider = "Storezipsearch")
	public void storefinder(String Storezipsearch) throws InterruptedException{
		
		driver.get(prop.getProperty("url"));
		LandingPage l3 = new LandingPage(driver);
		l3.Storelinkfinder().click();
		Thread.sleep(1000);
		System.out.println("Storelink is clicked");
		l3.Storelinkzip().sendKeys(Storezipsearch);
		l3.StoreFinderZipbutton().click();
		
	}
		
	
	//Test to search store by using zipcode using Number zip
	
		@Test (dataProvider = "Storezipsearch1")
		public void storefinder1(String Storezipsearchnew) throws InterruptedException{
			
			driver.get(prop.getProperty("url"));
			LandingPage l4 = new LandingPage(driver);
			l4.Storelinkfinder().click();
			Thread.sleep(1000);
			System.out.println("Storelink by zipcode is clicked");
			l4.Storelinkzip().sendKeys( Storezipsearchnew);
		    l4.StoreFinderZipbutton().click();
		    String City= l4.StoreCityName().getText();
		    if(City == "90032"){
		    	System.out.println("City is El Sereno");
		    } 
		    
		    else {
		    	System.out.println("Wrong Results for the zipcode of 90032");
		    }
			
		    if(City == "95035"){
		    	System.out.println("City is Milpitas");
		    } 
		    
		    else {
		    	System.out.println("Wrong Results for the zipcode of 95035");
		    }
		}
			
	
	
	@AfterTest
	
	 public void teaddorn() {
		
		driver.close();
		driver =null;
		
	}
	
	@DataProvider 
	public Object[][] Signindata() {
		// 2 Row and 2 Column
		Object[][] data = new Object [2][2]; 
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		
		
		return data;
	}
	
	
	@DataProvider
	public Object[][] SearchData(){
		
		return new Object[][]{
			
			new Object[] {"coke"},
			new Object[] {"Pepsi"}
			
		};
		
	}
	
	@DataProvider
	public Object[][] Storezipsearch(){
			
		return new Object[][]{
				
			new Object[] {"San Jose"},
			new Object[] {"Milpitas"},
		
			};
	}
	
	
	@DataProvider
	public Object[][] Storezipsearch1(){
			
     return new Object[][]{
			
			new Object[] {"90032"},
			new Object[] {"95035"}
			
		};
	}
	
}
