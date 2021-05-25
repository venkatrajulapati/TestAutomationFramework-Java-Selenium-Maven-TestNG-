package com.application.web.libs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class VRWebElement extends test_base implements BaseElement {
	
	public WebElement elem;
	
	public VRWebElement() {
		// TODO Auto-generated constructor stub
		log.info("initializing " + VRWebElement.class + ".......");
	}
	
	public VRWebElement(String elem_desc) {
		// TODO Auto-generated constructor stub
		if(elem_desc.startsWith("xpath=")) {
			try {
				elem = driver.findElement(By.xpath(elem_desc.split("xpath=")[1]));
				
			}catch (NoSuchElementException e) {
				// TODO: handle exception
				log.error("failed to Locate Element : " + elem_desc.split("xpath=")[1]);
			}
			
		}else if(elem_desc.startsWith("id=")) {
			try {
				elem = driver.findElement(By.xpath(elem_desc.split("id=")[1]));
			}catch (NoSuchElementException e) {
				// TODO: handle exception
				log.error("failed to locate element : " + elem_desc.split("id=")[1]);
			}
			
		}
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub
		elem.click();
		
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		elem.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		elem.clear();
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return elem.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return elem.isSelected();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return elem.isEnabled();
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return elem.getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return elem.isDisplayed();
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return elem.getCssValue(propertyName);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyPresent() {
		// TODO Auto-generated method stub
		boolean result=false;
		if(elem.isDisplayed()) {
			result=true;
			
		}
		return result;
	}

	@Override
	public void mouseHover() {
		// TODO Auto-generated method stub
		Actions mouse = new Actions(driver);
		mouse.moveToElement(elem).build().perform();
	}

	@Override
	public void mouseHoverAndClick() {
		// TODO Auto-generated method stub
		Actions mouse = new Actions(driver);
		mouse.moveToElement(elem).click().build().perform();
	}

	public void mouseHoverAndDoubleClick() {
		// TODO Auto-generated method stub
		Actions mouse = new Actions(driver);
		mouse.moveToElement(elem).doubleClick().build().perform();
	}
	
	@Override
	public void scrollAndClick() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elem);
		js.executeScript("arguments[0].click();", elem);
		System.out.println("scroll");
	}
	
	
	public void scrollToElement() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elem);
		
	}
	
	@Override
	public void scrollAndDoubleClick() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elem);
		js.executeScript("arguments[0].dblclick;", elem);
		System.out.println("scroll");
	}
	
	public void sel_dropdown_item_by_visible_text(String item) {
		// TODO Auto-generated method stub
		Select dropdown = new Select(elem);
		dropdown.selectByVisibleText(item);
	}
	
	public void sel_dropdown_item_by_value(String item) {
		// TODO Auto-generated method stub
		Select dropdown = new Select(elem);
		dropdown.selectByValue(item);
	}

	


}
