package PageObject;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

	public WebDriver driver;

	
	//Creating Constructor for CreateAccountPage 
	public CreateAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Creating Page Objects
	
	By CreateAccountLocation = By.xpath(".//*[@id='preferredStoreLocation']");
	By CreateAccountLocationButton = By.cssSelector("#findStore");
	By CreateAccountShoppingList = By.cssSelector(".pinned-shopping-list-button");
	By TermsAndCondition = By.cssSelector("p.marginBottom:nth-child(3) > a:nth-child(1)");
	By TCtext = By.cssSelector("#terms-and-conditions-page>h1");
	By DepartmentMenu = By.cssSelector(".desktop-navigation > ul:nth-child(1) > li:nth-child(1)");
	By SavingMenu = By.cssSelector(".desktop-navigation > ul:nth-child(1) > li:nth-child(2)");
	By EmailID = By.cssSelector("#email");
	By ConfirmEmailID = By.cssSelector("#confirmEmail");
	By Password = By.cssSelector("#password");
	By CreateAccountButton = By.cssSelector("#submitButton");
	By CreateAccountSuccessmsg = By.xpath(".//*[@id='accountContainer']/div/p[2]");
	By SuccessAccountText = By.xpath(".//*[@id='accountContainer']/div/h1[1]");
	
	
	
	//li.DesktopMenuListItem--level1:nth-child(2) > a:nth-child(1)
	
	
	//Creating Methods

	public WebElement CreateAccountLocationSearch() {
		return driver.findElement(CreateAccountLocation);
	}
	
	public WebElement CreateAccountLocationButton(){
		return driver.findElement(CreateAccountLocationButton);
	}

	
	public WebElement CreateAccountShoppingList() {
		return driver.findElement(CreateAccountShoppingList);
	}
	
	public WebElement TermsAndCondition(){
		return driver.findElement(TermsAndCondition);
	}
	
	public WebElement TCtext(){
		return driver.findElement(TCtext);
	}

	public WebElement DepartmentMenu(){
		return driver.findElement(DepartmentMenu);
	}
	
	public WebElement SavingMenu(){
		return driver.findElement(SavingMenu);
	}
	
	public WebElement EmailId(){
		return driver.findElement(EmailID);
	}
	
	public WebElement ConfirmEmailId(){
		return driver.findElement(ConfirmEmailID);
	}
	
	public WebElement Password(){
		return driver.findElement(Password);
	}
	
	public WebElement CreateAccountButton(){
		return driver.findElement(CreateAccountButton);
	}
	
	public WebElement CreateAccountSuccessmsg(){
		return driver.findElement(CreateAccountSuccessmsg);
	}
	
	public WebElement AccountSuccessmsg(){
		return driver.findElement(SuccessAccountText);
	}
	
}

