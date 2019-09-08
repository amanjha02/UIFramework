package com.UIFramwork.Hitachi.FSA.Helper.JavaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;


public class JavaScriptHelper {
	private WebDriver driver;
	
	Logger log=LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public  JavaScriptHelper(WebDriver driver) {		
		this.driver=driver;		
		log.info("Javascript driver initiated");
	}
	/**
	 * Execute the javascriptusing jsscript
	 * @param Script
	 * @return
	 */
	public Object executeScript(String Script) {
		JavascriptExecutor exe= (JavascriptExecutor)driver;
		return exe.executeScript(Script);
	}
	/**
	 * Execute the javascriptusing jsscript and argument
	 * @param Script
	 * @param args
	 * @return
	 */
	public Object executeScript(String Script,Object...args) {
		JavascriptExecutor exe= (JavascriptExecutor)driver;
		return exe.executeScript(Script,args);
	}
	/**
	 * this will scroll the element based on location
	 * @param element
	 */
	public void scrolToElement(WebElement element) {
		log.info("Scrool to Webelement");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	/**
	 * this will scrolling element and clicking that one
	 * @param element
	 */
	public void srollToElementAndClick(WebElement element) {
		scrolToElement(element);
		element.click();
		log.info("elemet to clicked"+element.toString());
	}
	/**
	 * this will scrolling untill view
	 * @param element
	 */
	public void scrollToElementTillView(WebElement element) {
		log.info("scrool in to window till view");
		executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * this will scrolling untill view and click
	 * @param element
	 */
	public void scrollToElementTillViewAndClick(WebElement element) {
		scrollToElementTillView(element);
		element.click();
		log.info("elemet to clicked"+element.toString());
	}
	/**
	 * scrolling down vertically
	 */
	public void scrollDownVertically() {
		log.info("scrolly down vrtically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/**
	 * scrolling down vertically
	 */
	public void scrollUpVertically() {
		log.info("scrolly up vrtically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	/**
	 * scrooling down by pixel
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBy(0,"+pixel+")");
	}
	/**
	 * scrooling up by pixel
	 * @param pixel
	 */
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBy(0,-"+pixel+")");
	}
	/**
	 * zooming 100%
	 */
	public void zoomInBy100percent() {
		executeScript("document.body.style.zoom='100%'");
	}
	/**
	 * Zooming 60 %
	 */
	public void zoomInBy60percent( ) {
		executeScript("document.body.style.zoom='60%'");
	}
	/**
	 * clicking the element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		executeScript("argument[0].click();",element);
	}
	public void scrollIntoView(WebElement element){
		log.info("scroll till web element");
		executeScript("arguments[0].scrollIntoView()",element);
	}
}
