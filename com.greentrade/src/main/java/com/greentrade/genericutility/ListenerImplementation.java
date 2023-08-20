package com.greentrade.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		WebActionUtility wLib = new WebActionUtility();
		String screenShot = wLib.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("Vivek A N");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Platform", "Windowns 10");
		report.setSystemInfo("Executed By", "Vivek A N");
		report.setSystemInfo("Reviewed By", "Rajesh B");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
