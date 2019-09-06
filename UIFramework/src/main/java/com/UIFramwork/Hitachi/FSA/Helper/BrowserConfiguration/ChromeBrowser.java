package com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.UIFramwork.Hitachi.FSA.Helper.Resource.resourceHelper;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome=DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		return option;
	}
	
	public WebDriver getChromeDriver(ChromeOptions cap) {
		System.setProperty("webdriver.chrome.driver",resourceHelper.getResourcePath("/src/main/Resources/Configfile/Driver/chromedriver.exe"));
	      return new ChromeDriver(cap);
	}

}
