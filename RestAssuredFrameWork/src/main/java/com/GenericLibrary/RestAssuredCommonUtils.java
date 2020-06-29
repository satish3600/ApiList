package com.GenericLibrary;

import java.util.ArrayList;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

/**
 * @author satish
 *{@code}this is useful for all common scenarios for Rest API
 *@since 2020 
 */

public class RestAssuredCommonUtils {
	
	public void validateStatusCode(Response resp,int expectedStatusCode) {
		resp.then().assertThat().statusCode(expectedStatusCode);
	    System.out.println("status code validation is successfull");
	}
	
	public void validateContentType(Response resp) {
		resp.then().assertThat().contentType(ContentType.JSON);
		System.out.println("content type validation is successfull");
	}
	
	public void validateResponseTime(Response resp,long rangeWithinTime) {
		resp.then().assertThat().time(Matchers.lessThan(rangeWithinTime));
	System.out.println("response time validation is successfull");
	}
	
	public void validateKVPair(Response resp,String jsonpath,String expectedValue) {
		Object obj = resp.jsonPath().get(jsonpath);
	String actualValue = obj.toString();
	Assert.assertEquals(actualValue,expectedValue );
	}
	
	//this is a generic method which converts arraylistObject into arraylistString
	public ArrayList<String> convertObjectList_To_StringList(ArrayList<Object> list) {
	     ArrayList<String> s = new ArrayList<String>();	
	for(Object obj : list) {
		String s1 = obj.toString();
		s.add(s1);
	}
	return s;
	}
	
	public String fetchTokenID(Response resp,String jsonPath) {
		Object objtoken = resp.jsonPath().get(jsonPath);
	return objtoken.toString();
	}
	

}
