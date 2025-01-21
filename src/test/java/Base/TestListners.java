package Base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners  extends ExtentBase implements ITestListener{

	String MethodName;
	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getTestClass().getName()+"."+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentCofig();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	public String MethodName()
	{
		return MethodName;
	}
}
