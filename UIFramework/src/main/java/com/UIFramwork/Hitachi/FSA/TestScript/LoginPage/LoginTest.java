package com.UIFramwork.Hitachi.FSA.TestScript.LoginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.UIFramwork.Hitachi.FSA.Helper.Assertion.AssertionHelper;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;
import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;
import com.UIFramwork.Hitachi.FSA.pageObject.LoginPage;

public class LoginTest extends Testbase {
private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = loginPage.verifySuccessLoginMsg();
		
		AssertionHelper.updateTestStatus(status);
	}

}
