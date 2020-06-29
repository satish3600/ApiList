package com.Script.Library;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass;

import io.restassured.response.Response;
/**
 * @author satish
 * {@code} this class is to get request through framework
 *
 */
public class FetchAllPostsTest extends BaseClass {


	/**
	 * {@code} this method is use to
	 *
	 */
	
	@Test
	public void checkAllPosts() throws IOException {
	
		String propertyFileData = config.propertyFile("fetchAllposts");
		Response resp = config.executeRequest(propertyFileData);
        resp.then().log().all();
    }
}
