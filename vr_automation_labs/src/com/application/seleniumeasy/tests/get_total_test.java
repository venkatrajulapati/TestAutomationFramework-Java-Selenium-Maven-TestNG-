package com.application.seleniumeasy.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.application.libs.common.Reporter;
import com.application.libs.web.test_base;
import com.application.seleniumeasy.pages.home_page;
import com.application.seleniumeasy.pages.simple_form_demo_page;


public class get_total_test extends test_base {
	
	public get_total_test() throws IOException {
		// TODO Auto-generated constructor stub
		initVariables("InputForms", this.getClass().getSimpleName());
	}
	
	@Test(dataProvider = "ReadTestdata")
	public void gertTotaltest(Map<String,String> data) throws IOException {
		//=============================== Test Data ===================================
		String menuName = data.get("MenuName");
		String subMenuName = data.get("SubMenuName");
		String entera = String.valueOf(data.get("a"));
		String enterb = String.valueOf(data.get("b"));
		//=============================== Initiate Report =============================
		tcName=this.getClass().getSimpleName();
		fwt=Reporter.create_html_report(tcName);
		//=============================== Initialize pages ============================
		home_page home_page  = new home_page();
		simple_form_demo_page simple_demo_form = new simple_form_demo_page();
		//=============================== Test Steps ==================================
		//Launch Application
		home_page.openApplication();
		//click on No thanks
		home_page.clickNoThanks();
		//verify page opened;	
		boolean result = home_page.verify_selenium_easy_welcome_page();
		Assert.assertEquals(result, true);
		//select simple Form Demo
		home_page.selectsideMenuItem(menuName, subMenuName);
		//Enter a and b
		simple_demo_form.enter_AandB_field_values(entera, enterb);
		//click on get total
		simple_demo_form.click_get_total_button();
		//fetch Total
		String tot = simple_demo_form.get_total_val();
		Assert.assertEquals(tot, "3");
	}
}
