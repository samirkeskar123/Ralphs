package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecipiePage {

	public WebDriver driver;

	//Creating Constructor
	public RecipiePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	//Creating Page Objects
	
	By FreshPicksDrop = By.cssSelector("li.RecipeFilters-FilterType:nth-child(1) > a:nth-child(1) > h4:nth-child(1) > span:nth-child(1)");
	By SummerCheckBox = By.xpath(".//*[@id='root']/div/div[5]/div/div/div[2]/div[1]/div/section/ul/li[1]/div/ul/li/label/span/span[1]");
	By RecipieTag = By.xpath(".//*[@id='ViewRecipes-header']");
	By WorldCusine = By.xpath(".//*[@id='root']/div/div[5]/div/div/div[2]/div[1]/div/section/ul/li[2]/a/h4/span[1]");
	
	//Creating Methods
	public WebElement FreshPick(){
		return driver.findElement(FreshPicksDrop);
	}
	
	public WebElement SummerCheckBox(){
		return driver.findElement(SummerCheckBox);
	}
	
	public WebElement RecipieTagg(){
		return driver.findElement(RecipieTag);
	}
	
	public WebElement WorldCusine(){
		return driver.findElement(WorldCusine);
	}

}
