package com.UIFramwork.Hitachi.FSA.TestBase;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.BrowserType;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.ChromeBrowser;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.FirefoxBrowser;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.IExplorer;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.PropertyReader;
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
	public void BeforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		ReportDirectory = new File(resourceHelper.getResourcePath("/src/main/Resources/ScrenShot"));
		SetUpDriver(ObjectReader.reader .getBrowserType());
	}

	@BeforeSuite
	public void beforeSuit() {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void beforeClass() {
		test = extent.createTest(getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {

		try {

			switch (btype) {

			case CHROME:

				// get object of ChromeBrowser class

				ChromeBrowser chrome = ChromeBrowser.class.newInstance();

				ChromeOptions option = chrome.getChromeOptions();

				return chrome.getChromeDriver(option);

			case FIREFOX:

				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();

				FirefoxOptions options = firefox.getFirefoxOptions();

				return firefox.getFirefoxDriver(options);

			case Iexplorer:

				IExplorer ie = IExplorer.class.newInstance();

				InternetExplorerOptions cap = ie.getIExplorerCapabilities();
				return ie.getIExplorerDriver(cap);
			default:
				throw new Exception("Driver not Found: " + btype.name());
			}
		}

		catch (Exception e) {
			log.info(e.getMessage());
			throw e;

		}
	}

	public void SetUpDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);

		log.info("Initialize Web driver: " + driver.hashCode());

		WaitHelper wait = new WaitHelper(driver);

		wait.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);

		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	public String captureScreen(String fileName, WebDriver driver){

		if(driver == null){

			log.info("driver is null..");

			return null;

		}

		if(fileName==""){

			fileName = "blank";

		}

		Reporter.log("captureScreen method called");

		File destFile = null;

		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try{

			destFile = new File(ReportDirectory+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");

			Files.copy(screFile.toPath(), destFile.toPath());

			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");

		}

		catch(Exception e){

			e.printStackTrace();

		}

		return destFile.toString();

	}
}
