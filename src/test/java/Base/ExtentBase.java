package Base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentBase {
	
	public ExtentReports report;
	public static ExtentTest test;
	
	
	public void extentCofig()
	{
		String path = System.getProperty("user.dir")+"\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Testing Report");
		reporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	
	
	
}
