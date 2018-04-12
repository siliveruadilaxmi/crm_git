package com.crm.testscripts;



import java.io.IOException;
import java.util.List;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.data.AccountsData;
import com.crm.services.Crmservice;
import com.crm.utils.CommonUtils;
import com.crm.validators.CrmValidator;
import com.sun.glass.ui.Screen;
import com.crm.data.CrmAccountData;
import com.crm.data.CrmTestData;



public class AdminTest {
	
	Crmservice cservice = new Crmservice();
	CrmValidator cvalidator = new CrmValidator();
	CrmAccountData cdata = null;
	List<AccountsData> crmdata = null;
	
	
	
	@BeforeTest
	public void loginCrm() throws InterruptedException {
	cdata = CrmTestData.testdata();
	crmdata = cdata.getCaccountdata();
	
	
	
	cservice.openCrmApplication();
	CommonUtils.wait(1);
	cservice.loginCrmApplication("admin", "admin");
    //cvalidator.validateUserLogin(cservice);
		System.out.println(" logged in");
		
		//cservice.getCreatedAccountMobileNumber();
		//cservice.getCreatedAccountEmailAddress();
		//cservice.getLoginUserAccount();
		//cservice.clickContactsInDashboard();//.clickExistingNameLink("testuser");
		//cvalidator.validateGivenUserAccountWithoutCopyBilling(cservice);
	}

//	@Test(description = "enter account details", priority = 0)
	public void enterAccountDetailsWithoutShippingAddress() throws InterruptedException{
		cservice.clickDashboadAccount().clickCreateAccountBtn().enterUserAccountDetails(crmdata.get(0).getAccountUserName(), crmdata.get(0).getAccountEmail(), null, null);
		cvalidator.validateGivenUserAccountWithoutCopyBilling(cservice);
		//cservice.getExistingUserName();
		}


	
//	@Test(description = "edit saved Account details", priority = 1)
//	public void editSavedAccountDetails1() throws InterruptedException{
//		
//		cservice.clickEditButton();
//		cservice.editDropDown();
//	}
//
//	public void clickSavebutton() {
//		
//	
//	}

	@Test(description = "create account", priority = 0)
	 public void enterAccountDetails() throws InterruptedException, FindFailed {
		 cservice.clickDashboadAccount().clickCreateAccountBtn();
		 cservice.enterUserAccountDetails(crmdata.get(0).getAccountUserName(), crmdata.get(0).getAccountEmail(), crmdata.get(0).getAccountPhoneNumber(), crmdata.get(0).getAccountWebSite());
		 CommonUtils.wait(2);
		 cservice.enterBillingAddress(crmdata.get(0).getAccountStreet(), crmdata.get(0).getAccountCity(), crmdata.get(0).getAccountState(), crmdata.get(0).getAccountPostalCode(), crmdata.get(0).getAccountCountry());
		 CommonUtils.wait(2);
		 cservice.clickSavebutton();
		 //cservice.navigateToHomePage();	
		 CrmValidator.validateAccountDetailsAgainstDb("src//test//data//db_queries//tc_001.sql", cservice);
		 //cvalidator.validateGivenXmlUserAccountDetails(cservice);
	}
	 
//	@Test(description = "create account with copy billing", priority = 1)
	 public void enterBillingAddress() throws InterruptedException {
		// cservice.clickCreateAccountBtn().clickCreateAccountBtn();
		 cservice.enterBillingAddress(crmdata.get(0).getAccountStreet(), crmdata.get(0).getAccountCity(), crmdata.get(0).getAccountState(), crmdata.get(0).getAccountPostalCode(), crmdata.get(0).getAccountCountry());
		 cservice.clickSavebutton();
	}

// @Test(description = "create account without copy billing", priority = 1)
	   public void enterShipingAddress() throws InterruptedException {
		 cservice.clickCreateAccountBtn().clickCreateAccountBtn();
		 cservice.enterShippingAddress1(crmdata.get(0).getAccountShipStreet(),crmdata.get(0).getAccountShipPhoneNumber(),crmdata.get(0).getAccountShipCity(),crmdata.get(0).getAccounyShipPostalCode(),crmdata.get(0).getAccountShipCountry());
		 cservice.clickSavebutton();
		 cservice.clickEditButton();
	 }

//	@Test(description = "edit saved Account details", priority = 1)
	public void editSavedAccountDetails() throws InterruptedException{
			Thread.sleep(2000);
			cservice.clickEditButton();
			cservice.editDropDown();
		}
		
//	@Test (description = "clear saved account details", priority = 1)
	public void clearSavedAccountDetails() throws InterruptedException{
	//cservice.clickDashboadAccount().actionsButton().actionsButtonremove();
	}
	
