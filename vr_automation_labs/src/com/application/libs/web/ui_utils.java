package com.application.libs.web;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.application.libs.common.Reporter;
import com.application.libs.common.StringUtils;

public class ui_utils extends test_base {
	
	//Set edit Field value
	public static void set_edit_field_value(VRWebElement elemnent, String elemname, String val) throws IOException {
		if(elemnent.verifyPresent()) {
			elemnent.sendKeys(val);
			Reporter.update_Report_step(fwt, "Enter " + elemname + " field value", elemname + " field value should be entered as : " + val, elemname + " field value is entered as : " + val, "PASS");
			log.info(elemname + " field value entered as : " + val);
		}else {
			Reporter.update_Report_step(fwt, "Enter " + elemname + " field value", elemname + " field value should be entered as : " + val, "Failed to locate " + elemname + " field", "FAIL");
			log.error("Failedto Locate the element : " + elemname);
		}
		
	}
	
	//select dropdown field
	public static void select_drop_down_item(VRWebElement element, String elemName, String dropdownitem) throws IOException {
		if(element.verifyPresent()) {
			element.sel_dropdown_item_by_visible_text(dropdownitem);
			Reporter.update_Report_step(fwt, "Select the " + elemName + " dropdown item as : " + dropdownitem, elemName + " dropdown should be selected as : " + dropdownitem, elemName + " dropdown is selected successfully as : " + dropdownitem, "PASS");
			log.info(elemName + " dropdwon item selected as : " + dropdownitem );
		}else {
			log.error("Failed to Locate element : " + elemName);
			Reporter.update_Report_step(fwt, "Select the " + elemName + " dropdown item as : " + dropdownitem , elemName + " dropdown should be selected as : " + dropdownitem, "Failed to Locate " + elemName + " dropdown", "FAIL");
		}
	}
	
	//select Check box
	public static void edit_check_box(VRWebElement element, String elemName, String onORoff) throws IOException {
		
		if(element.verifyPresent()) {
			if(StringUtils.equals(onORoff, "ON")) {
				if(element.isSelected()) {
					Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", elemName + " checkbox is selected successfully.", "PASS");
					log.info(elemName + " checkbox is already selected.");
				}else {
					element.click();
					log.info(elemName + " checkbox is selected.");
					Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", elemName + " checkbox is already selected.", "PASS");
				}
			}else if(StringUtils.equals(onORoff, "OFF")) {
				if(element.isSelected()) {
					element.click();
					Reporter.update_Report_step(fwt, "Deselect the " + elemName + " checkbox", elemName + " checkbox should be deselected.", elemName + " checkbox is deselected successfully.", "PASS");
					log.info(elemName + " checkbox is unselected.");
					
				}else {
					Reporter.update_Report_step(fwt, "Deselect the " + elemName + " checkbox", elemName + " checkbox should be deselected.", elemName + " checkbox is already deselected.", "PASS");
					log.info(elemName + " checkbox is already unselected.");
				}
			}
		}else {
			log.error("Failed to locate the element : " + elemName);
			Reporter.update_Report_step(fwt, "Select the " + elemName + " checkbox", elemName + " checkbox should be selected.", "Failed to Locate " + elemName + " checkbox.", "FAIL");
		}
		
	}
	
	//click element
	public static void click_element(VRWebElement element, String elemName) throws IOException {
		if(element.verifyPresent() && element.isEnabled()) {
			element.scrollToElement();
			element.click();
			Reporter.update_Report_step(fwt, "Click on " + elemName, elemName + " should be clicked.", elemName + " clicked successfully.", "PASS");
			log.info("clicked on element : " + elemName);
		}else {
			log.error("Failed to locate the element : " + elemName);
			Reporter.update_Report_step(fwt, "Click on " + elemName, elemName + " should be clicked.", "Failed to to Locate " + elemName , "FAIL");
		}
	}
	
	//Handle Alert
	public static boolean verifyAndHandleAlert(String expAlertMsg) throws IOException {
		boolean result=false;
		String actAlertMsg="";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		actAlertMsg=alert.getText();
		if(!StringUtils.isNullOrEmpty(expAlertMsg)) {
			if(StringUtils.equals(expAlertMsg, actAlertMsg)) {
				Reporter.update_Report_step(null, "verify Alert message", "Alert Message  should displayed as : " + expAlertMsg, "Alert Message is displayed as expected : " + expAlertMsg, "INFO");
				result = true;
			}else {
				Reporter.update_Report_step(null, "verify Alert message", "Alert Message  should displayed as : " + expAlertMsg, "Alert Message is not displayed as expected : " + expAlertMsg, "WARN");
			}
		}
		
		alert.accept();
		assertEquals(result, true); 
		return result;
		
		
	}
	
}
