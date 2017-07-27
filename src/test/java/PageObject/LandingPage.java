package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By Signin = By.cssSelector("#root > div > div.Page-sidebar > div > div > div.SignInPanel > div:nth-child(2) > button");
    By Search = By.cssSelector("#root > div > div.Page-top > div.Header.Page-header > div > div.DesktopHeader-primary > div.DesktopHeader-primary-left > div.DesktopHeader-search > div > div > form > span > input");
    By SearchButton = By.cssSelector(".Input-button");
    By StoreFinderLink = By.cssSelector(".NoPreferredStore-findStore");
    By StoreFinderZip = By.cssSelector("#DropdownSearch-searchInput");
    By StoreFinderZipbutton = By.cssSelector(".DropdownSearch-searchButton");
    By CityZip = By.xpath(".//*[@id='root']/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div/div/div[3]/div[2]/div/div[2]/div[1]/div[1]/a");
    
    //Creating Constructor
    public LandingPage(WebDriver driver) {
		this.driver = driver;
	
	}
    
    //Methods
    public WebElement getLogin(){
		return driver.findElement(Signin);
    	
    }
    
    public WebElement getSearch() {
		return driver.findElement(Search);
    	
    }
    
    public WebElement SearchButton(){
    	return driver.findElement(SearchButton);
    }
    
    public WebElement Storelinkfinder() {
    	return driver.findElement(StoreFinderLink);
    }
    
    public WebElement Storelinkzip(){
    	return driver.findElement(StoreFinderZip);
    }
    
    public WebElement StoreFinderZipbutton(){
    	return driver.findElement(StoreFinderZipbutton);
    }
    
    public WebElement StoreCityName() {
    	return driver.findElement(CityZip);
    }
}