	@Test (description   = "create a contact", priority=0)
      public void enterContactsDetails() throws InterruptedException {
	   cservice.clickContactsInDashboard().clickCreateContact();
	   cservice.enterSalutationName();
	   cservice.enterContactFirstName(crmdata.get(2).getContactsFirstName());
	   cservice.enterContactLastName(crmdata.get(2).getContactsLastName());
	   cservice.selectaccount(crmdata.get(2).getContactsaccount());
	   cservice.selectexistinguser();
	   cservice.clickSelectButton();
	   cservice.enterContactEmail(crmdata.get(2).getContactsEmail());
	   cservice.enterContactPhoneNumber(crmdata.get(2).getContactsPhoneNumber());
	   cservice.enterContactStreet(crmdata.get(2).getContactsStreet());
	   cservice.enterContactCity(crmdata.get(2).getContactscity());
	   cservice.enterContactState(crmdata.get(2).getContactsState());
	   cservice.enterContactPostalCode(crmdata.get(2).getContactsPostalCode());
	   cservice.enterContactCountry(crmdata.get(2).getContactsCountry());
	   cservice.enterContactDescription(crmdata.get(2).getContactsDescription());
	   cservice.clickSavebutton();
   }
    
     @Test (description   = "edit contact", priority=0)
    public void enterContactSecondAddress() throws InterruptedException {
       cservice.clickOnContactsEditButton();
       cservice.clearExistingdata();
       cservice.enterSalutationName();
       cservice.enterContactFirstName(crmdata.get(3).getContactsFirstName());
       cservice.enterContactLastName(crmdata.get(3).getContactsLastName());
	   cservice.enterContactEmail(crmdata.get(3).getContactsEmail());
	   cservice.enterContactPhoneNumber(crmdata.get(3).getContactsPhoneNumber());
	   cservice.enterContactStreet(crmdata.get(3).getContactsStreet());
	   cservice.enterContactCity(crmdata.get(3).getContactscity());
	   cservice.enterContactState(crmdata.get(3).getContactsState());
	   cservice.enterContactPostalCode(crmdata.get(3).getContactsPostalCode());
	   cservice.enterContactCountry(crmdata.get(3).getContactsCountry());
	   cservice.enterContactDescription(crmdata.get(3).getContactsDescription());
	   cservice.clickSavebutton();
	   cvalidator.validateCreateContact(cservice);
    }
    
    @Test (description = "deleting item from hamburger" , priority = 0)
        public void getCrmDashboard() throws InterruptedException{
   		cservice.getItemInTabList();
   		cservice.clickDashboardMenuBar1().clickOnAdministrationInMenu();
   		CommonUtils.wait(2);
   		cservice.clickOnUserInterfaceLink().getFirstTextFromTabList();
   		cservice.getFirstTextFromTabList();
   		cservice.clickonDeleteSymbol();
   		cservice.clickSavebutton();
   		//cvalidator.validateDeleteItemFromList(cservice);
   }
      
   //Adding Item

      @Test(description = "hamburger" , priority = 0)
         public void addItem() throws InterruptedException {
   	   cservice.clickDashboardMenuBar1().clickOnAdministrationInMenu();
   	   cservice.clickOnUserInterfaceLink();
   	   CommonUtils.wait(2);
   	   cservice.clickOnAddButton();
   	   cservice.clickAddInAdd();
      }
   
	//CREATE ROLES
	
	@Test(description = "create roles", priority = 0)
	  public void clickonhamburger() throws InterruptedException{
		 cservice.clickDashboardMenuBar1();
		 cservice.clickOnAdministrationInMenu();
		 cservice.clickOnRoles();
		 CommonUtils.wait(2);
		 cservice.clickCreateRole();
		 CommonUtils.wait(2);
		 cservice.enterRname(crmdata.get(5).getNamer());
		 cservice.selectDropDownEportPermission(crmdata.get(5).getRexportpermission());
		 cservice.selectDropDownUserPermission(crmdata.get(5).getRuserpermission());
		 cservice.slectDropDownAssignmentPermission(crmdata.get(5).getRassigpermission());
		 cservice.slectDropDownPortalPermission(crmdata.get(5).getRportpermission());
		 cservice.selectDropDownEmailPermission(crmdata.get(5).getRemailpermission());
		 cservice.clickSavebutton();
		 cvalidator.validateRoles(cservice);
		 cvalidator.validateRolesAgainstDB("src//test//data//db_queries//tc_005.sql", cservice);
		
	 }

