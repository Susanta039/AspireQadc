package com.aspire.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingPage {
WebDriver ldriver;
	
	public ManufacturingPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//button[@type='button' and contains(text(),'Create') ]")
	WebElement createButton;
	@FindBy(xpath="//div[@name='product_id']/div/input")
	WebElement inputProductField;
	@FindBy(xpath="(//input[@name='product_qty'])[1]")
	WebElement productQty;
	@FindBy(xpath="//a[@role='button' and contains(text(),'Add a line')]")
	WebElement addAnewLine;
	@FindBy(xpath="//tr[contains(@data-id,'stock.move')]/td/div/div/input")
	WebElement inputProductInLine;
	@FindBy(xpath="//input[@name='product_uom_qty']")
	WebElement toConsume;
	@FindBy(xpath="//button[@name='action_confirm']/span")
	WebElement buttonConfirm;
	@FindBy(xpath="//span[@placeholder='Manufacturing Reference']")
	WebElement manufacturingReference;
	@FindBy(xpath="//input[@name='qty_producing']")
	WebElement qtyProduce;
	
	@FindBy(xpath="//span[@class='o_should_consume o_required_modifier']")
	WebElement consumeModifier;
	@FindBy(xpath="//button[@name='button_mark_done' and @class='btn btn-primary']/span")
	WebElement markAsDone;
	@FindBy(xpath="//input[@role='searchbox']")
	WebElement searchBox;
	@FindBy(xpath="//*[@title='WH/MO/01760']//following-sibling::td[7]/span")
	WebElement stateStatus;
	
	
	

	public void clickToCreateManufacturingOrder() {
		createButton.click();
	}
	
	public void createAndConfirmOrder(String product,String qty) throws InterruptedException {
		inputProductField.sendKeys(product);
		ldriver.findElement(By.xpath("//a[contains(text(),'"+product+"')]")).click();
	
		Thread.sleep(3000);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		productQty.clear();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Thread.sleep(3000);
		productQty.sendKeys(qty);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		addAnewLine.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		inputProductInLine.sendKeys(product);
		Thread.sleep(3000);
		inputProductInLine.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		toConsume.clear();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		toConsume.sendKeys(qty);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		buttonConfirm.click();
		Thread.sleep(4000);
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		
	}
	public String getRefferenceNumber() {
		String refNumber=manufacturingReference.getText();
	
		return refNumber;
	}
	public void markAsDone(String qty) {
		qtyProduce.clear();
           qtyProduce.sendKeys(qty);
		
		
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		markAsDone.click();
		ldriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
	}
public String getOrderStatus(String refNu) throws InterruptedException {
	searchBox.sendKeys(Keys.BACK_SPACE);
	Thread.sleep(3000);
	searchBox.sendKeys(refNu);
	Thread.sleep(3000);
	
	String status=ldriver.findElement(By.xpath("//*[@title='"+refNu+"']//following-sibling::td[7]/span")).getText();
	return status;
	
}

}
