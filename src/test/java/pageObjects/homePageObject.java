package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.testBase;

public class homePageObject extends testBase{

	public WebDriver driver;
	public homePageObject(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;
	
	public WebElement searchBox()
	{
		return searchBox;
	}
	
	@FindBy(css="div[class='products'] h4")
	List<WebElement> products;
	
	public List<WebElement> productsList()
	{
		return products;
	}
}
