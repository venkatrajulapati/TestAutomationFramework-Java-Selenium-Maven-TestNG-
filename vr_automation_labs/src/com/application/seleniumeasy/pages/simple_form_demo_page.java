package com.application.seleniumeasy.pages;

import java.io.IOException;

import com.application.libs.common.Reporter;
import com.application.libs.common.StringUtils;
import com.application.libs.web.VRWebElement;
import com.application.libs.web.ui_utils;

public class simple_form_demo_page extends VRWebElement{
	
	public VRWebElement get_enter_your_message_field() {
		return new VRWebElement("xpath=//input[@placeholder='Please enter your Message']");
	}
	
	public VRWebElement get_display_message_text() {
		return new VRWebElement("xpath=//label[contains(text(),'Your Message:')]/following-sibling::span");
	}
	
	public VRWebElement get_show_message_button() {
		return new VRWebElement("xpath=//button[text()='Show Message']");
	}
	
	public VRWebElement get_enter_a_field() {
		return new VRWebElement("xpath=//label[text()='Enter a']/following-sibling::input");
	}
	
	public VRWebElement get_enter_b_field() {
		return new VRWebElement("xpath=//label[text()='Enter b']/following-sibling::input");
	}
	
	public VRWebElement get_total_button() {
		return new VRWebElement("xpath=//button[text()='Get Total']");
	}
	
	public VRWebElement get_total_value() {
		return new VRWebElement("xpath=//label[contains(text(),'Total a')]/following-sibling::span");
	}
	//================================== Methods =====================================
	// Verify Message
	public boolean verify_message_displayed(String exp_message) throws IOException {
		boolean result = false;
		String act_message="";
		if(get_display_message_text().verifyPresent()){
			act_message = get_display_message_text().getText().trim();
			if(StringUtils.equals(exp_message, act_message)) {
				Reporter.update_Report_step(fwt, "Verify displayed message", "Message should be displayed as : " + exp_message, "Message is displayed : " + act_message, "PASS");
				log.info("Dispaly message verification passed");
				result=true;
			}else {
				Reporter.update_Report_step(fwt, "Verify displayed message", "Message should be displayed as : " + exp_message, "Message is displayed : " + act_message, "FAIL");
				log.error("Dispaly message verification failed");
				
			}
			
		}else {
			Reporter.update_Report_step(fwt, "Verify displayed message", "Message should be displayed as : " + exp_message, "Message is not displayed.", "FAIL");
			log.error("failed to display Message");
			//eTest.log(LogStatus.FAIL, "failed to load Selenium easy page");
		}
		return result;
	}
	
	// Enter Message
	public void enterMessage(String message) throws IOException {
		ui_utils.set_edit_field_value(get_enter_your_message_field(), "Enter your message Field", message);
	}
	
	//click on Show Message
	public void clickShowMessage() throws IOException {
		ui_utils.click_element(get_show_message_button(), "Show Message button");
	}
	
	//Enter a 
	public void enterA(String a) throws IOException {
		ui_utils.set_edit_field_value(get_enter_a_field(), "Enter a", a);
	}
	
	//Enter b 
	public void enterB(String b) throws IOException {
		ui_utils.set_edit_field_value(get_enter_b_field(), "Enter b", b);
	}
	
	//click on Get total
	public void click_get_total_button() throws IOException {
		ui_utils.click_element(get_total_button(), "Get Total button");
	}
	
	//Enter A and B
	public void enter_AandB_field_values(String a,String b) throws IOException {
		if(!StringUtils.isNullOrEmpty(a)) {
			enterA(a);
		}
		if(!StringUtils.isNullOrEmpty(b)) {
			enterB(b);
		}
	}
	
	// Get Total Value
	public String get_total_val() {
		return get_total_value().getText().trim();
	}
	
	// Verify Total
	public boolean verify_Total_displayed(String exp_total) throws IOException {
		boolean result = false;
		String act_total="";
		if(get_total_value().verifyPresent()){
			act_total = get_total_val();
			if(StringUtils.equals(exp_total, act_total)) {
				Reporter.update_Report_step(fwt, "Verify Total", "Total should be displayed as : " + exp_total, "Total is displayed : " + act_total, "PASS");
				log.info("Total verification passed");
				result=true;
			}else {
				Reporter.update_Report_step(fwt, "Verify Total", "Total should be displayed as : " + exp_total, "Total is displayed : " + act_total, "FAIL");
				log.error("Total verification failed");
			}
			
		}else {
			Reporter.update_Report_step(fwt, "Verify Total", "Total should be displayed as : " + exp_total, "Total is not displayed.", "FAIL");
			log.error("failed to display Total");
			//eTest.log(LogStatus.FAIL, "failed to load Selenium easy page");
		}
		return result;
	}
	
	
}