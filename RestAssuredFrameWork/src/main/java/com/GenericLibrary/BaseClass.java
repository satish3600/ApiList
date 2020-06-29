package com.GenericLibrary;

public class BaseClass {
	
    public  ApiConfig config=  new	ApiConfig(); 
   public RestAssuredCommonUtils rutil= new RestAssuredCommonUtils();
//    @BeforeSuite
//    public void configBeforeSuite() {
//  	  baseURI="https://restcountries.eu/";
//  	  basePath="rest/v2/";
//   //https://restcountries.eu/rest/v2/all this will automatically concat and get
//  // stored in restassured(bez testng starts from before suite )
//    }


}
