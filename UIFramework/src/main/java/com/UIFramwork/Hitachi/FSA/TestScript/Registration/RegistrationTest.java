package com.UIFramwork.Hitachi.FSA.TestScript.Registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.UIFramwork.Hitachi.FSA.Helper.Assertion.AssertionHelper;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;
import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;
import com.UIFramwork.Hitachi.FSA.pageObject.LoginPage;
import com.UIFramwork.Hitachi.FSA.pageObject.MyAccountPage;
import com.UIFramwork.Hitachi.FSA.pageObject.RegistrationPage;

public class RegistrationTest extends Testbase{
	private Logger log=LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginpage;
	RegistrationPage register;
	MyAccountPage myAccountPage;
	
	@Test
	public void doRegistration() {
		//go to Application
		
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		 loginpage=new LoginPage(driver);
		 loginpage.clickOnSignInLink();
		 loginpage.enterRegistrationEmail();
		 
		register= loginpage.clickOnCreateAnAccount();
		
		//enter registration data
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		
		AssertionHelper.updateTestStatus(status);
		
	}
 
}
