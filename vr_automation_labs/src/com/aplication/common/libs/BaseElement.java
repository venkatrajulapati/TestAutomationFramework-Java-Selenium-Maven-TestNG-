package com.aplication.common.libs;

import org.openqa.selenium.WebElement;

public interface BaseElement extends WebElement {
	
	public boolean verifyPresent();
	public void mouseHover();
	public void mouseHoverAndClick();
	public void scrollAndClick();

}
