package com.UIFramwork.Hitachi.FSA.Helper.Listner;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult arg0) {
		
		return false;
	}

}
