package com.UIFramwork.Hitachi.FSA.Helper.Window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public void WindowHelper(WebDriver driver) {
		this.driver = driver;
	}
/**
 * This method will move to parent window
 */
	public void switchToParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}
/**
 * This method will move to child window 
 * @param index
 */
	public void switchToWindow(int index) {
		log.info("Switching to parent window");
		Set<String> windows = driver.getWindowHandles();
		int i = 0;
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
		log.info("Switched to parend window ");
			}
			i++;
		}
	}
/**
 * This method will close all window except main window
 */
	public void closeAllTabsAndSwitchToMainWindow() {
		log.info("closing all tab Except main window");
		Set<String> windows = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for (String window : windows) {
			if (!window.equalsIgnoreCase(parentWindow)) {
				driver.close();
			}
        log.info("All tab closed Except main window");
		}
		log.info("Switching to main Window");
		driver.switchTo().window(parentWindow);
	}
/**
 * This method will do navigation back command
 */
	public void navigateBack() {
		log.info("Back to previous window");
      driver.navigate().back();
      
	}
/**
 * This will do navigation forward command
 */
	public void navigateForward() {
		log.info("Navigate to forward window");
		driver.navigate().forward();
	}
}