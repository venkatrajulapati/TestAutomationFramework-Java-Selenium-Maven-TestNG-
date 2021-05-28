package com.application.seleniumeasy.pages;

import java.io.IOException;
import com.application.libs.common.Reporter;
import com.application.libs.common.common_utilities;
import com.application.libs.web.VRWebElement;
import com.application.libs.web.ui_utils;

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
		//captureScreenShot();
		Reporter.update_Report_step(fwt, "Open Seleniumeasy Website", "Application should launch successfully.", "Application Launched Successfully.", "PASS");
		log.info("Application Launched Successfully.");
	}
	
	public boolean verify_selenium_easy_welcome_page() throws IOException {
		boolean result = false;
		if(get_Welcome_message().verifyPresent()){
			Reporter.update_Report_step(fwt, "Verify Seleniumeasy website Loaded", "Website should Loaded Successfully.", "Website Loaded Successfully", "PASS");
			log.info("Selenium easy Welcome page is loaded successfully.");
			result=true;
		}else {
			log.error("failed to load Selenium easy page");
		}
		//captureScreenShot();
		return result;
	}
	
	public void selectMenu(String menuName) throws IOException {
		ui_utils.click_element(get_menu_item_link(menuName), menuName);
		
	}
	
	public void clickNoThanks() throws IOException {
		
		if(get_Nothanks_button().verifyPresent()) {
			ui_utils.click_element(get_Nothanks_button(), "No Thanks");
			
		}
		
	}
	
}