package com.crm.data;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class CrmTestData {
	
	static CrmAccountData craccountdata = null;
	
	public static CrmAccountData testdata() {
		try {
			
			File file = new File("src//test//data//account_data.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CrmAccountData.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			craccountdata = (CrmAccountData) unmarshaller.unmarshal(file);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return craccountdata;
	}
	

}
