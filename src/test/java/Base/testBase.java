package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class testBase extends ExtentBase{

	public static EdgeDriver driver;
	public static final String path = System.getProperty("user.dir")+"\\src\\test\\java\\xpaths\\xpath.properties";
	
	public static void initBrowser()
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}
	
	public static WebElement getElement(String element)
	{
		WebElement findElement=null;
		try
		{
			findElement = driver.findElement(By.xpath(getXpathProperties(element)));
			test.log(Status.INFO, "<b>The Element is "+element +"</b>");
		}
		catch(Exception e)
		{
			Throwable t = new Throwable(e);
			test.log(Status.FAIL,t.getMessage());
			test.log(Status.FAIL,"There is no Element for"+element);
		}
		return findElement;
	}
	
	public  void validation(String actual, String Expected) throws IOException
	{
		boolean check = actual.equals(Expected);
		if(check)
		{
			String [][] tableText = {{"Actual","Expected"},{actual,Expected}};
			test.log(Status.PASS,MarkupHelper.createTable(tableText),MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		}
		else
		{
			String [][] tableText = {{"Actual","Expected"},{actual,Expected}};
			//test.log(Status.FAIL, MarkupHelper.createTable(tableText));
			String base64File = getScreenshot();
			test.log(Status.FAIL, MarkupHelper.createTable(tableText),MediaEntityBuilder.createScreenCaptureFromBase64String(base64File).build());
		}
	}
	
	public void Description(String text)
	{
		test.info("<span style=color:yellow> "+text+" </span>");
	}
	
	public static String getXpathProperties(String element) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(element);
	}
	
	public String nestedJsonData(String parent, String child) throws FileNotFoundException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\TestData.json";
		FileReader reader = new FileReader(path);
		JsonReader jsonreader = new JsonReader(reader);
		JsonElement element = JsonParser.parseReader(jsonreader);
		//.out.println(element);
		JsonObject object = element.getAsJsonObject();
		JsonElement element1 = object.get(parent);
		String userName = element1.getAsJsonObject().get(child).toString();
		userName = userName.replace('"',' ');
		userName = userName.trim();
		return userName;
	}
	
	public String JsonData(String parent) throws FileNotFoundException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\TestData.json";
		FileReader reader = new FileReader(path);
		JsonReader jsonreader = new JsonReader(reader);
		JsonElement element = JsonParser.parseReader(jsonreader);
		//System.out.println(element);
		JsonObject object = element.getAsJsonObject();
		String parentProperties = object.get(parent).toString();
		parentProperties = parentProperties.replace('"', ' ');
		parentProperties = parentProperties.trim();
		return parentProperties;
	}
	
	public String getScreenshot() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\screenshot";
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File desFile = new File(path+"\\"+getDatePatternForScreenshot()+".jpg");
		String desFilePath = path+"\\"+getDatePatternForScreenshot()+".jpg";
		FileUtils.copyFile(srcFile, desFile);
		System.out.println(desFilePath);
		return desFilePath;
	}
	
	public void extentScreenshottest() throws IOException
	{
		String base64File = getScreenshot();
		//test.addScreenCaptureFromBase64String(base64File,"The homepage image");
		test.log(Status.PASS,MediaEntityBuilder.createScreenCaptureFromBase64String(base64File).build());
	}
	
	public String getDatePatternForScreenshot()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd-mm-yyyy HH-mm-ss");
		return sdf.format(date);
	}
}