   //CRETEING OPPORTUNITIES
  
	@Test(description = "opportunities" , priority = 0) 
	   public void enterOpportunitiesDetails() throws InterruptedException {
		   cservice.clickOpportunitiesInDashboard();
		   CommonUtils.wait(2);
		   cservice.clickCreateOpportunities();
		   cservice.enterOpportunitiesName(crmdata.get(4).getOppoName());
		   cservice.clickUparrowButton(crmdata.get(4).getOppoUparrow());
		   cservice.selectExistingUser1(crmdata.get(4).getOppoExixtingAccount());
		   cservice.clickButton(crmdata.get(4).getOppoButton());
		   cservice.selectDropDown(crmdata.get(4).getOppoDropDown());
		   cservice.enterOppoAmount(crmdata.get(4).getOppoAmount());
		   cservice.enterProbability(crmdata.get(4).getOppoProbability());
		   cservice.enteroppoDate(crmdata.get(4).getOppoCloseDate());
		   cservice.enterCloseDate();
		 //  cservice.clickContUparrowButton(crmdata.get(4).getContactsDescription());
		   cservice.enterLoadSource();
		   cservice.enterOppoDescription(crmdata.get(4).getOppoDescription());
		   cservice.clickSavebutton();
		   //cvalidator.validateOpportunities(cservice);
		   //cvalidator.validateOpportunitiesAgainstDB("src//test//data//db_queries//tc_004.sql", cservice);
	   }
	   
	   //CREATE LEADS
	
	   @Test (description = "Creating Lead without details section", priority = 0)
		public void creatingLead() throws InterruptedException{
		    CommonUtils.wait(2);
			cservice.clickOnDashboardLead();
			CommonUtils.wait(2);
			cservice.clickOnCreateLead();
			CommonUtils.wait(2);
			cservice.enterLeadDetails(crmdata.get(6).getLeadFirstName(), crmdata.get(6).getLeadLastName(), crmdata.get(6).getLeadAccountName(), crmdata.get(6).getLeadEmail(), crmdata.get(6).getLeadPhoneNumber(), crmdata.get(6).getLeadTitle());
			cservice.enterLeadAddressDetails(crmdata.get(6).getLeadStreet(), crmdata.get(6).getLeadCity(), crmdata.get(6).getLeadState(), crmdata.get(6).getLeadPostalCode(), crmdata.get(6).getLeadCountry());
			cservice.enterLeadWebsite(crmdata.get(6).getLeadWebsite());
			cservice.clickSaveButtonAfterEnteringLeadDetails();

		}
		
	@Test (description = "Creating Lead with details section", priority = 0)
		public void creatingLeadWithDetails() throws InterruptedException{
			CommonUtils.wait(1);
			cservice.clickOnDashboardLead();
			CommonUtils.wait(2);
			cservice.clickOnCreateLead();
			CommonUtils.wait(2);
			cservice.enterLeadDetails(crmdata.get(6).getLeadFirstName(), crmdata.get(6).getLeadLastName(), crmdata.get(6).getLeadAccountName(), crmdata.get(6).getLeadEmail(), crmdata.get(6).getLeadPhoneNumber(), crmdata.get(6).getLeadTitle());
			cservice.enterLeadAddressDetails(crmdata.get(6).getLeadStreet(), crmdata.get(6).getLeadCity(), crmdata.get(6).getLeadState(), crmdata.get(6).getLeadPostalCode(), crmdata.get(6).getLeadCountry());
			cservice.enterLeadWebsite(crmdata.get(6).getLeadWebsite());
			cservice.enterLeadDetailsFields(crmdata.get(6).getLeadOpportunityAmount(), crmdata.get(6).getLeadDescription());
			cservice.clickSaveButtonAfterEnteringLeadDetails();
			//cvalidator.validateLeads(cservice);
			cvalidator.validateLeadsAgainstDB("src//test//data//db_"
					+ "queries//tc_007.sql", cservice);
		}
  
		
   //CREATE TASK
		
