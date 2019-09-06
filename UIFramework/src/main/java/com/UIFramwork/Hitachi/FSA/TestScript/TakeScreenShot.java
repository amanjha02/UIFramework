package com.UIFramwork.Hitachi.FSA.TestScript;

import org.testng.annotations.Test;

import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;

public class TakeScreenShot  extends Testbase{
@Test
public void TakeScreen() {
	driver.get("https://www.google.com/");
	captureScreen("FirstScreen", driver);
}
}
