package com.Script.Library;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass;

import io.restassured.response.Response;

public class UpdatePartiallyTest extends BaseClass {
	@Test
	public void ceckPartialUpdate() throws IOException {
		
	String propertyFileData = config.propertyFile("updateDataPartially");
	Response resp = config.executeRequest(propertyFileData);
	resp.then().log().all();
	}
	
}
