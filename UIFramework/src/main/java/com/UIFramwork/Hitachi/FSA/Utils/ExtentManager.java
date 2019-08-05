package com.UIFramwork.Hitachi.FSA.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports getInstance() {
		if(extent==null) {
		return createInstance("test-output/extent.html");
		}
		else {
			return extent;
		}
	}
	
	public static ExtentReports createInstance(String Filename) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Filename);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(Filename);
		htmlReporter.config().setReportName("AutomationScript");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
		
		
	}

}
