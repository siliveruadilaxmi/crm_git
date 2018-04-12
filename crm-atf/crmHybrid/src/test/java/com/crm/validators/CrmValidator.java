package com.crm.validators;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.Assert;

import com.crm.data.AccountsData;
import com.crm.data.CrmAccountData;
import com.crm.data.CrmCsvReader;
import com.crm.data.CrmDbData;
import com.crm.data.CrmTestData;
import com.crm.services.Crmservice;
import com.crm.utils.CommonUtils;


public class CrmValidator {


       CrmAccountData cadata = null;
       List<AccountsData> crmaccountdata = null;

     public class cvalid<crmaccountsdata> {
	
	CrmAccountData cadata = null;
	List<AccountsData> crmaccountsdata = null;
	
	public void validateHomePage(Crmservice cservice){
		Assert.assertTrue(cservice.checkHomePageHeader());
	}
	
	public void validateUserLogin(Crmservice cservice){
		Assert.assertEquals("Admin", cservice.getLoginUserAccount());
	}
		
	public void validateGivenUserAccountDetails(Crmservice cservice){
		cadata = CrmTestData.testdata();
		crmaccountdata = cadata.getCaccountdata();
		Assert.assertEquals("958214527", cservice.getCreatedAccountMobileNumber());
		String uname = cservice.getCreatedAccountUserName();
	
		ArrayList<String> ubillingaddress = cservice.getShipingAddress();  //copy billing
		Assert.assertEquals(crmaccountdata.get(0).getAccountStreet(), ubillingaddress.get(0));
		Assert.assertEquals(crmaccountdata.get(0).getAccountCity()+",", ubillingaddress.get(1));
		Assert.assertEquals(crmaccountdata.get(0).getAccountState(), ubillingaddress.get(2));
		Assert.assertEquals(crmaccountdata.get(0).getAccountPostalCode(), ubillingaddress.get(3));
		Assert.assertEquals(crmaccountdata.get(0).getAccountCountry(), ubillingaddress.get(4));
		
    	if(cservice.isBillingAddressCopied()){
		ArrayList<String> ushippingaddress = cservice.getShipingAddress();
		Assert.assertEquals(crmaccountdata.get(0).getAccountStreet(), ushippingaddress.get(0));
		Assert.assertEquals(crmaccountdata.get(0).getAccountCity()+",", ushippingaddress.get(1));
		Assert.assertEquals(crmaccountdata.get(0).getAccountState(), ushippingaddress.get(2));
		Assert.assertEquals(crmaccountdata.get(0).getAccountPostalCode(), ushippingaddress.get(3));
		Assert.assertEquals(crmaccountdata.get(0).getAccountCountry(), ushippingaddress.get(4));
		Assert.assertEquals(ubillingaddress, ushippingaddress);  //copy billing
		}
		
		else{
			ArrayList<String> ushippingaddress1 = cservice.getShipingAddress();
			Assert.assertEquals(crmaccountdata.get(0).getAccountShipStreet(), ushippingaddress1.get(0));
			Assert.assertEquals(crmaccountdata.get(0).getAccountCity()+",", ushippingaddress1.get(1));
			Assert.assertEquals(crmaccountdata.get(0).getAccountState(), ushippingaddress1.get(2));
			Assert.assertEquals(crmaccountdata.get(0).getAccounyShipPostalCode(), ushippingaddress1.get(3));
			Assert.assertEquals(crmaccountdata.get(0).getAccountShipCountry(), ushippingaddress1.get(4));
	}
}}
		
		
	public void validateGivenUserAccountWithoutCopyBilling(Crmservice cservice){
		
		String mobilenumber = cservice.getCreatedAccountMobileNumber();
		Assert.assertEquals("9582145227", mobilenumber);
		
		String emailaddress = cservice.getCreatedAccountEmailAddress();
		Assert.assertEquals("abc@espocrm.com", emailaddress);

		String website = cservice.getCreatedAccountWebsite();
		Assert.assertEquals("seleniumhq.com", website);
		
		ArrayList<String> ubillingaddress = cservice.getShipingAddress();  
		Assert.assertEquals("ayodhyanagarcolony", ubillingaddress.get(0));
		Assert.assertEquals("mp,", ubillingaddress.get(1));
		Assert.assertEquals("telangana", ubillingaddress.get(2));
		Assert.assertEquals("500028", ubillingaddress.get(3));
		Assert.assertEquals("jkl", ubillingaddress.get(4));
		
	}
	
public void validateTheEditedAccountWithoutCopyBilling(Crmservice cservice){
		
		String mobilenumber = cservice.getCreatedAccountMobileNumber();
		Assert.assertEquals("8143657322", mobilenumber);
		
		String emailaddress = cservice.getCreatedAccountEmailAddress();
		Assert.assertEquals("test@espocrm2.com", emailaddress);

		String website = cservice.getCreatedAccountWebsite();
		Assert.assertEquals("www.google.com", website);
		
		ArrayList<String> ubillingaddress = cservice.getShipingAddress();  
		Assert.assertEquals("suryanagar", ubillingaddress.get(0));
		Assert.assertEquals("IDPL,", ubillingaddress.get(1));
		Assert.assertEquals("telangana", ubillingaddress.get(2));
		Assert.assertEquals("500037", ubillingaddress.get(3));
		Assert.assertEquals("India", ubillingaddress.get(4));
		
		ArrayList<String> ushippingaddress = cservice.getShipingAddress();
		Assert.assertEquals("gandhinagar", ushippingaddress.get(0));
		Assert.assertEquals("IDPL,", ushippingaddress.get(1));
		Assert.assertEquals("telangana", ushippingaddress.get(2));
		Assert.assertEquals("500301", ushippingaddress.get(3));
		Assert.assertEquals("India", ushippingaddress.get(4));
		
	}
		
