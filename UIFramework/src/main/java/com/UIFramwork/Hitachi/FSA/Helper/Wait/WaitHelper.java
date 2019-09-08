package com.UIFramwork.Hitachi.FSA.Helper.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * This is implicit Wait
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit);
		log.info("implicit wait has been set to" + timeout);
	}

	/**
	 * This will be help to get webDriver wait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEverinMillisecond
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEverinMillisecond) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEverinMillisecond));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;

	}

	/**
	 * This method check element to be visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEverinMillisecond
	 */
	public void waitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEverinMillisecond) {
		log.info("wait for element " + element.toString() + "for :" + timeOutInSeconds);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEverinMillisecond);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element + "Element is visible now");
	}

	/**
	 * This method make sure element is to be clicakble
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementTobeclickable(WebElement element, int timeOutInSeconds) {
		log.info("wait for element " + element.toString() + "for clickable :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(element + "Element is clikable now");
	}

	/**
	 * This method will wait to wait for frame and switch to window
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForWebelementNotPreasent(WebElement element, long timeOutInSeconds) {
		log.info("wait for element " + element.toString() + "for preasent :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(element + "Element is invisible now");
		return status;
	}

	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("wait for element " + element.toString() + "for preasent :" + timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is availble and switch to window");

	}
	/**
	 * this method gives us fluent wait object
	 * @param timeOutInSeconds
	 * @param pollingEverinMillisecond
	 * @return
	 */
	private Wait getFluentWait(int timeOutInSeconds, int pollingEverinMillisecond) {
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEverinMillisecond)).ignoring(NoSuchElementException.class);
		return fwait;
		
	}
	
	public void pageLoadTime(long timeout,TimeUnit unit) {
		log.info("Waiting for page to load for :"+unit +"second");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page isloaded");
		
	}
	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}

}
