package com.crm.objectrepo;

import java.io.FileInputStream;
import java.util.Properties;


public class Crmor {
	
	public Properties prop;
	
	public Properties getObject() {
			
    	try {
    		FileInputStream fis = new FileInputStream("src//test//resources//crmobj.properties");
			prop = new Properties();		
			prop.load(fis);
    	    }
    	    catch (Exception e) {
				e.printStackTrace();
			}
			return prop;
		}		


}