     public void validateContactsDetails(Crmservice cservice) throws InterruptedException{
		Assert.assertFalse(cservice.getItemInTabList().contains("item"));
		cservice.clickContactsInDashboard();
		Assert.assertFalse(crmaccountdata.contains("item"));
	  }
   


	     public void validateCreateContact(Crmservice cservice){
		 
	     cadata = CrmTestData.testdata();
	     crmaccountdata = cadata.getCaccountdata();
		 String email = cservice.createdContactEmail();
		 Assert.assertEquals(crmaccountdata.get(2).getContactsEmail(), email);
	     String phone = cservice.createdContactPhone();
		 Assert.assertEquals(crmaccountdata.get(2).getContactsPhoneNumber(), phone);
		 
		 
	 } 
	     
	     public void validateDeleteItemFromList(Crmservice cservice) throws InterruptedException {
	    	 Assert.assertFalse(cservice.getFirstTextFromTabList().contains("item"));
	    	 Assert.assertFalse(cservice.getItemFromEspoDashboardList().contains("item"));
	     }
	     
 
      //DB VALIDATION on account

    public static void validateAccountDetailsAgainstDb(String qpath, Crmservice  cservice) {
		 List<String> accountList = CrmDbData.getDbData(qpath, 2);
		 System.out.println(accountList);
		 Assert.assertTrue(accountList.contains(cservice.getCreatedAccountUserName()));
		 
		 List<String> accountWebsite = CrmDbData.getDbData(qpath, 4);
		 System.out.println(accountWebsite);
		 Assert.assertTrue(accountList.contains(cservice.getCreateAccountBillingAdrresss()));
		 
		 List<String> billAdd = cservice.getCreateAccountBillingAdrresss();
		
//		    List<String> accountstreet = CrmDbData.getDbData(qpath, 8);
//			System.out.println(accountstreet);
//		    Assert.assertTrue(accountstreet.contains(billAdd.get(0)));
//		    
//		    List<String> accountcity = CrmDbData.getDbData(qpath, 9);
//			System.out.println(accountcity);
//		    Assert.assertTrue(accountcity.contains(billAdd.get(0)));
//		 
//		    
//		    List<String> accountstate = CrmDbData.getDbData(qpath, 10);
//			System.out.println(accountstate);
//		    Assert.assertTrue(accountstate.contains(billAdd.get(0)));
//		    
//		    List<String> accountcountry = CrmDbData.getDbData(qpath, 11);
//			System.out.println(accountcountry);
//		    Assert.assertTrue(accountcountry.contains(billAdd.get(0)));
//		    
//		    List<String> accountpostalcode = CrmDbData.getDbData(qpath, 12);
//			System.out.println(accountpostalcode);
//		    Assert.assertTrue(accountpostalcode.contains(billAdd.get(0)));
		    
		    List<String> dbbilladd = CrmDbData.getMultipleDataAgainstDb(qpath, 8,9,10,11,12);
			System.out.println(dbbilladd);
		    Assert.assertEquals(dbbilladd,billAdd);
    }
   
