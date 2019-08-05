package com.UIFramwork.Hitachi.FSA.TestScript;


import org.testng.annotations.Test;

import com.UIFramwork.Hitachi.FSA.Helper.Assertion.AssertionHelper;
import com.UIFramwork.Hitachi.FSA.TestBase.Testbase;

public class Test1 extends Testbase {
@Test
public void testLogin() {
	AssertionHelper.makeTrue();
}

@Test
public void testLogin1() {
	AssertionHelper.makeFalse();;
}

@Test
public void testLogin2() {
	AssertionHelper.makeTrue();
}

@Test
public void testLogin3() {
	AssertionHelper.makeFalse();;
}

}
