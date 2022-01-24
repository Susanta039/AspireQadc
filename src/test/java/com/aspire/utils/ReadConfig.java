package com.aspire.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try 
		{
			FileInputStream fil=new FileInputStream(src);
		    prop=new Properties();
		    prop.load(fil);
		
			
		}catch(Exception e) {
			System.out.println("Excepton is"+e.getMessage());
			
		}
		
	}
	public String getPropertyValue(String key) {
		String value=prop.getProperty(key);
		return value;
		
	}
	public String getAppUrl() {
		String url=prop.getProperty("URL");
		return url;
		
	}
	public String getUserName() {
		String email=prop.getProperty("EMAIL");
		return email;
		
	}
	public String getPwd() {
		String pwd=prop.getProperty("PASSWORD");
		return pwd;
		
	}
	
	
	

}
