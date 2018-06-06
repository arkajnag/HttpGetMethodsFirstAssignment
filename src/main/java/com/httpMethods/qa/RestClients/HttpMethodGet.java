package com.httpMethods.qa.RestClients;

import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import com.httpMethods.qa.TestBase.TestBase;

public class HttpMethodGet extends TestBase{
	
	public void GetMethodCall(String URI)
	{
		/****Step1: Creating a dummy Client with a Return class object of CloseableHttpClient.****/
		CloseableHttpClient closableHttpConnection= HttpClients.createDefault();
		/****Step2: Getting the URI details using HttpGet class and creating it's object reference.****/
		HttpGet httpGetMethod= new HttpGet(URI);
		try {
			/****Step3: Executing the HttpMethod GET using execute method and returning CloseableHttpResponse object reference.****/
			CloseableHttpResponse httpClientResponse= closableHttpConnection.execute(httpGetMethod);
			
			/****Step4: Fetching the Status Code from Response using getStatusLine and getStatusCode methods.****/
			int httpResponseStatusCode= httpClientResponse.getStatusLine().getStatusCode();
			System.out.println("Response Status Code::"+httpResponseStatusCode);
			
			/****Step5: Fetching the entire Response Body using EntityUtils class, toString() and getEntity methods from Response.****/
			String httpResponseString= EntityUtils.toString(httpClientResponse.getEntity(),"UTF-8");
			System.out.println("Response String from the Server:"+httpResponseString);
			
			/****Step6: Using JSONObject, the String Response from EntityUtils is Parsed to Application/JSON****/
			JSONObject JsonObject= new JSONObject(httpResponseString);
			System.out.println("Parsed Response JSON from the Server:"+JsonObject);
			
			/****Step7: Fetching Header Information from Response using getAllHeaders method.****/
			Header[] httpResponseHeader= httpClientResponse.getAllHeaders();
			
			/****Step8: Using HashMap<String, String> on getAllHeaders object reference, segregate the <Key>,<Value>.****/
			HashMap<String, String> httpHeaderDetails=new HashMap<String, String>();
			for (Header headerArray : httpResponseHeader)
			{
				httpHeaderDetails.put(headerArray.getName(), headerArray.getValue());
			}
			System.out.println("Response Header Information from the Server::"+httpHeaderDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
