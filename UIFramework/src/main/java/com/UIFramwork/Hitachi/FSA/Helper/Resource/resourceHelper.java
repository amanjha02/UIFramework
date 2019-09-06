package com.UIFramwork.Hitachi.FSA.Helper.Resource;

import org.testng.annotations.Test;

public class resourceHelper {
	
	public static String getResourcePath(String path) {
		String basepath=System.getProperty("user.dir");
			
	return  basepath+path;
	}
	

}
