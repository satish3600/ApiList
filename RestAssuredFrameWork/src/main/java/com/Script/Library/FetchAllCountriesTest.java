package com.Script.Library;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass;

import io.restassured.response.Response;

public class FetchAllCountriesTest extends BaseClass {

	@Test
	public void checkAllCountry() throws IOException {
           		String propertyFileData = config.propertyFile("fetchAllCountries");
           		Response resp = config.executeRequest(propertyFileData);
           		resp.then().log().all();
	}
}
