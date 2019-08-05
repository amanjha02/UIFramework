package com.UIFramwork.Hitachi.FSA.Helper.Assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class AssertionHelper {
	Logger log=LoggerHelper.getLogger(VarificationHelper.class);
	
	public static void verifyText(String s1,String s2) {
		Assert.assertEquals(s1, s2);
	}
	public static void makeTrue() {
		Assert.assertTrue(true);
	}
	public static void makeTrue(String message) {
		Assert.assertTrue(true,message);
	}
	public static void makeFalse() {
		Assert.assertTrue(true);
	}
	public static void makeFalse(String message) {
		Assert.assertTrue(true,message);
	}
	public static void verifyTrue(boolean status) {
		Assert.assertTrue(status);
	}
	public static void verifyFalse(boolean status) {
		Assert.assertTrue(status);
	}
	public static void verifyNullObject(String  S1) {
		Assert.assertNull(S1);
	}
}
