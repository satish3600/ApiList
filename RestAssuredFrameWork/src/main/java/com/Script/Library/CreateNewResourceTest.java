package com.Script.Library;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass;

import io.restassured.response.Response;
/**
 * @author satish
 * {@code} This class is to post request through framework
 *
 */
public class CreateNewResourceTest extends BaseClass {


	/**
	 * {@code} this method is to
	 * @throws IOException 
	 *
	 */
	
	@Test
	public void checkCreateNewResource() throws IOException
	{
		
	String propertyFileData = config.propertyFile("createPost");
	Response resp = config.executeRequest(propertyFileData);
	resp.then().log().all();
	
	}

	
}
