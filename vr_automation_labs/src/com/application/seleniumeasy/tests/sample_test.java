package com.application.seleniumeasy.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.application.libs.common.Reporter;
import com.application.libs.web.test_base;
import com.application.seleniumeasy.pages.home_page;


public class sample_test extends test_base {
	
	public sample_test() throws IOException {
		initVariables("sample", this.getClass().getSimpleName());
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void sampletest(Map<String,String> data) throws IOException {
		//Initiate Report
		tcName=this.getClass().getSimpleName();
		fwt=Reporter.create_html_report(tcName);
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
	}
}
