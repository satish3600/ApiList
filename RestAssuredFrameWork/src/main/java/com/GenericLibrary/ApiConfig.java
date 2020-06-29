package com.GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiConfig {
	
	private String [] keyValuePairArray;
	public String propertyFile(String apiTestName) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/ApiList.properties");
		Properties pobj = new Properties();
	    pobj.load(fis);
	    String apiData = pobj.getProperty(apiTestName);
	    return apiData;
	}
	
	public Response executeRequest(String apiData)
	{
		Response resp=null;
		String[] apiDataArray = apiData.split(";");
	if(apiDataArray[0].equals("get")) 
	{
	 resp = given().queryParam("userID", "5").when().get(apiDataArray[1] );
	}
	else if(apiDataArray[0].equals("post")) 
	{
		String jsonObj = createJsonObject(apiDataArray[2]);
		 resp = given().body(jsonObj).contentType(ContentType.JSON).when().post(apiDataArray[1]);
	}
	else if(apiDataArray[0].equals("put")) 
	{
		String jsonObj = createJsonObject(apiDataArray[2]);
		 resp = given().body(jsonObj).contentType(ContentType.JSON).when().put(apiDataArray[1]);

	}
	else if(apiDataArray[0].equals("patch")) 
	{
		String jsonObj = createJsonObject(apiDataArray[2]);
		 resp = given().body(jsonObj).contentType(ContentType.JSON).when().patch(apiDataArray[1]);

	}
	else if(apiDataArray[0].equals("delete")) 
	{
		 resp = given().when().delete(apiDataArray[1]);
	}
     return resp;	

}
	/**
	 * {@code} this method is to add or update json data in post,put,patch.
	 *
	 */
	
	private String createJsonObject(String jsonData) 
	{
	     JSONObject jobj = new JSONObject();	
	String[] jsonDataArray = jsonData.split(",");
	for(int i=0;i<jsonDataArray.length;i++)
	{
		keyValuePairArray = jsonDataArray[i].split(":");
		jobj.put(keyValuePairArray[0], keyValuePairArray[1]);
	}
	return jobj.toJSONString();
	}
	
	
	public Response executeBulkPostRequest(String apiData) throws Exception {
		String[] arrData = apiData.split(";");
		
	if(arrData[0].equals("post")) 
	{
		File f = new File(arrData[2]);
	FileInputStream fis=new FileInputStream(f);
	String jsonData = IOUtils.toString(fis,"UTF-8");
	
	Response resp = given().body(jsonData).contentType(ContentType.JSON).when()
	 .post(arrData[1]);
	 return resp;
	}else {
		throw new RuntimeException("Invalid HTTP Metod for bulk data Posting");
	}
	
	}
}
