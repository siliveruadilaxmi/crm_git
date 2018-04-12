package com.crm.configuration;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseConfiguration {
	
	public FileInputStream fis = null;
	public Properties prop = null;
	public WebDriver wd = null;
	
	public void invokeBrowser() {
		try {
			fis = new FileInputStream("src//test//resources//config.properties");
			prop = new Properties();
			prop.load(fis);
			
			String br=prop.getProperty("browser");
			if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"//"+"Documents//scriptdrivers//chromedriver.exe");
		    wd = new ChromeDriver();
			}
			else if(br.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.home")+"//"+"Documents//scriptdrivers//geckodriver.exe");
			wd = new FirefoxDriver();
			}
			else if(br.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.home")+"//"+"Documents//scriptdrivers//IEDriverServer.exe");
			wd =new InternetExplorerDriver();
			}
			wd.navigate().to(prop.getProperty("Uat_Url"));
			
			wd.manage().window().maximize();
			String impWait = prop.getProperty("Implicit_wait");
			//int implicitWait = Integer.parseInt(impWait);
			//wd.manage().timeouts().implicitlyWait(implicitWait ,TimeUnit.SECONDS);
		
			}
			catch(Exception e) {
			e.printStackTrace();
		}
	}

}
