package com.UIFramwork.Hitachi.FSA.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.UIFramwork.Hitachi.FSA.Helper.Assertion.VarificationHelper;
import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.Helper.Wait.WaitHelper;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;
import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;
import com.aventstack.extentreports.Status;

public class MyAccountPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	public static WebElement yourAccountPageMessage;
	
	@FindBy(xpath="//*[contains(text(),'Order history and details')]")
	public WebElement OrderHistoryAndDetails;
	
	@FindBy(xpath="//*[contains(text(),'My personal information')]")
	public WebElement MyPersonalInformation;
	
	@FindBy(xpath="//*[@id='center_column']/div/div[2]/ul/li/a/span")
	public WebElement wishLists;
	
	@FindBy(xpath="//*[@id='center_column']/h1")
	public WebElement myAccount;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(OrderHistoryAndDetails,ObjectReader.reader.getExplicitWait());
		Testbase.test.log(Status.INFO, "MyAccountPage object created");
		new Testbase().getNavigationScreen(driver);
	}
	
	public void clickOnWishLists(){
		wishLists.click();
		log.info("clciked on "+wishLists.getText());
		Testbase.test.log(Status.INFO, "clciked on "+wishLists.getText());
	}
	
	public void clickOnOrderHistoryAndDetails(){
		OrderHistoryAndDetails.click();
		log.info("clciked on "+OrderHistoryAndDetails.getText());
		Testbase.test.log(Status.INFO, "clciked on "+OrderHistoryAndDetails.getText());
	}
	
	public  boolean isYourAccountPageMessage(){
		return new VarificationHelper(driver).isDisplayed(yourAccountPageMessage);
	}
}
