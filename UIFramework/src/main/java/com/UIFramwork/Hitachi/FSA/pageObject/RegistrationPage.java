package com.UIFramwork.Hitachi.FSA.pageObject;

import java.util.Iterator;
import java.util.List;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.UIFramwork.Hitachi.FSA.Helper.BrowserConfiguration.Config.ObjectReader;
import com.UIFramwork.Hitachi.FSA.Helper.Wait.WaitHelper;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;
import com.UIFramwork.Hitachi.FSA.TestBase.*;;

public class RegistrationPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(RegistrationPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='id_gender1']")
	public WebElement mrRadioButton;

	@FindBy(xpath = ".//*[@id='id_gender2']")
	public WebElement mrsRadioButton;

	@FindBy(xpath = "//*[@id='customer_firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//*[@id='customer_lastname']")
	public WebElement lastname;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailAddress;

	@FindBy(xpath = "//*[@id='passwd']")
	public WebElement password;

	@FindBy(xpath = "//*[@id='days']")
	public WebElement days;

	@FindBy(xpath = "//*[@id='months']")
	public WebElement month;

	@FindBy(xpath = "//*[@id='years']")
	public WebElement year;

	@FindBy(xpath = "//*[@id='firstname']")
	public WebElement yourAddressFirstName;

	@FindBy(xpath = "//*[@id='lastname']")
	public WebElement yourAddressLastName;

	@FindBy(xpath = "//*[@id='company']")
	public WebElement yourAddressCompany;

	@FindBy(xpath = "//*[@id='address1']")
	public WebElement address;

	@FindBy(xpath = "//*[@id='address2']")
	public WebElement address2;

	@FindBy(xpath = "//*[@id='city']")
	public WebElement yourAddressCity;

	@FindBy(xpath = "//*[@id='id_state']")
	public WebElement yourAddressState;

	@FindBy(xpath = "//*[@id='postcode']")
	public WebElement yourAddressPostCode;

	@FindBy(xpath = "//*[@id='id_country']")
	public WebElement additionalInformation;

	@FindBy(xpath = "//*[@id='phone']")
	public WebElement homePhone;

	@FindBy(xpath = "//*[@id='phone_mobile']")
	public WebElement mobilePhone;

	@FindBy(xpath = "//*[@id='alias']")
	public WebElement addressAlias;

	@FindBy(xpath = "//*[@id='submitAccount']")
	public WebElement registration;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(mrRadioButton,ObjectReader.reader.getExplicitWait());
		Testbase.logExtentReport("RegistrationPage object created...");
		new Testbase().getNavigationScreen(driver);
	}

	public void setMrRadioButton() {
		log.info("selecting mr checkbox..");
		Testbase.logExtentReport("selecting mr checkbox..");
		this.mrRadioButton.click();
	}

	public void setMrsRadioButton() {
		log.info("selecting mrs checkbox..");
		Testbase.logExtentReport("selecting mrs checkbox..");
		this.mrsRadioButton.click();
	}

	public void setFirstName(String firstName) {
		log.info("entering firstName.." + firstName);
		Testbase.logExtentReport("entering firstName.." + firstName);
		this.firstName.sendKeys(firstName);
	}

	public void setLastname(String lastname) {
		log.info("entering lastname.." + lastname);
		Testbase.logExtentReport("entering lastname.." + lastname);
		this.lastname.sendKeys(lastname);
	}

	public void setEmailAddress(String emailAddress) {
		log.info("entering emailAddress.." + emailAddress);
		Testbase.logExtentReport("entering emailAddress.." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void setPassword(String password) {
		log.info("entering password.." + password);
		Testbase.logExtentReport("entering password.." + password);
		this.password.sendKeys(password);
	}

	public void setDay(String day) {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='days']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement c = itr.next();
			String text = c.getText().trim().toString();
			if (text.equals(day)) {
				Testbase.logExtentReport("selecting date as: "+day);
				c.click();
				break;
			}
		}
	}

	public void setMonth(String month) {

		List<WebElement> days = driver.findElements(By.xpath("//*[@id='months']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement click = itr.next();
			String text = click.getText().trim();
			if (text.equals(month)) {
				Testbase.logExtentReport("selecting month as: "+month);
				click.click();
				break;
			}
		}
	}

	public void setYear(String year) {

		List<WebElement> days = driver.findElements(By.xpath("//*[@id='years']/option"));
		Iterator<WebElement> itr = days.iterator();
		while (itr.hasNext()) {
			WebElement click = itr.next();
			String text = click.getText().trim();
			if (text.equals(year)) {
				Testbase.logExtentReport("selecting year as: "+year);
				click.click();
				break;
			}
		}
	}

	public void setYourAddressFirstName(String yourAddressFirstName) {
		log.info("entering yourAddressFirstName.." + yourAddressFirstName);
		Testbase.logExtentReport("entering yourAddressFirstName.." + yourAddressFirstName);
		this.yourAddressFirstName.sendKeys(yourAddressFirstName);
	}

	public void setYourAddressLastName(String yourAddressLastName) {
		log.info("entering yourAddressLastName.." + yourAddressLastName);
		Testbase.logExtentReport("entering yourAddressLastName.." + yourAddressLastName);
		this.yourAddressLastName.sendKeys(yourAddressLastName);
	}

	public void setYourAddressCompany(String yourAddressCompany) {
		log.info("entering yourAddressCompany.." + yourAddressCompany);
		Testbase.logExtentReport("entering yourAddressCompany.." + yourAddressCompany);
		this.yourAddressCompany.sendKeys(yourAddressCompany);
	}

	public void setAddress(String address) {
		log.info("entering address.." + address);
		Testbase.logExtentReport("entering address.." + address);
		this.address.sendKeys(address);
	}

	public void setAddress2(String address2) {
		log.info("entering address2.." + address2);
		Testbase.logExtentReport("entering address2.." + address2);
		this.address2.sendKeys(address2);
	}

	public void setYourAddressCity(String yourAddressCity) {
		log.info("entering yourAddressCity.." + yourAddressCity);
		Testbase.logExtentReport("entering yourAddressCity.." + yourAddressCity);
		this.yourAddressCity.sendKeys(yourAddressCity);
	}

	public void setYourAddressState(String yourAddressState) {
		log.info("entering yourAddressState.." + yourAddressState);
		Testbase.logExtentReport("entering yourAddressState.." + yourAddressState);
		new Select(this.yourAddressState).selectByVisibleText(yourAddressState);
	}

	public void setYourAddressPostCode(String yourAddressPostCode) {
		log.info("entering yourAddressPostCode.." + yourAddressPostCode);
		Testbase.logExtentReport("entering yourAddressPostCode.." + yourAddressPostCode);
		this.yourAddressPostCode.sendKeys(yourAddressPostCode);
	}

	public void setAdditionalInformation(String additionalInformation) {
		log.info("entering additionalInformation.." + additionalInformation);
		Testbase.logExtentReport("entering additionalInformation.." + additionalInformation);
		this.additionalInformation.sendKeys(additionalInformation);
	}

	public void setHomePhone(String homePhone) {
		log.info("entering homePhone.." + homePhone);
		Testbase.logExtentReport("entering homePhone.." + homePhone);
		this.homePhone.sendKeys(homePhone);
	}

	public void setMobilePhone(String mobilePhone) {
		log.info("entering mobilePhone.." + mobilePhone);
		Testbase.logExtentReport("entering mobilePhone.." + mobilePhone);
		this.mobilePhone.sendKeys(mobilePhone);
	}

	public void setAddressAlias(String addressAlias) {
		log.info("entering addressAlias.." + addressAlias);
		Testbase.logExtentReport("entering addressAlias.." + addressAlias);
		this.addressAlias.sendKeys(addressAlias);
	}

	public void clickRegistration() {
		log.info("clicked on registration.." + registration);
		Testbase.logExtentReport("clicked on registration.." + registration);
		this.registration.click();
	}
}
