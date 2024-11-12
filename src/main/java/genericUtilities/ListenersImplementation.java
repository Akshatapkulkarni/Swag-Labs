package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{

	//Capture the current system date and time  for ScreenShot name and Report Name
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date = sdf.format(d);

	//Used for Extent Reports
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		//Capture the method name of @Test
		String methodName = result.getMethod().getMethodName();


		/*@Test execution is started */
		System.out.println(methodName+" -> Test srcipt execution started");

		/*Intimate extent Reports for @Test execution*/ 
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//Capture the method Name of @Test
		String methodName = result.getMethod().getMethodName();

		/*@Test execution is PASS*/
		System.out.println(methodName+ " -> Test script is PASS");

		/*Log the status of test as PASS in Extent Report*/
		test.log(Status.PASS, methodName+ " -> Test script is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//Capture the method name of @Test
		String methodName = result.getMethod().getMethodName();

		/*@Test execution is FAIL*/
		System.out.println(methodName+" -> Test script is FAIL");

		//Capture the exception (its useful for reports) 
		System.out.println(result.getThrowable());

		/*Log the status for extent report*/
		test.log(Status.FAIL, methodName+" -> Test script is FAIL");

		/*Log the exception in extent report*/
		test.log(Status.WARNING, result.getThrowable());

		/*Capture the screenShot*/
		SeleniumUtility sUtil = new SeleniumUtility();

		//screenshot name is configured
		String ScreenShotName = methodName+date;

		try {
			String path = sUtil.captureScreenShot(BaseClass.sDriver, ScreenShotName);

			/*Attach the screenshot in Extent report*/
			test.addScreenCaptureFromPath(path);

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//since we are overridding all the methods(onTestFailure etc) as its a interface we cannot throws the ioexecption thats why we have to write the try catch block 
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//Capture the method name of @Test
		String methodName = result.getMethod().getMethodName();

		/*@Test script execution is SKIP*/
		System.out.println(methodName+" -> Test script is SKIP");

		//Capture the exception (its useful for reports) 
		System.out.println(result.getThrowable());

		/*Log the Status of test as Fail in Extent Report*/
		test.log(Status.SKIP, methodName+" -> Test script is SKIP");

		/*Log the exception in Extent report*/
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		/*Suite level execution -<suite>*/
		System.out.println("Suite  execution started");

		/*Basic configuration of Extent reports*/
		ExtentSparkReporter es = new ExtentSparkReporter(".\\ExtentReports\\Report-"+date+".html");
		es.config().setDocumentTitle("Swag labs Extent Reports");
		es.config().setTheme(Theme.DARK);
		es.config().setReportName("Execution bulid Version 1.12 ");

		/*Feed the configuration to extent reports class*/
		report = new ExtentReports();
		report.attachReporter(es);
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows family");
		report.setSystemInfo("Base Url", "TestEnv.com");
		report.setSystemInfo("Reporter Name", "Akshata");
	}

	@Override
	public void onFinish(ITestContext context) {

		/*Suite level execution -<suite>*/
		System.out.println("Suite  execution Finished");

		/*Generate the extent report*/
		report.flush();
	}

}
