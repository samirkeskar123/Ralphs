package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By Signin = By.cssSelector("#root > div > div.Page-sidebar > div > div > div.SignInPanel > div:nth-child(2) > button");
    By Search = By.cssSelector("#root > div > div.Page-top > div.Header.Page-header > div > div.DesktopHeader-primary > div.DesktopHeader-primary-left > div.DesktopHeader-search > div > div > form > span > input");

    
    //Creating Constructor
    public LandingPage(WebDriver driver) {
		this.driver = driver;
	
	}
    

    public WebElement getLogin(){
		return driver.findElement(Signin);
    	
    }
    
    public WebElement getSearch() {
		return driver.findElement(Search);
    	
    	
    }
}
