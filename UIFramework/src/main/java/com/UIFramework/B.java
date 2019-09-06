package com.UIFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class B {
	@Test
	public void Test1() {
		int i=1;
		if(i==2) {
			Assert.assertTrue(true);
		}
		i++;
		Assert.assertFalse(false);
	}
}
