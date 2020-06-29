package com.Script.Library;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass;

import io.restassured.response.Response;

public class AddBulkDataByFW extends BaseClass {
	
	@Test
	public void checkBulkDatsByFW() throws Exception {
		String propertyFileData = config.propertyFile("addBulkData");
	Response resp = config.executeBulkPostRequest(propertyFileData);
	
	rutil.validateStatusCode(resp, 201);
	rutil.validateContentType(resp);
	resp.then().log().all();
	}

}
