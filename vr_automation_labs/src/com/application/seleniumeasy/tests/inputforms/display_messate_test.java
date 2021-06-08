package com.application.seleniumeasy.tests.inputforms;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.application.libs.common.Reporter;
import com.application.libs.web.test_base;
import com.application.seleniumeasy.pages.home_page;
import com.application.seleniumeasy.pages.simple_form_demo_page;


public class display_messate_test extends test_base {
	
	public display_messate_test() throws IOException {
		// TODO Auto-generated constructor stub
		initVariables("InputForms", this.getClass().getSimpleName());
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void displayMessageTest(Map<String,String> data) throws IOException {
		//=============================== Test Data ===================================
		String menuName = data.get("MenuName");
		String subMenuName = data.get("SubMenuName");
		String expMessage = data.get("Message");
		//=============================== Initiate Report =============================
		tcName=this.getClass().getSimpleName();
		fwt=Reporter.create_html_report(tcName);
		//=============================== Initialize pages ============================
		home_page home_page  = new home_page();
		simple_form_demo_page simple_demo_form = new simple_form_demo_page();
		//=============================== Test Steps ==================================
		//Launch Application
		home_page.openApplication();
		//click on Nothanks
		home_page.clickNoThanks();
		//verify page opened;	
		boolean result = home_page.verify_selenium_easy_welcome_page();
		Assert.assertEquals(result, true);
		//click on Simple Form Demo
		home_page.selectsideMenuItem(menuName, subMenuName);
		//Enter message
		simple_demo_form.enterMessage(expMessage);
		//click on Show Message
		simple_demo_form.clickShowMessage();
		//Verify Message
		boolean res = simple_demo_form.verify_message_displayed(expMessage);
		Assert.assertEquals(res, true);
		
		//common_utilities.merge_reports();
	}
}
