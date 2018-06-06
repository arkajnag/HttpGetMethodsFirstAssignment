package com.httpMethods.qa.TestBase;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/arka/Documents/workspace/HttpMethods/src/main/java/com/httpMethods/qa/Config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
