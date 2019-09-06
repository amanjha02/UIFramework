package com.UIFramework;

import org.apache.log4j.Logger;

public class Test {
	@org.testng.annotations.Test
	public void Loggeretest() {
	Logger log=Logger.getLogger(Test.class);
	log.info("Test");
	log.error("");
	}

}
