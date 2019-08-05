package com.UIFramwork.Hitachi.FSA.Helper.Resource;

public class resourceHelper {
	
	public static String getResourcePath(String path) {
		String basepath=System.getProperty("user.dir");
			
	return  basepath+path;
	}
	

}
