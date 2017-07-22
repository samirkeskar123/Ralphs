package Ralphs;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;

import java.io.IOException;

import org.apache.commons.logging.impl.Log4JLogger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

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
}
