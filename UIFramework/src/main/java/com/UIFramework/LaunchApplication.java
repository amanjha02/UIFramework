package com.UIFramework;

import org.openqa.selenium.WebDriver;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;

public class LaunchApplication extends Testbase {
public	WebDriver driver;
public static void main(String[] args) throws Exception {
	LaunchApplication l=new LaunchApplication();
	 l.setUpDriver(ObjectReader.reader.getBrowserType());
	
}
}
