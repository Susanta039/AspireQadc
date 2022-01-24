package com.aspire.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
WebDriver ldriver;
	
	public InventoryPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[@class='o_menu_brand']")
	WebElement inventoryMainButton;
	@FindBy(xpath="//ul[@class='o_menu_sections']/li/a[contains(text(),'Products')]")
	WebElement productButton;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a/span[1]")
	WebElement productsButtonInDropdown;
	
	

	public void validateInventoryPage() {
		inventoryMainButton.isDisplayed();
	}
	
	
	public void selectProductDropdown() {
		productButton.click();
		productsButtonInDropdown.click();
		
	}
	
	

}
