package com.aplication.web.libs;

import com.aplication.common.libs.StringUtils;

public class ui_utils extends test_base {
	
	//Set edit Field value
	public static void set_edit_field_value(VRWebElement elemnent, String elemname, String val) {
		if(elemnent.verifyPresent()) {
			elemnent.sendKeys(val);
			log.info(elemname + " field value entered as : " + val);
		}else {
			log.error("Failedto Locate the element : " + elemname);
		}
		
	}
	
	//select dropdown field
	public static void select_drop_down_item(VRWebElement element, String elemName, String dropdownitem) {
		if(element.verifyPresent()) {
			element.sel_dropdown_item_by_visible_text(dropdownitem);
			log.info(elemName + " dropdwon item selected as : " + dropdownitem );
		}else {
			log.error("Failed to Locate element : " + elemName);
		}
	}
	
	//select Check box
	public static void edit_check_box(VRWebElement element, String elemName, String onORoff) {
		
		if(element.verifyPresent()) {
			if(StringUtils.equals(onORoff, "ON")) {
				if(element.isSelected()) {
					log.info(elemName + " checkbox is already selected.");
				}else {
					element.click();
					log.info(elemName + " checkbox is selected.");
				}
			}else if(StringUtils.equals(onORoff, "OFF")) {
				if(element.isSelected()) {
					element.click();
					log.info(elemName + " checkbox is selected.");
					
				}else {
					log.info(elemName + " checkbox is already unselected.");
				}
			}
		}else {
			log.error("Failed to locate the element : " + elemName);
		}
		
	}
	
	//click element
	public static void click_element(VRWebElement element, String elemName) {
		if(element.verifyPresent() && element.isEnabled()) {
			element.scrollToElement();
			element.click();
			log.info("clicked on element : " + elemName);
		}else {
			log.error("Failed to locate the element : " + elemName);
		}
	}
}
