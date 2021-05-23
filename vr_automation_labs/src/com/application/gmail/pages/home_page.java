package com.application.gmail.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aplication.common.libs.VRWebElement;
import com.aplication.common.libs.common_utilities;

public class home_page extends VRWebElement{
	
	/*public WebElement get_email_field() {
		return driver.findElement(By.xpath("//input[@type='email']"));
	}*/
	public VRWebElement get_email_field() {
		return new VRWebElement("xpath=//input[@type='email']");
	}
	
	public VRWebElement get_signIn_lable() {
		return new VRWebElement("xpath=//span[text()='Sign in']");
	}
	
	public WebElement get_email_field1() {
		return driver.findElement(By.xpath("//input[@type='email']"));
	}
	
	//================================== Methods =====================================
	
	public void openApplication() throws IOException {
		String env = common_utilities.get_property_value("./config/application.properties", "environment");
		String url = common_utilities.get_property_value("./resources/" + env + "/env.properties", "url");
		driver.get(url);
		log.info("Application Launched Successfully.");
	}
	
	public void enter_email(String email) {
		if(get_email_field().verifyPresent()){
			get_email_field().sendKeys(email);
		}else {
			System.out.println("fail");
		}
		
	}
	
	public void enter_email1(String email) {
		if(get_email_field1().isDisplayed()){
			get_email_field1().sendKeys(email);
			log.info("Email entered as : " + email);
		}else {
			System.out.println("fail");
			log.error("failed to enter email");
		}
		
	}
	
	public boolean verify_signin_page_opened() {
		boolean result=false;
		if(get_signIn_lable().verifyPresent()) {
			System.out.println("Sign in page loaded successflly.");
			log.info("Sign in page loaded successflly.");
			result = true;
			get_signIn_lable().mouseHoverAndDoubleClick();
		}else {
			System.out.println("Failed to open signin page");
			log.error("Failed to open signin page");
		}
		return result;
	}
}
