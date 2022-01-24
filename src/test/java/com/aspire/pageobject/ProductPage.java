package com.aspire.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//button[@type='button' and contains(text(),'Create') ]")
	WebElement createButton;
	
	
	

	public void clickToCreateProduct() {
		createButton.click();
	}
	
	

}
