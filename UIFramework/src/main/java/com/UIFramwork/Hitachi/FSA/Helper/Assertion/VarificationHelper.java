package com.UIFramwork.Hitachi.FSA.Helper.Assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class VarificationHelper {
private WebDriver driver;
	
	Logger log=LoggerHelper.getLogger(VarificationHelper.class);
	
	public void VarificationHelper(WebDriver driver) {		
		this.driver=driver;		
		log.info("VarificationHelper driver initiated");
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is preasent:-"+element.getText());
			return true;
		}
		catch(Exception e) {
			log.error("element is not  preasent:-"+e.getCause());
			return false;
		}	
	}
	
	public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is preasent:-"+element.getText());
			return false;
		}
		catch(Exception e) {
			log.error("element is not  preasent:-");
			return true;
		}	
	}
	
	public String getText(WebElement element) {
		if(null==element) {
			log.info("webelement not preasent");
			return null;
		}
		boolean Status = isDisplayed(element);
		if(Status) {
			log.info("element is displayed"+element.getText());
			return element.getText();
		}
		else {
			log.info("element is not displayed");
			return null;
		}
		
	}
}
