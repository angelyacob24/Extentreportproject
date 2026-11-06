package Swagbasepkg;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Swagpagepkg.Swagloginpage;

public class Swagbase {

	public static WebDriver driver;
	public Swagloginpage obj;
	
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void setup()
	{
		reporter=new ExtentSparkReporter("./Reports/myreport1.html");
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setReportName("functionaltest");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "abc");
		extent.setSystemInfo("Browser Name", "Chrome");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
			
	}
	@BeforeMethod
	public void mthd(Method method)
	{
		obj=new Swagloginpage(driver);
		
	}
	
	@AfterMethod
	public void aftrmthd(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
				test.log(Status.FAIL,"test case failed is" +result.getName());
				test.log(Status.FAIL,"test case failed is" +result.getThrowable());
		}
		else if(result.getStatus() ==ITestResult.SUCCESS)
		{
			test.pass("Test passed: "+result.getName());
		}
		else if(result.getStatus() ==ITestResult.SKIP)
		{
			test.skip("Test skipped: "+result.getName());
		}
		
	}
	@AfterTest
	public void endreport()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