 //Roles Validation
    
    public void validateRoles(Crmservice cservice) {
    	cadata = CrmTestData.testdata();
		crmaccountdata = cadata.getCaccountdata();
		
		        String name = cservice.getCreatedRName();
		        Assert.assertEquals(crmaccountdata.get(5).getNamer(), name);
		       
		        String expper = cservice.getCreatedExpper();
			    Assert.assertEquals(crmaccountdata.get(5).getRexportpermission(), expper);
			
		       String userper = cservice.getCreatedUserPer();
			   Assert.assertEquals(crmaccountdata.get(5).getRuserpermission(), userper);
		
			   String assinper = cservice.getCreatedAssiPer();
			   Assert.assertEquals(crmaccountdata.get(5).getRassigpermission(), assinper);
			
			   String portper = cservice.getCreatedPortPer();
			   Assert.assertEquals(crmaccountdata.get(5).getRportpermission(), portper);
			
			   String emailper = cservice.getCreatedEmailPer();
			   Assert.assertEquals(crmaccountdata.get(5).getRemailpermission(), emailper);
			   
    }		   
  //DB validation on roles
			 
    public void validateRolesAgainstDB(String qpath, Crmservice cservice) {
			    	
			    	List<String> rname = CrmDbData.getDbData(qpath, 2);
					System.out.println(rname);
				    Assert.assertTrue(rname.contains(cservice.getCreatedRName()));
				    
				    List<String> expper = CrmDbData.getDbData(qpath, 8);
					System.out.println(expper);
				    Assert.assertTrue(expper.contains(cservice.getCreatedExpper()));
				    
				    List<String> userper = CrmDbData.getDbData(qpath, 5);
					System.out.println(userper);
				    Assert.assertTrue(userper.contains(cservice.getCreatedUserPer()));
				    
				    List<String> assinper = CrmDbData.getDbData(qpath, 4);
					System.out.println(assinper);
				    Assert.assertTrue(assinper.contains(cservice.getCreatedAssiPer()));
				    
				    List<String> portper = CrmDbData.getDbData(qpath, 6);
					System.out.println(portper);
				    Assert.assertTrue(portper.contains(cservice.getCreatedPortPer()));
				    
				    List<String> emailper = CrmDbData.getDbData(qpath, 7);
					System.out.println(emailper);
				    Assert.assertTrue(emailper.contains(cservice.getCreatedEmailPer()));
    }
			   
			   
	
   
  //Validation on Opportunities
    
    public void validateOpportunities(Crmservice cservice) {
    	cadata = CrmTestData.testdata();
		crmaccountdata = cadata.getCaccountdata();
		
		String opponame = cservice.getCreatedOppoName();
		Assert.assertEquals(crmaccountdata.get(4).getOppoName(), opponame);
		
		//String oppoaccount = cservice.getCreatedOppoAmount();
		//Assert.assertEquals(crmaccountdata.get(4).getOppoa, oppoaccount);
		
		String oppostage = cservice.getCreatedOppoStage();
		Assert.assertEquals(crmaccountdata.get(4).getOppoStage(), oppostage);
		
		//String oppoamount = cservice.getCreatedOppoAmount();
		//Assert.assertEquals(crmaccountdata.get(4).getOppoAmount(), oppoamount);
		
		String oppoloadsource = cservice.getCreatedLoadSource();
		Assert.assertEquals(crmaccountdata.get(4).getOppoLeadSource(), oppoloadsource);
		
		String oppodescription = cservice.getCreatedOppodescription();
		Assert.assertEquals(crmaccountdata.get(4).getOppoDescription(), oppodescription);
    }
	
    //DB VALIDATION OPPORTUNITY
    
