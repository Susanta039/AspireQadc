package com.aspire.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage {
	
WebDriver ldriver;
	
	public ProductCreatePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@placeholder='Product Name']")
	WebElement inputProductName;
	@FindBy(xpath="//button[@name='action_update_quantity_on_hand']")
	WebElement updateQuantityButton;
	@FindBy(xpath="//button[@type='button' and contains(text(),'Create') ]")
	WebElement createButton;
	@FindBy(xpath="(//div[@class='o_input_dropdown' ]/input[@type='text'])[1]")
	WebElement selectLocationDropdown;
	@FindBy(xpath="//a[contains(@id,'ui-id') and contains(text(),'WH/Stock')]")
	WebElement selectLocation;
	@FindBy(xpath="(//div[@class='o_input_dropdown' ]/input[@type='text'])[2]")
	WebElement selectPackageDropdown;
	@FindBy(xpath="//a[contains(@id,'ui-id') and contains(text(),'1')]")
	WebElement selectPackage;
	@FindBy(xpath="//input[@name='inventory_quantity']")
	WebElement inputInventoryQuantity;
	@FindBy(xpath="//button[@type='button' and contains(text(),'Save') ]")
	WebElement buttonSave;
	@FindBy(xpath="//a[@title='Applications']")
	WebElement iconApplication;
	
	
	

	public void enterProductName(String productName) {
		inputProductName.sendKeys(productName);
	}
	
	public void updateQuantity(String qty) throws InterruptedException {
		updateQuantityButton.click();
		Thread.sleep(3000);
		createButton.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		selectLocationDropdown.click();
		Thread.sleep(3000);
		selectLocation.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		selectPackageDropdown.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		selectPackage.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		inputInventoryQuantity.clear();
		inputInventoryQuantity.sendKeys(qty);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		buttonSave.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		
		
	}
	
	public void clickOnApplicationIcon() {
		iconApplication.click();
	}
	
	

}
