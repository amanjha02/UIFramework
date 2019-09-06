package com.UIFramwork.Hitachi.FSA.Helper.Listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.UIFramwork.Hitachi.FSA.Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtenListner implements ITestListener {
	public static ExtentReports extent;
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		test.log(Status.INFO,result.getName()+" "+"Started");
		Reporter.log(result.getName()+"Test Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.INFO,result.getName()+" "+"Passed");
		Reporter.log(result.getName()+"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL,result.getName()+" "+"Started");
		Reporter.log(result.getName()+"Test Started");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP,result.getName()+" "+"Skiped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		extent=ExtentManager.getInstance();
		test=extent.createTest(getClass().getName());
		Reporter.log(context.getName()+"Test Started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
	Reporter.log(context.getName()+"Test Started");
		
	}

}
