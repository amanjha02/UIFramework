package com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.BrowserType;

public interface ConfigReader {
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
//	public String getUrl();
//	public String getUserName();
//	public String getPassword();
}
