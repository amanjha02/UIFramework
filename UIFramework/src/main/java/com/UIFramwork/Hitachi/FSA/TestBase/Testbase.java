package com.UIFramwork.Hitachi.FSA.TestBase;

import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.ChromeBrowser;
import com.UIFramwork.Hitachi.FSA.Helper.Excel.ExcelHelper;
import com.UIFramwork.Hitachi.FSA.Helper.Resource.resourceHelper;
import com.UIFramwork.Hitachi.FSA.Helper.Wait.WaitHelper;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;
import com.UIFramwork.Hitachi.FSA.Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Testbase {
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static File ReportDirectory;

	private Logger log = LoggerHelper.getLogger(Testbase.class);
	@BeforeTest
	public void BeforeTest() {
		ReportDirectory =	new File(resourceHelper.getResourcePath("/src/main/Resources/ScrenShot"));
	}
	@BeforeSuite
	public void beforeSuit() {
		extent=ExtentManager.getInstance();
	}
	@BeforeClass
	public void beforeClass() {
		test=extent.createTest(getClass().getName());
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO,method.getName()+"test started");
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,result.getName()+"is pass");
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,result.getThrowable());
		}
		extent.flush();
	}
	public WebDriver getBrowserObjet(com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.BrowserType btype) {
		try {
			switch(btype) {
			case CHROME:
				//get object of chromedriver class
			@SuppressWarnings("deprecation") ChromeBrowser chromeinstance=ChromeBrowser.class.newInstance();
		ChromeOptions option=	chromeinstance.getChromeOption();
			 return chromeinstance.getChromeDriver(option);
			}
		}
		catch (Exception e) {
		log.info(e.getMessage());
		}
		return driver;
	
	}
	
public void SetUpDriver(com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.BrowserType btype) {
	driver=getBrowserObjet(btype);
	log.info("intialize Wevdbriver instance"+driver.hashCode());
	WaitHelper Wait=new WaitHelper(driver);
	Wait.setImplicitWait(5000, TimeUnit.SECONDS);
	Wait.pageLoadTime(3000, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}

public String captureScreen(String FileName) {
	if(driver==null) {
log.info("Driver is null");
return null;
	}
	
	if(FileName==" ") {
		FileName="blank";
	}
	File destfile=null;
Calendar cal=Calendar.getInstance();
SimpleDateFormat  format=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
File SrcFile=  (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
	File destfile1=new File(ReportDirectory+"/"+FileName);
}
catch(Exception e) {
	
}
	


	return FileName;
}
}
