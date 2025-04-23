package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This Method provides implementation to itestlistener interfaceof testNG
 *  @author Sujata
 */


public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;


	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" -> Test Excution started");
		
		//Intimate Extent report for Test
				test = report.createTest(MethodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" -> Test Excution Passed");
		
		//Log the Test result as PASS in Extent Report
				test.log(Status.PASS, MethodName + " -> @Test is pass");
		
	}

	
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" -> Test Excution Failed");
		//Capture the exception

		System.out.println(result.getThrowable());
		//Log the status as FAIL in extent report
				test.log(Status.FAIL, MethodName + " -> @Test is Fail");

				// Capture the exception
				System.out.println(result.getThrowable());
				
				//Log the exception in extent report
				test.log(Status.WARNING, result.getThrowable());
		
		// capture screen
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = MethodName+"-"+j.getSystemDateInFormat();
		try
		{
			s.captureScreenShot(BaseClass.sdriver, screenshotName);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}


	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" -> Test Excution Skipped");
		//Capture the exception
		System.out.println(result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//Configure the extent reports
		
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Reports - " +new JavaUtility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Chaitra");
		
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		report.flush();
	}
	

}
