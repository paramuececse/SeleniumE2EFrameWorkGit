 package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.DriverPackage.DriverClass;

import Com.ExtentReport.*;

public class Listeners extends DriverClass implements ITestListener {

WebDriver driver=null;
ExtentReports extentReport=ExtentReport.getExtentReport();
ExtentTest extentTest;

//method which invoked before each test method execution
@Override
public void onTestStart(ITestResult result) {
	extentTest=extentReport.createTest(result.getName());
}

//method which invoked before each test method sucessful.
@Override
public void onTestSuccess(ITestResult result) {
	//log the status 
	extentTest.log(Status.PASS, "Test Passed");
}
//Invoked each time a test fails.
@Override
public void onTestFailure(ITestResult result) {
	extentTest.fail(result.getThrowable());
	//get the name of failed test case
	String testName=result.getName();
	//Logic for screenshot capture
	try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} 
	catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
		e.printStackTrace();
	}
	
	try {
		
		String screenshotpath= takeScreenshot(testName, driver);
		extentTest.addScreenCaptureFromPath(screenshotpath);
			} catch (IOException e) {
		e.printStackTrace();
	}
}


public void onFinish(ITestContext context) {
	//flush the extent  to write the data to report file
	extentReport.flush();
}

}

