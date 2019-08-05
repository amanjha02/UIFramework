package com.UIFramwork.Hitachi.FSA.Helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class FrameHelperClass {
	private WebDriver driver;

	 Logger log=LoggerHelper.getLogger(FrameHelperClass.class);
	 
	 public void FrameHelerClass(WebDriver driver) {
		 this.driver=driver;
	 }
	/**
	 * Switch to frame using index 
	 * @param index
	 */
	 public void switchToFrameByIndex(int index) {
		 log.info("Switching to frame using frame index");
		 driver.switchTo().frame(index);
	 }
	 /**
	  * Switch to frame using FrameName 
	  * @param Name
	  */
	 public void switchToFrameByName(String Name) {
		 log.info("Switching to frame using frame Name");
		 driver.switchTo().frame(Name);
	 }
	 /**
	  * Switch to frame using Webelement 
	  * @param Name
	  */
	 public void switchToFrameByWebElement(WebElement element) {
		 log.info("Switching to frame using frame Element");
		 driver.switchTo().frame(element);
	 }
}