		@Test (description = "creating task without date", priority = 0)
		public void  enterTaskDetails1() throws InterruptedException {
			cservice.clickDashboardTask();
			cservice.clickDashboardCreateTask();
			cservice.enterTaskName(crmdata.get(7).getTaskName());
			cservice.enterParentAccount(crmdata.get(7).getTaskParentAccount());
			cservice.clickUpArrowButton();
			cservice.clickTaskExistingUser(crmdata.get(7).getTaskExistUser());
			cservice.enterTaskStatus(crmdata.get(7).getTaskStatus());
			cservice.enterTaskPriority(crmdata.get(7).getTaskPriority());
			cservice.enterDescription(crmdata.get(7).getTaskDescription());
			CommonUtils.wait(2);
			cservice.clickSavebutton();
			cvalidator.validationTask(cservice);
			
			
		}
	
		@Test (description = "creating task with date", priority = 0)
		public void  enterTaskDetails() throws InterruptedException {
			cservice.clickDashboardTask();
			CommonUtils.wait(3);
			cservice.clickDashboardCreateTask();
			cservice.enterTaskName(crmdata.get(7).getTaskName());
			cservice.enterParentAccount(crmdata.get(7).getTaskParentAccount());
			cservice.clickUpArrowButton();
			cservice.clickTaskExistingUser(crmdata.get(7).getTaskExistUser());
			cservice.enterTaskStatus(crmdata.get(7).getTaskStatus());
			cservice.enterTaskPriority(crmdata.get(7).getTaskPriority());
    		cservice.enterTaskDateStart(crmdata.get(7).getTaskDateStart());
			cservice.enterTaskDateDue(crmdata.get(7).getTaskDateDue());
			cservice.enterDescription(crmdata.get(7).getTaskDescription());
			CommonUtils.wait(2);
			cservice.clickSavebutton();
			cvalidator.validationTask(cservice);
			cvalidator.validateTaskAgainstDb("src//test//data//db_queries//tc_006.sql", cservice);
		}
		
	@Test (description = "creating account using sikuli" , priority = 0)
		
				public void enteraccountdetails() throws InterruptedException, FindFailed {
					   cservice.navigateToHomePage();
			}
			
				
		//	@Test (description = "crating Contacts By Importing CSV File" , priority = 0)
			public void createContactNewDeatils() throws InterruptedException, FindFailed, IOException {
				cservice.clickonHamBurger();
				cservice.clickAdministartion();
				cservice.clickImportBtn();
				cservice.selectDropDownContact().clickChooseFile().clickImportFile().clickOpen().clickCreateOnly().clickNextBtn();
				cservice.selectPhoneNumber().selectEmail().selectStreet().selectCity().selectState().selectPostalCode().selectCountry();
				cservice.clickRunImportBtn();
				CommonUtils.wait(2);
				cservice.clickOnImportedLead();
				cvalidator.validateContactsUiWithCsvData("qpath", cservice);
				cvalidator.validateContactCsvDataAgainstUiDataAndDbData(cservice, "qpath");
				
			
			}
			
			// @Test(description = "create Tasks By Importing CSV File", priority = 0)
			public void createTasksWithCsvFile() throws InterruptedException, FindFailed {
				cservice.clickonHamBurger();
				cservice.clickAdministartion();
				cservice.clickOnImportedTask();
				//cservice.selectEntityTypeForTasks();
				cservice.createTasksWithCsvFile();
				//cservice.clickOnAdminNext().fillTasksDetails().clickOnRunImport().clickOnImportedTaskName();
				cservice.getImportedTaskName();
				cservice.getImportedTaskPriority();
				cservice.getImportedTaskStatus();
				cservice.getImportedTaskDescription();

			}

		// @Test(description = "create Leads By Importing CSV File", priority = 0)
			public void createLeadsWithCsvFile() throws InterruptedException, FindFailed {
				cservice.clickonHamBurger();
				cservice.clickAdministartion();
				cservice.clickImportBtn();
				CommonUtils.wait(2);
				cservice.selectEntityTypeLeads();
				cservice.clickChooseFile().clickImportFile().clickOpen().clickCreateOnly().clickNextBtn();
				cservice.selectPhoneNumber().selectEmail().selectStreet().selectCity().selectState().selectPostalCode().selectCountry();
				cservice.clickRunImportBtn();
				CommonUtils.wait(2);
				cservice.clickOnImportedLead();
//				cservice.getImportedLeadName();
//				cservice.getImportedLeadPhoneNumber();
//				cservice.getImportedLeadAccount();
//				cservice.getImportedLeadEmail();
//				cservice.getImportedLeadTitle();
//				cservice.getImportedLeadDscription();
//				cservice.getImportedLeadWebsite();
//				cservice.getImportedLeadAddress();
				cvalidator.validateLeadCsvFile("qpath", cservice);
				
			}
	}
   


    
	 

	
