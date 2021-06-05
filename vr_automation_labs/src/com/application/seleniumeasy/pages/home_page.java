package com.application.seleniumeasy.pages;

import java.io.IOException;

import com.application.libs.common.Reporter;
import com.application.libs.common.common_utilities;
import com.application.libs.web.VRWebElement;
import com.application.libs.web.ui_utils;

public class home_page extends VRWebElement{
	// Get Welcome Message
	public VRWebElement get_Welcome_message() {
		return new VRWebElement("xpath=//h3[contains(text(),'Welcome to Selenium Easy')]");
	}
	//Get Menu item
	public VRWebElement get_menu_item_link(String menuitem) {
		return new VRWebElement("xpath=//a[text()='" + menuitem + "']");
	}
	//Get Sub Menu
	public VRWebElement get_sub_menu_item_link(String menuName,String subMenuname) {
		return new VRWebElement("xpath=//a[text()='" + menuName + "']/parent::li/ul/li/a[text()='" + subMenuname + "']");
	}
	//get No thanks Button
	public VRWebElement get_Nothanks_button() {
		return new VRWebElement("xpath=//a[text()='No, thanks!']");
	}
	//================================== Methods ================================================
	
	public void openApplication() throws IOException {
		String env = common_utilities.get_property_value("./config/application.properties", "environment");
		String url = common_utilities.get_property_value("./resources/" + env + "/env.properties", "url");
		driver.get(url);
		//captureScreenShot();
		Reporter.update_Report_step(fwt, "Open Seleniumeasy Website", "Application should launch successfully.", "Application Launched Successfully.", "PASS");
		log.info("Application Launched Successfully.");
		//eTest.log(LogStatus.PASS, "Application Launched Successfully.");o
	}
	
	public boolean verify_selenium_easy_welcome_page() throws IOException {
		boolean result = false;
		if(get_Welcome_message().verifyPresent()){
			Reporter.update_Report_step(fwt, "Verify Seleniumeasy website Loaded", "Website should Loaded Successfully.", "Website Loaded Successfully", "PASS");
			log.info("Selenium easy Welcome page is loaded successfully.");
			//eTest.log(LogStatus.PASS, "Selenium easy Welcome page is loaded successfully.");
			result=true;
		}else {
			log.error("failed to load Selenium easy page");
			//eTest.log(LogStatus.FAIL, "failed to load Selenium easy page");
		}
		//captureScreenShot();
		return result;
	}
	
	public void expandSideMenu(String menuName) throws IOException {
		ui_utils.click_element(get_menu_item_link(menuName), menuName);
	}
	
	public void selectsideMenuItem(String menuName,String subMenuName) throws IOException {
		expandSideMenu(menuName);
		ui_utils.click_element(get_sub_menu_item_link(menuName, subMenuName), subMenuName);
		
	}
	
	public void clickNoThanks() throws IOException {
		
		if(get_Nothanks_button().verifyPresent()) {
			ui_utils.click_element(get_Nothanks_button(), "No Thanks");
		}
		
	}
	
}