    public void validateOpportunitiesAgainstDB(String qpath, Crmservice cservice) {
    	
    	List<String> opponame = CrmDbData.getDbData(qpath, 2);
		System.out.println(opponame);
	    Assert.assertTrue(opponame.contains(cservice.getCreatedOppoName()));
	    
//	    List<String> oppoaccount = CrmDbData.getDbData(qpath, 4);
//		System.out.println(oppoaccount);
//	    Assert.assertTrue(oppoaccount.contains(cservice.getCreatedAccount()));
	    
//	    List<String> oppoamount = CrmDbData.getDbData(qpath, 4);
//		System.out.println(oppoamount);
	//    Assert.assertTrue(oppoamount.contains(cservice.getCreatedOppoAmount()));
	    
	    
	    List<String> oppostage = CrmDbData.getDbData(qpath, 5);
		System.out.println(oppostage);
	    Assert.assertTrue(oppostage.contains(cservice.getCreatedOppoStage()));
    
	    List<String> oppoloadsource = CrmDbData.getDbData(qpath, 7);
		System.out.println(oppoloadsource);
	    Assert.assertTrue(oppoloadsource.contains(cservice.getCreatedLoadSource()));
    
	    List<String> oppodescription = CrmDbData.getDbData(qpath, 9);
		System.out.println(oppodescription);
	    Assert.assertTrue(oppodescription.contains(cservice.getCreatedOppodescription()));
	    
  }
 
    
    //VALIDATION ON LEADS
  	
    public void validateLeads(Crmservice cservice) {
    	
    	String firstname = cservice.getExistingLeadName();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadFirstName(), firstname);
    	
    	String lastname = cservice.getExistingLeadAccount();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadAccountName(), lastname);
    	
    	String laccount = cservice.getExistingLeadAccount();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadAccountName(), laccount);
    	
    	String lemail = cservice.getExistingLeadAccount();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadAccountName(), lemail);
    	
    	String lphone = cservice.getExistingLeadAccount();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadAccountName(), lphone);
    	
    	String ltitle = cservice.getExistingLeadAccount();
    	Assert.assertEquals(crmaccountdata.get(6).getLeadAccountName(), ltitle);
    	
    }
    
    //DB validation on Leads
    
      public void validateLeadsAgainstDB(String qpath, Crmservice cservice) {
    	
//	    	List<String> lname = CrmDbData.getDbData(qpath, 3);
//			System.out.println(lname);
//		    Assert.assertTrue(lname.contains(cservice.getExistingLeadName()));
		    
//		    List<String> firstname = CrmDbData.getDbData(qpath, 3);
//			System.out.println(firstname);
//		    Assert.assertTrue(firstname.contains(cservice.getExis));
			
//			List<String> lemail = CrmDbData.getDbData(qpath, 3);
//			System.out.println(lemail);
//		    Assert.assertTrue(lemail.contains(cservice.getCreatedLeadEmail()));
		    
//		    List<String> lemail = CrmDbData.getDbData(qpath, 3);
//			System.out.println(lemail);
//		    Assert.assertTrue(lemail.contains(cservice.getCreatedLeadEmail()));
			
		    List<String> leadwebsite = CrmDbData.getDbData(qpath, 11);
			System.out.println(leadwebsite);
		    Assert.assertTrue(leadwebsite.contains(cservice.getCreatedLeadWebsite()));	    
      }
	    
    
	//Validation on Task
	
		public void validationTask(Crmservice cservice) {
			cadata = CrmTestData.testdata();
			crmaccountdata = cadata.getCaccountdata();
			
			 String tname = cservice.getExistingTaskName();
		     Assert.assertEquals(crmaccountdata.get(7).getTaskName(), tname);
		     

		     String tstatus = cservice.getExitStatus();
		     Assert.assertEquals(crmaccountdata.get(7).getTaskStatus(), tstatus);
		     
		     String tpriority = cservice.getExitPriority();
		     Assert.assertEquals(crmaccountdata.get(7).getTaskPriority(), tpriority);
		     

		     String tdescription = cservice.getExitDescription();
		     Assert.assertEquals(crmaccountdata.get(7).getTaskDescription(), tdescription);
		}
		
	//DBvalidation on Task
		
		public void validateTaskAgainstDb(String qpath, Crmservice cservice) {
	    	
	    	List<String> tname = CrmDbData.getDbData(qpath, 2);
			System.out.println(tname);
		    Assert.assertTrue(tname.contains(cservice.getExistingTaskName()));
		    
		    List<String> tstatus = CrmDbData.getDbData(qpath, 4);
			System.out.println(tstatus);
		    Assert.assertTrue(tstatus.contains(cservice.getExitStatus()));
		
		    List<String> tpriority = CrmDbData.getDbData(qpath, 5);
			System.out.println(tpriority);
		    Assert.assertTrue(tpriority.contains(cservice.getExitPriority()));
		
		    List<String> tdescription = CrmDbData.getDbData(qpath, 11);
			System.out.println(tdescription);
		    Assert.assertTrue(tdescription.contains(cservice.getExitDescription()));
		}
		
	//UI Validation Contacts Ui with Csv file
		
		public void validateContactsUiWithCsvData(String qpath, Crmservice cservice) throws IOException {
			CrmCsvReader csv = new CrmCsvReader();
			
			List<String> csvdata = csv.getCsvData();
			System.out.println(csvdata);
			ArrayList<String> contactname = cservice.getImportedContactAddress();
			assertEquals(csvdata,  contactname);
		}
		
		
  //UI validation with Csv
		
		//public void validateUiWithCsv(String path , Crmservice cservice) {
			
	public void validateContactCsvDataAgainstUiDataAndDbData(Crmservice cservice, String qpath) throws IOException{
				
//				System.out.println("Succesfully validated csv and ui data");
//				List<String> contactCsvDataList = CrmCsvFile.getCsvData();  ////// csv and ui
//				ArrayList<String> contactUiDataList = cservice.getCreatedContactDetails();
//				Assert.assertEquals(contactCsvDataList, contactUiDataList);
				
//				System.out.println("Succesfully validated csv and db data");
//				List<String> contactCsvDataList = CrmCsvReader.getCsvData();    //// csv and db
//				contactCsvDataList.remove(2);
//				contactCsvDataList.remove(3);
//				List<String> contactDbDataList = CrmDbData.getDbDataListOfContacts(qpath);
//				Assert.assertEquals(contactCsvDataList, contactDbDataList);
				
				System.out.println("Succesfully validated ui and db data");
				List<String> contactUiDataList1 = cservice.getImportedContactAddress();	// ui and db
				List<String> contactDbDataList1 = CrmDbData.getDbDataListOfContacts(qpath);
				Assert.assertEquals(contactUiDataList1, contactDbDataList1);
		}
		
		
 
		
