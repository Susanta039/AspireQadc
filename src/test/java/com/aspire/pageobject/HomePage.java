package com.aspire.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="(//div[@class='o_caption'])[2]")
	WebElement inventoryFeature;
	@FindBy(xpath="(//div[@class='o_caption'])[3]")
	WebElement manufacturingFeature;
	public void navigateToInventory() {
		inventoryFeature.click();
		
	}
	public void navigateToManufacturing() {
		manufacturingFeature.click();
		
	}
	

}
