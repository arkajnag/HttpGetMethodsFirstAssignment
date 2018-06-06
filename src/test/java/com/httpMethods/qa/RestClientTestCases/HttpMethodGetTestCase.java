package com.httpMethods.qa.RestClientTestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.httpMethods.qa.RestClients.HttpMethodGet;
import com.httpMethods.qa.TestBase.TestBase;

public class HttpMethodGetTestCase extends TestBase{

	String HostURL,ServiceURL,GetMethodURI;
	HttpMethodGet httpGet;
	
	public HttpMethodGetTestCase() {
		super();
	}
	@BeforeMethod
	public void SetUp()
	{
		HostURL= prop.getProperty("HostURL");
		ServiceURL=prop.getProperty("ServiceURL");
		GetMethodURI=HostURL+ServiceURL;
	}
	@Test
	public void GetMethodCallTestCase()
	{
		httpGet=new HttpMethodGet();
		httpGet.GetMethodCall(GetMethodURI);
	}
}
