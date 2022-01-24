package com.aspire.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aspire.utils.ReadConfig;





public class BaseClass {
	ReadConfig config=new ReadConfig();
	
	public String baseURL=config.getAppUrl();
	public String userName="user@aspireapp.com";
	public String pwd="@sp1r3app";
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brs) {
		logger=Logger.getLogger("Aspire");
		PropertyConfigurator.configure("log4j.properties");
	if(brs.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(brs.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(brs.equals("ie")) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
	}
	else {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(baseURL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
