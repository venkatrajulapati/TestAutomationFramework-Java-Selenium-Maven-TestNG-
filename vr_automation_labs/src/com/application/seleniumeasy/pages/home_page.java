package com.application.seleniumeasy.pages;

import java.io.IOException;

import org.testng.ITestContext;

import com.aplication.common.libs.*;
import com.aplication.web.libs.VRWebElement;
import com.aplication.web.libs.ui_utils;

public class home_page extends VRWebElement{

	public VRWebElement get_Welcome_message() {
		return new VRWebElement("xpath=//h3[contains(text(),'Welcome to Selenium Easy')]");
	}
	
	public VRWebElement get_menu_item_link(String menuitem) {
		return new VRWebElement("xpath=//a[text()='" + menuitem + "']");
	}
	
	public VRWebElement get_Nothanks_button() {
		return new VRWebElement("xpath=//a[text()='No, thanks!']");
	}
	//================================== Methods =====================================
	
	public void openApplication() throws IOException {
		String env = common_utilities.get_property_value("./config/application.properties", "environment");
		String url = common_utilities.get_property_value("./resources/" + env + "/env.properties", "url");
		driver.get(url);
		captureScreenShot();
		log.info("Application Launched Successfully.");
	}
	
	public boolean verify_selenium_easy_welcome_page() {
		boolean result = false;
		if(get_Welcome_message().verifyPresent()){
			log.info("Selenium easy Welcome page is loaded successfully.");
			result=true;
		}else {
			log.error("failed to load Selenium easy page");
		}
		captureScreenShot();
		return result;
	}
	
	public void selectMenu(String menuName) {
		ui_utils.click_element(get_menu_item_link(menuName), menuName);
		captureScreenShot();
	}
	
	public void clickNoThanks() {
		if(get_Nothanks_button().verifyPresent()) {
			ui_utils.click_element(get_Nothanks_button(), "No Thanks");
			captureScreenShot();
		}
		
	}
	
}