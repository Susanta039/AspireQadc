package com.aspire.test;



import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aspire.pageobject.HomePage;
import com.aspire.pageobject.InventoryPage;
import com.aspire.pageobject.LoginPage;
import com.aspire.pageobject.ManufacturingPage;
import com.aspire.pageobject.ProductCreatePage;
import com.aspire.pageobject.ProductPage;
import com.aspire.utils.ReadConfig;

public class ValidateOrder extends BaseClass{
	ReadConfig config=new ReadConfig();

	
	@Test
	
	
	public void ValidateOrderTest() throws InterruptedException {

		
		//I have used more number of Thread.sleep sorry for that. I will change it.
		//i have prepared this project with in 3 to 4 hour so you may find some mistake
		//Report and some other things i have not added in this framework.
		
	//login to aspireOdoo
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(userName);
		lp.enterPassword(pwd);
		lp.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, config.getPropertyValue("expeTitle"));
		System.out.println("login successful");
		Thread.sleep(4000);
		
		//Navigate to inventory
		HomePage hp=new HomePage(driver);
		hp.navigateToInventory();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		InventoryPage ip=new InventoryPage(driver);
		ip.validateInventoryPage();
		Thread.sleep(4000);
		ip.selectProductDropdown();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ProductPage pp=new ProductPage(driver);
		pp.clickToCreateProduct();
		System.out.println("clicked on product Create");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ProductCreatePage pcp=new ProductCreatePage(driver);
		pcp.enterProductName(config.getPropertyValue("productname"));
		
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//update quantity
		pcp.updateQuantity(config.getPropertyValue("qty"));
		System.out.println("product quantity updated");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pcp.clickOnApplicationIcon();
		System.out.println("On home page");
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		//Place Manufacturing Order
		hp.navigateToManufacturing();
		ManufacturingPage mp=new ManufacturingPage(driver);
		mp.clickToCreateManufacturingOrder();
		Thread.sleep(4000);
		mp.createAndConfirmOrder(config.getPropertyValue("productname"),config.getPropertyValue("qtyConsumed"));
		String refnum=mp.getRefferenceNumber();
		Thread.sleep(4000);
		System.out.println(refnum);
		System.out.println("Order Placed");
		mp.markAsDone(config.getPropertyValue("qtyConsumed"));
		Thread.sleep(4000);
		pcp.clickOnApplicationIcon();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//validate orderStatus
		hp.navigateToManufacturing();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String status=mp.getOrderStatus(refnum);
		System.out.println(status);
		Assert.assertEquals(status, "Done");
		System.out.println("Status changed to Done");
		
	}
	
	


}
