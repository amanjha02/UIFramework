package com.UIFramwork.Hitachi.FSA.Helper.Assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log=LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void verifyText(String s1,String s2) {
		log.info("Comparing two object");
		Assert.assertEquals(s1, s2);
		
	}
	public static void makeTrue() {
		log.info("making script pass.....");
		Assert.assertTrue(true);
	}
	public static void makeTrue(String message) {
		log.info("making script pass.....");
		Assert.assertTrue(true,message);
	}
	public static void makeFalse() {
		log.info("making script fail.....");
		Assert.assertTrue(false);
	}
	public static void makeFalse(String message) {
		log.info("making script pass.....");
		Assert.assertTrue(false,message);
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
	public static void verifyNotNullObject(String  S1) {
		Assert.assertNull(S1);
	}
}
