package TestScript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base.testBase;
import pageObjects.homePageObject;

public class TestScript001 extends testBase{

	
	@Test
	public void tc001() throws IOException
	{
		Description("This Test Cases Verifies the search box functionality");
		initBrowser();
		homePageObject hm = new homePageObject(driver);
		List<WebElement> products = hm.productsList();
		for(int i = 0 ; i < products.size();i++)
		{
			test.log(Status.PASS,products.get(i).getText());
			System.out.println(products.get(i).getText());
		}
		getElement("searchBox").sendKeys("Carrot");
		hm.searchBox().clear();
		String placeholder = hm.searchBox().getAttribute("placeholder");
		validation(placeholder,"Search for Vegetables and Fruits");
		driver.navigate().refresh();
		
		
	}
	
	@Test
	public void tc002()
	{
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void tc003()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(true, true);
		sa.assertAll();
	}

}
