package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	

	 By Email = By.cssSelector("#emailAddress");
	 By Password = By.cssSelector("#password");
	 By SigninButton = By.cssSelector("#submit");
	

	 //Creating Constructor
	 
	 public LoginPage(WebDriver driver) {
			super();
			this.driver = driver;
		}
	
	 
	 public WebElement getEmail() {
		return driver.findElement(Email);
		 
	 }
	 	
	 public WebElement getPassword() {
		 
		 return driver.findElement(Password);
		 
	 }
	 
	 public WebElement getloginbutton(){
		 
		 return driver.findElement(SigninButton);
	 }
	 

}
