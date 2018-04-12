package com.crm.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "CrmAccountData")
@XmlAccessorType(XmlAccessType.FIELD)

public class CrmAccountData {

	@XmlElement(name = "accountdata")
	private List<AccountsData> caccountdata = null;

	public List<AccountsData> getCaccountdata() {
		return caccountdata;
	}

	public void setCaccountdata(List<AccountsData> caccountdata) {
		this.caccountdata = caccountdata;
	}

	
}