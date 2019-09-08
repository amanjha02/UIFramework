package com.UIFramwork.Hitachi.FSA.Helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.UIFramwork.Hitachi.FSA.Helper.Resource.resourceHelper;

public class LoggerHelper {
	
	private static boolean root=false;
	
	public static Logger getLogger(Class cls) {
		if(root) {
			return Logger.getLogger(cls);
		}
		
		PropertyConfigurator.configure(resourceHelper.getResourcePath("\\src\\main\\Resources\\Configfile\\log4j.properties"));
		root =true;
		return Logger.getLogger(cls);
		}
	
	public static void main(String[] args) {
		Logger log=LoggerHelper.getLogger(LoggerHelper.class);
		log.info("Logger is configured");
	}

}
