package com.aspire.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@name='login']")
	WebElement userName;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//*[contains(text(),'Log in')]")
	WebElement loginButton;
		
		

	
	
	public void enterEmail(String email) {
		userName.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	

	public void clickLoginButton() {
		loginButton.click();
	}
	
	

	
}
