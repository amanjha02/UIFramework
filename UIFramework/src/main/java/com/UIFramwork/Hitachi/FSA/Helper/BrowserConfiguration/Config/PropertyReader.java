package com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.BrowserType;
import com.UIFramwork.Hitachi.FSA.Helper.Resource.resourceHelper;

public class PropertyReader implements ConfigReader {
	private static FileInputStream file;

	public static Properties OR;



	public PropertyReader() {

		try {

			String filePath = resourceHelper.getResourcePath("src/main/resources/configfile/config.properties");

			file = new FileInputStream(new File(filePath));

			OR = new Properties();

			OR.load(file);			

			String filePath1 = resourceHelper.getResourcePath("src/main/resources/configfile/config1.properties");

			file = new FileInputStream(new File(filePath1));

			OR = new Properties();
			

			OR.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {

		return BrowserType.valueOf(OR.getProperty("browserType"));

	}
}
