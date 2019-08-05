package com.UIFramwork.Hitachi.FSA.Helper.Select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class DropDownHelper {
	private WebDriver driver;
	Logger log=LoggerHelper.getLogger(DropDownHelper.class);
	
	public void DropDownHelper(WebDriver driver) {
		this.driver=driver;
		log.info("DropDownHelper object created");
	}
  public void selectByValue(String value,WebElement element) {
	  Select select=new Select(element);
	  select.selectByValue(value);
  }
  public void selectByIndex(int index,WebElement element) {
	  Select select=new Select(element);
	  select.selectByIndex(index);
  }
  public void selectByVisibleText(WebElement element,String text ) {
	  Select select=new Select(element);
	  select.selectByVisibleText(text);
  }
  
  public void deselectByValue(String value,WebElement element) {
	  Select deselect=new Select(element);
	  deselect.selectByValue(value);
  }
  public void deselectByIndex(int index,WebElement element) {
	  Select deselect=new Select(element);
	  deselect.selectByIndex(index);
  }
  public void deselectByVisibleText(WebElement element,String text ) {
	  Select deselect=new Select(element);
	  deselect.selectByVisibleText(text);
  }
  
  public List<String> getAlllistFromDropDown(WebElement element) {
	  Select select=new Select(element);
	  List <WebElement> elemnetList=select.getOptions();
	  List< String> Valuelist=new LinkedList<String>();
	  for (WebElement ele : elemnetList) {
	log.info("Dropdown value is "+ele.getText());
	Valuelist.add(ele.getText());
	
	}
	return Valuelist;
	  
  }
}
