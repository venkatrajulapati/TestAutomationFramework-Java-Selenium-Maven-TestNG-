package com.application.gmail.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.aplication.common.libs.common_utilities;
import com.aplication.common.libs.test_base;
import com.application.gmail.pages.home_page;


public class test_gmail_login extends test_base {
	
	public test_gmail_login() throws IOException {
		// TODO Auto-generated constructor stub
		workbookPath = "./resources/" + common_utilities.get_property_value("./config/application.properties", "environment") + "/Testdata/testdata.xls";
		datasheetName = "Login";
		keyName = "login";
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void login(Map<String,String> data) throws IOException {
		
		
		home_page home_page  = new home_page();
		//Launch Application
		home_page.openApplication();
		//verify page opened;	
		boolean result = home_page.verify_signin_page_opened();
		assertEquals(result, true);
		home_page.enter_email1(data.get("Email"));
		
		
		
		
	}
}
