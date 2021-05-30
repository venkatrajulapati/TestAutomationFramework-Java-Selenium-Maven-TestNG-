package com.application.libs.web;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class extentdemo extends test_base {
	@Test
	public void testone() {
		ExtentReports reports = new ExtentReports("./results/extent.html", true);
		
		ExtentTest test1 = reports.startTest("sample");
		
		test1.log(LogStatus.INFO, "Starting test");
		
		driver.get("https://www.google.com/");
		
		test1.log(LogStatus.PASS, "Google launched successfully.");
		
		test1.log(LogStatus.FAIL, "making fail");
		
		
		reports.endTest(test1);
		
		reports.flush();
	}

}