//validation on leads with Csv
		
		public void validateLeadsCsv(Crmservice cservice) {
			
			
			
		}
		
		
		
//DBValidation on Leads using Csv file
		
		public void validateLeadCsvFile(String qpath, Crmservice cservice) {
			
			List<String> leadname = CrmDbData.getDbData("qpath", 2);
			System.out.println(leadname);
			Assert.assertTrue(leadname.contains(cservice.getImportedLeadName()));
			
//			List<String> firstname = CrmDbData.getDbData(qpath, 3);
//			System.out.println(firstname);
//			Assert.assertTrue(firstname.contains(cservice.getImportedLirsrname));
			
//			List<String> lastname = CrmDbData.getDbData(qpath, 4);
//			System.out.println(lastname);
//			Assert.assertTrue(lastname.contains(cservice.getImportedLeadLastname()));
		

			List<String> leademail = CrmDbData.getDbData("qpath", 2);
			System.out.println(leademail);
			Assert.assertTrue(leademail.contains(cservice.getImportedLeadEmail()));
				
		
			List<String> leadphonenumber = CrmDbData.getDbData("qpath", 2);
			System.out.println(leadphonenumber);
			Assert.assertTrue(leadphonenumber.contains(cservice.getImportedLeadPhoneNumber()));
		
		
			List<String> leadwebsite = CrmDbData.getDbData("qpath", 9);
			System.out.println(leadwebsite);
			Assert.assertTrue(leadwebsite.contains(cservice.getImportedLeadWebsite()));
		
		
			List<String> description = CrmDbData.getDbData("qpath", 16);
			System.out.println(description);
			Assert.assertTrue(description.contains(cservice.getImportedLeadName()));
		}
}
		
		
		

		
		

			
    










	
	
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		

