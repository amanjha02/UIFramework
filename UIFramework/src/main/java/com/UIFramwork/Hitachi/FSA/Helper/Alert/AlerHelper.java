package com.UIFramwork.Hitachi.FSA.Helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.UIFramwork.Hitachi.FSA.Helper.Assertion.VarificationHelper;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class AlerHelper {
private WebDriver driver;
	
	Logger log=LoggerHelper.getLogger(AlerHelper.class);
	
	public void AlerHelper(WebDriver driver) {		
		this.driver=driver;		
		log.info("AlerHelper object created");
	}
	
	public Alert getAlert() {
		log.info("alert test"+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		getAlert().accept();
		log.info("Accept Alert is done");
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
		log.info("Dismiss Alert is done");
	}
	
	public String getAlertText() {
		String text=getAlert().getText();
		log.info("Text has been capture");
		return text;
		
	}
	
	public boolean isAlertpreasent() {
		try {
			driver.switchTo().alert();
			log.info("Alert is preasent");
			return true;
		}catch(NoAlertPresentException e) {
			log.info("Alert noyt preasent "+e.getCause());
			return false;
		}
	}
	
	public void acceptAlertifpreasent() {
		if(isAlertpreasent()) {
			acceptAlert();
		}
			else {
				log.info("alert is not preasent");
			}
		}
	
	public void DismissAlertifpreasent() {
		if(isAlertpreasent()) {
			dismissAlert();
		}
			else {
				log.info("alert is not preasent");
			}
		}
	
	public void acceptPrompt(String text) {
		if(isAlertpreasent()) {
			Alert alert=getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text"+text);
		}
		
	}
	}

