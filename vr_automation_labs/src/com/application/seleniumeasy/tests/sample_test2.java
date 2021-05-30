package com.application.seleniumeasy.tests;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.application.libs.common.*;
import com.application.libs.web.test_base;
import com.application.seleniumeasy.pages.home_page;


public class sample_test2 extends test_base {
	
	public sample_test2() throws IOException {
		// TODO Auto-generated constructor stub
		workbookPath = "./resources/" + common_utilities.get_property_value("./config/application.properties", "environment") + "/Testdata/testdata.xls";
		datasheetName = "sample";
		keyName = "sampletest1";
		LocalDateTime dt = dateUtils.getDate(0);//LocalDateTime.now();
		String todaysDt1 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy-HHmmss");//dt.format(formatter);
		String todaysDt2 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy");//dt.format(formatter1);
		screenShotFolder = "./results/screenshots/" + todaysDt1;
		repFolder = "./results/reports/" + todaysDt2;
		confilePropertiesFile = "./config/application.properties";
		log = Logger.getLogger(keyName);
		
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void sampletest2(Map<String,String> data) throws IOException {
		tcName=sample_test2.class.getSimpleName();
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
