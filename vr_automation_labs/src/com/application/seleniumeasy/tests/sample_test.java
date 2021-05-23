package com.application.seleniumeasy.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.aplication.common.libs.common_utilities;
import com.aplication.common.libs.test_base;
import com.application.seleniumeasy.pages.home_page;


public class sample_test extends test_base {
	
	public sample_test() throws IOException {
		// TODO Auto-generated constructor stub
		workbookPath = "./resources/" + common_utilities.get_property_value("./config/application.properties", "environment") + "/Testdata/testdata.xls";
		datasheetName = "sample";
		keyName = "sampletest";
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void sampletest(Map<String,String> data) throws IOException {
		//Test data
		String menuName = data.get("MenuName");
		// Test steps
		home_page home_page  = new home_page();
		//Launch Application
		home_page.openApplication();
		home_page.clickNoThanks();
		//verify page opened;	
		boolean result = home_page.verify_selenium_easy_welcome_page();
		assertEquals(result, true);
		home_page.selectMenu(menuName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
