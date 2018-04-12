package com.crm.services;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.crm.configuration.BaseConfiguration;
import com.crm.data.AccountsData;
import com.crm.objectrepo.Crmor;
import com.crm.utils.CommonUtils;


public class Crmservice extends BaseConfiguration {
	
    private static Logger log = Logger.getLogger(Crmservice.class.getName());
	public Crmor cro = new Crmor();
	public Screen sc = new Screen();
		
	
	public Crmservice  openCrmApplication() {
		invokeBrowser();
		return this;
	}

	public Crmservice loginCrmApplication(String username, String password) throws InterruptedException {
		CommonUtils.wait(1);
		CommonUtils.inserttext("id", cro.getObject().getProperty("crm_login_username_id"), wd, username);
		CommonUtils.inserttext("id", cro.getObject().getProperty("crm_login_password_id"), wd, password);
		CommonUtils.clickButton("id", cro.getObject().getProperty("crm_loginbutton"), wd);
		log.info("login successfully");
		return this;
	}

	public Crmservice getLoginUserAccount() {

		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_dashboard_menu"), wd);
		String uname = CommonUtils.getText("css", cro.getObject().getProperty("crm_dashboard_menu_username"), wd);
		System.out.println(uname);
		return this;
	}

	public Crmservice clickDashboadAccount() throws InterruptedException {
		CommonUtils.wait(1);
		CommonUtils.clickButton("xpath", cro.getObject().getProperty("crm_accounts_module_xpath"), wd);

		return this;
	}
	
   public ArrayList<String> getCreateAccountBillingAdrresss(){
	ArrayList<String> baddress = new  ArrayList<String>();
	
		String billingAddress = CommonUtils.getText("css",cro.getObject().getProperty("created_account_billingaddress"), wd);
		String enteredbillingAddress[]=billingAddress.split(" ");
		String badd[] = enteredbillingAddress[0].split("\n");
		String street = badd[0];
		String city = badd[1];
		String state = enteredbillingAddress[1];
		String badd1[] = enteredbillingAddress[2].split("\n");
		String postal = badd1[0];
		String country = badd1[1];
		baddress.add(street);
		baddress.add(city);
		baddress.add(state);
		baddress.add(postal);
		baddress.add(country);
		
		System.out.println(baddress);
		return baddress;
	
	
}
 boolean copyBillingAddress = false;
	public ArrayList<String> getShipingAddress(){
		String shipaddress = CommonUtils.getText("css", cro.getObject().getProperty("created_account_shippingaddress"), wd);
		 //System.out.println(billingaddress);
		String address[] = shipaddress.split(" ");
		ArrayList<String> saddress = new ArrayList<String>();
		String [] a1 = address;
		String [] a11 = a1[0].split("\n");
		String streetname = a11[0];
		String city = a11[1];
		String state = a1[1];
		String [] a12 = a1[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		
		System.out.println(streetname);
		System.out.println(city);
		System.out.println(state);
		System.out.println(postal);
		System.out.println(country);
		saddress.add(streetname);
		saddress.add(city);
		saddress.add(state);
		saddress.add(postal);
		saddress.add(country);
		System.out.println(saddress);
		copyBillingAddress = true;
		return saddress;
	}
	
	public Crmservice clickCreateAccountBtn() throws InterruptedException {
		CommonUtils.wait(1);
		CommonUtils.clickButton("xpath", cro.getObject().getProperty("crm_accounts_creaateaccount_xpath"), wd);
		CommonUtils.wait(1);
		return this;
	}

	 public Crmservice enterUserAccountDetails(String name , String email, String mobile, String website) throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_accounts_createaccount_name_css"), wd, name);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_accounts_createaccount_email_css"), wd, email);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_accounts_createaccount_phonenumber_css"), wd, mobile);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_accounts_createaccount_website_css"), wd, website);

		return this;

	}


  public Crmservice enterBillingAddress(String street, String city, String state, String postalcode, String country ) {

		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_street_css"), wd, street);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_billingaddress_city_css"),wd, city);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_state_css"), wd, state);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_postal_css"), wd, postalcode);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_country_css"), wd, country);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_copybilling_css"), wd);

		return this;

	}
	
	public Crmservice enterShippingAddress1(String street, String city, String state, String postalcode, String country){
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_street_css"), wd, country);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_billingaddress_city_css"),wd, city);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_state_css"), wd, state);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_postal_css"), wd, postalcode);
		CommonUtils.inserttext("css",cro.getObject().getProperty("crm_billingaddress_country_css"), wd, country);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_copybilling_css"), wd);

		return this;

	}
	

	
	public Crmservice clickSavebutton1() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_accounts_createaccount_savebutton_css"), wd);
		return this;
   }
	
	public Crmservice clickEditButton() {
		CommonUtils.clickButton("xpath", cro.getObject().getProperty("crm_editbutton_xpath"), wd);
	    return this;
	}
	

	public Crmservice clickContactButton() throws InterruptedException {
		CommonUtils.wait(1);
		CommonUtils.clickButton("xpath", cro.getObject().getProperty("crm_dashboard_contacts_xpath"), wd);
		CommonUtils.wait(1);
		return this;
	}
	
	public Crmservice clickCreateContactBtn() throws InterruptedException {
	    CommonUtils.wait(1);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_createcontact_css"), wd);
		CommonUtils.wait(1);
		return this;
	}
	
	public Object nameCheckBox() {
		CommonUtils.selectTheCheckBox("css", cro.getObject().getProperty("crm_actionsnamecheckbox_css"), wd);
		return null;
	}
	
	public void clickonHamBurger() throws InterruptedException{
		CommonUtils.wait(2);
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_hamburger_css"), wd);
    	
    }
   
    public void clickAdministartion(){
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_administration_css"), wd);
    }
    
    public void clickUserInterface(){
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_userinterface_css"), wd);
    }
    
    public void clickDeletesymbol(){
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_crosssymbol_css"), wd);
    }

	public ArrayList<String> getDashboardItemList() throws InterruptedException{
	    	ArrayList<String> list = new ArrayList<String>();
	    	CommonUtils.wait(2);
	    	list= CommonUtils.getItemsFromList("css", cro.getObject().getProperty("crm_dashboard_modules"), wd);
			System.out.println(list);
	    	 return list;
	    			
	}

	public String getCreatedAccountUserName() {
		String txt = CommonUtils.getText("css", cro.getObject().getProperty("account_created_username"), wd);	
		System.out.println(txt);
		return txt;

	}

	public Crmservice clickExistingNameLink(String username) throws InterruptedException {
		CommonUtils.clicklink("css", cro.getObject().getProperty("crm_existingaccount_firstusername"), wd);
		String uname = getFirstUserName();
		if (username.equals(uname)) {
			CommonUtils.clickButton("css", cro.getObject().getProperty("crm_existingaccount_firstusername"), wd);
		}

		else {
			System.out.println("invalid username");
		}
		return this;
	}

	public String getFirstUserName() throws InterruptedException {
		CommonUtils.wait(1);
		String uname = CommonUtils.getText("css", cro.getObject().getProperty("crm_existingaccount_firstusername"), wd);
		return uname;
	}

	public String getExistingUserName() {
		String uname = CommonUtils.getText("css", cro.getObject().getProperty("crm_existingaccount_username_css"), wd);
		System.out.println(uname);
		return uname;
	}

	public String getCreatedAccountMobileNumber() {
		String mobilenumber = CommonUtils.getText("css", cro.getObject().getProperty("created_account_mobilenumber"),
				wd);
		System.out.println(mobilenumber);
		return mobilenumber;
	}

	public String getCreatedAccountEmailAddress() {
		String emailaddress = CommonUtils.getText("css", cro.getObject().getProperty("created_account_emailaddress"),
				wd);
		System.out.println(emailaddress);
		return emailaddress;
	}

	public String getCreatedAccountWebsite() {
		String website = CommonUtils.getText("css", cro.getObject().getProperty("created_account_website"), wd);
		System.out.println(website);
		return website;
	}

	
	public ArrayList<String> getShipingAddress1() {
		String billingaddress = CommonUtils.getText("css",
				cro.getObject().getProperty("created_account_billingaddress"), wd);
				System.out.println(billingaddress);
				return getShipingAddress();
		
	}

	
	public Crmservice removeCalendarFromTabList() throws InterruptedException{
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_dashboard_menubar_administration_userinterface_removecalender"), wd);
		return this;
	}

    public Crmservice pageRefresh(){
    	CommonUtils.refresh(wd);
    	return this;
   	
       }

	
	
	//CREATE ROLES
	
	
    public Crmservice clickDashboardMenuBar1() throws InterruptedException{
    	CommonUtils.wait(1);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_hamburger_css"), wd);
		return this;
	}

	public Crmservice clickOnAdministrationInMenu(){
		CommonUtils.clicklink("css", cro.getObject().getProperty("crm_administration_css"), wd);
		return this;
	}
	
	public Crmservice clickOnRoles() throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_menu_admini_roles"), wd);
		return this;
	}
	
	public Crmservice clickCreateRole() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_roles_create"), wd);
		return this;
	}
	
	public Crmservice enterRname(String name) throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_createrole_name"), wd, name);
		return this;
	}
	
	public Crmservice selectDropDownEportPermission(String exportpermisson) {
		System.out.println("yes");
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_createrole_exportpermission"), "value", exportpermisson, wd);
		return this;
	}
	
	public Crmservice selectDropDownUserPermission(String userpermission) {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_createrole_userpermission"), "value", userpermission, wd);
		return this;
	}
	
	public Crmservice slectDropDownPortalPermission(String assignmentpernission) {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_createrole-portalpermission"), "value", assignmentpernission, wd);
		return this;
	}
	
	public Crmservice selectDropDownEmailPermission(String emailpermission) {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_createrole-emailpermission"), "value", emailpermission, wd);
		return this;
	}
	
	public Crmservice slectDropDownAssignmentPermission(String assignmentpernission) {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_createrole-assignmentpermission"), "value", assignmentpernission, wd);
		return this;
	}

	
	//Validation methods
	
	public String getCreatedRName() {
		String rname = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createdrolename"), wd);
		System.out.println(rname);
		return rname;
	}
	
	public String getCreatedExpper() {
		String expper = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createdexpper"), wd);
		return expper;
	}
	
	public String getCreatedUserPer() {
		String userper = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createduserper"), wd);
		return userper;
	}
	
	public String getCreatedAssiPer() {
		String assignper = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createdassgperm"), wd);
		return assignper;
	}
	
	public String getCreatedPortPer() {
		String portper = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createdportper"), wd);
		return portper;
	}
	
	public String getCreatedEmailPer() {
		String remail = CommonUtils.getText("css", cro.getObject().getProperty("crn_roles_createdemailper"), wd);
		return remail;
	}
	
	 public Crmservice clickOnUserInterfaceLink() throws InterruptedException{
    	CommonUtils.wait(2);
		CommonUtils.clicklink("css", cro.getObject().getProperty("crm_userinterface_css"), wd);
		return this;
	}
    
    public String getFirstTextFromTabList() throws InterruptedException{
    	CommonUtils.wait(1);
       String getfirsttext	= CommonUtils.getText("css", cro.getObject().getProperty("crm_getfirstitemfromtablist"), wd);
       System.out.println(getfirsttext);
    	 return getfirsttext;
     }
    
    public Crmservice clickonDeleteSymbol(){
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_deletesymbol_css"), wd);
		return this;
    }
    
    public Crmservice clickOnAddButton() {
    	CommonUtils.doubleClick("css", cro.getObject().getProperty("crm_addbutton1"), wd);
    	return this;
    }
    
    public Crmservice clickAddInAdd() {
    	CommonUtils.clickButton("css", cro.getObject().getProperty("crm_add_add"), wd);
    	return this;
    }
    
    public ArrayList<String> getItemFromEspoDashboardList(){
    	
    	ArrayList<String> dashboardListItems = new ArrayList<String>();
    	dashboardListItems  = CommonUtils.getItemsFromList("css", cro.getObject().getProperty("crm_dashboardlist"), wd);
    	System.out.println(dashboardListItems);
    	return dashboardListItems;
    }

	 public String getTextCalenderFromTabList(){
    	String removeCalender = CommonUtils.getText("css", cro.getObject().getProperty("crm_dashboard_menubar_administration_userinterface_getextofcalender"), wd);
		System.out.println(removeCalender);
    	return removeCalender;
    }	
	
	public Crmservice editDropDown() {
		CommonUtils.selectDropDownItem("css",
				cro.getObject().getProperty("crm_accounts_createaccount_editbuttondropdown_css"), "String", "Remove",
				wd);
		return this;
	}

	public Crmservice nameCheckBox1() {
		CommonUtils.radiobutton("css", cro.getObject().getProperty("crm_accounts_module_actionsnamecheckbox_css"), wd);
		return this;
	}

	public Crmservice actionsButton() {

		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_accounts_module_actions_css"), wd);
		return this;

	}

	public Crmservice actionsButtonremove() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_accounts_module_actions_remove_css"), wd);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_accounts_module_actions_removealert_css"), wd);
		return this;
	}


	public boolean checkHomePageHeader() {
		return CommonUtils.isElementPresent("css", cro.getObject().getProperty("homepageheader"), wd);
	}
	
	public Crmservice clickexistinguser() throws InterruptedException{
		
		return this;
	}
	
	public Crmservice clickOnContactsEditButton() throws InterruptedException{
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contacts_editbutton_css"), wd);
		return this;
	}
	
	public Crmservice enterEditContactDetails(String name,String firstname,String lastname,String email,String phone, String street,String city, String state, String postalcode, String country, String description){
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contact_name_css"), wd, name );
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contact_firstname_css"), wd, firstname);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contact_lastname_css"), wd, lastname );
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_email_css"), wd, email);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_phone_css"), wd, phone);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_address_street_css"), wd, street);
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_city_xpath"), wd, city);
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_state_xpath"), wd, state);
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_postalcode_xpath"), wd, postalcode);
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_country_xpath"), wd, country);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_description_css"), wd, description);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contacts_save_css"), wd);
		return this;
	}
	
	public Crmservice clearExistingdata(){
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contact_name_css"), wd);
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contact_firstname_css"), wd);
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contact_lastname_css"), wd);
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contacts_email_css"), wd);
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contacts_phone_css"), wd);
		CommonUtils.clearText("css", cro.getObject().getProperty("crm_contacts_address_street_css"),wd);
		CommonUtils.clearText("xpath", cro.getObject().getProperty("crm_contacts_address_city_xpath"), wd);
		CommonUtils.clearText("xpath", cro.getObject().getProperty("crm_contacts_address_state_xpath"), wd);
		CommonUtils.clearText("xpath", cro.getObject().getProperty("crm_contacts_address_postalcode_xpath"), wd);
		CommonUtils.clearText("xpath", cro.getObject().getProperty("crm_contacts_address_country_xpath"), wd);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contactss_save_css"), wd);
		return this;
	}
	

	public Crmservice clickContactsInDashboard() throws InterruptedException{
		CommonUtils.wait(1);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_dashboard_contacts_css"), wd);
		return this;
	}
	
	public Crmservice clickCreateContact() throws InterruptedException{
		CommonUtils.wait(1);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_createcontact_css"), wd);
		return this;
	}

	public Crmservice enterSalutationName() throws InterruptedException{
		CommonUtils.wait(1);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_contact_name_css"), "value", "Mr." , wd);
		return this;
	}
	
	public Crmservice enterContactFirstName(String firstname){	
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contact_firstname_css"), wd, firstname);
		return this;
	}
	
	public Crmservice enterContactLastName(String lastname){	
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contact_lastname_css"), wd, lastname);
		return this;
	}
	
	public Crmservice selectaccount(String account){
		CommonUtils.clicklink("xpath", cro.getObject().getProperty("crm_contacts_accounts_uparrow_xpath"), wd);
		return this;
	}
	
	public Crmservice selectexistinguser() throws InterruptedException{
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contacts_existinguser_css"), wd);
		return this;
	}
	
	public Crmservice clickSelectButton(){
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contacts_selectbutton_css"), wd);
		return this;
	}
	
	public Crmservice enterContactEmail(String email){
		
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_email_css"), wd, email);
		return this;
	}
	
	public Crmservice enterContactPhoneNumber(String phoneNumber) throws InterruptedException{
		CommonUtils.wait(1);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_phone_css"), wd, phoneNumber);
		return this;
	}
	
	public Crmservice enterContactStreet(String street){
		
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_address_street_css"), wd, street);
		return this;
	}
	
	public Crmservice enterContactCity(String city){
		
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_city_xpath"), wd, city);
		return this;
	}
	
	public Crmservice enterContactState(String state){
		
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_state_xpath"), wd, state);
		return this;
	}
	
	public Crmservice enterContactPostalCode(String postalcode){
	   	
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_postalcode_xpath"), wd, postalcode);
		return this;
	}
	
	public Crmservice enterContactCountry(String country){
		
		CommonUtils.inserttext("xpath", cro.getObject().getProperty("crm_contacts_address_country_xpath"), wd, country);
		return this;
	}
	
	public Crmservice clickSavebutton() throws InterruptedException{
		CommonUtils.wait(4);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_contacts_save_css"), wd);	
		CommonUtils.wait(4);
		//log.info("account created succesfully");
		return this;
	}

	public void enterContactDescription(String description) {
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_contacts_description_css"), wd, description);
	}
	public String createdContactEmail(){
		String email = CommonUtils.getText("css", cro.getObject().getProperty("crm_contacts_created_email"), wd);
		return email;
	}
	public String createdContactPhone(){
		String phone = CommonUtils.getText("css", cro.getObject().getProperty("crm_dashboard_created_phone"), wd);
		return phone;
	}
	public String createdContactwwebsite(){
		String website = CommonUtils.getText("css", cro.getObject().getProperty("created_account_website"), wd);
		return website;
	}
	public String createdContactstreet(){
		String street = CommonUtils.getText("css", cro.getObject().getProperty("crm_contacts_address_street_css"), wd);
		return street;
	}
	public String createdContactspostalcode(){
		String street = CommonUtils.getText("css", cro.getObject().getProperty("crm_contacts_address_postalcode_xpath"), wd);
		return street;
	}

	public List<AccountsData> getItemInTabList() {
		String item = CommonUtils.getText("css", cro.getObject().getProperty("crm_getitemfromlist_position"), wd);
		return null;
	}
    

	//CREATING OPPORTUNITIES
	
	public Crmservice clickOpportunitiesInDashboard() throws InterruptedException{
		CommonUtils.wait(1);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_dashboard_opportunities"), wd);
		return this;
	}
	
	public void clickCreateOpportunities() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_createopportunities"), wd);
	}
	
	public Crmservice enterOpportunitiesName(String name) throws InterruptedException{	
		CommonUtils.wait(1);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_createopportunities_name"), wd, name );
		return this;
	}
	
	public Crmservice clickUparrowButton(String account){
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_oppoaccount_uparrow"), wd);
		return this;
	}
	
	public Crmservice clickSelectButton1(){
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_opportunities_selectbutton_css"), wd);
		return this;
	}

	public Crmservice selectExistingUser1(String oppoExixtingAccount) throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_oppo_existinguser"), wd);
		return this;
	}
    
	public Crmservice clickButton(String oppoDropDown) {
		CommonUtils.clickButton("css" ,cro.getObject().getProperty("crm_oppo_stage_dropdown"), wd);
		return this;
	}

	public Crmservice selectDropDown(String oppoDropDown) {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_oppo_stage_Prospecting"), "Prospecting", "value", wd);
		return this;
	}
	
	public Crmservice enterOppoAmount(String value) {
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_oppo_amount"), wd, value);
		return this;
	}
	
	public Crmservice enterProbability(String value) {
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_oppo_probability"), wd, value);
		return this;
	}
	
	public Crmservice enteroppoDate(String date) {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_oppo_date"), wd);
		return this;
	}
	
	public Crmservice enterCloseDate() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_oppo_closedate"), wd);
		return this;
	}
	
	public Crmservice clickContUparrowButton(String account){
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_oppo_cont_uparrow"), wd);
		return this;
	}
	
	public Crmservice clickCheckBox(String oppoCheckBox) throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_exitcont_ckeckbox"), wd);
		return this;
	}
	
	public Crmservice clickContSelectButton() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_cont_selectbutton"), wd);
		return this;
	}
	
	public Crmservice enterLoadSource() throws InterruptedException{
		CommonUtils.wait(2);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_loadsource"), "value", "Call", wd);
		return this;
	}
	
	//validation methods
	
	public Crmservice enterOppoDescription(String description) throws InterruptedException{
		CommonUtils.wait(2);
		CommonUtils.inserttext("css", cro.getObject().getProperty("crm_oppo_description"), wd, description);
		return this;
	}
	
	public String getCreatedOppoName(){
		String opponame = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_name"), wd);
		return opponame;
	}
	
	public String getCreatedAccount(){
		String oppoaccount = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_account"), wd);
		return oppoaccount;
	}
	
	public String getCreatedOppoStage(){
		String oppostage = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_stage"), wd);
		return oppostage;
	}
	
	public String getCreatedOppoAmount(){
		String oppoamount = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_amount"), wd);
		System.out.println(oppoamount);
		String []amount = oppoamount.split("$");
		return oppoamount;
	}
	
	public String getCreatedLoadSource(){
		String oppoloadsource = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_loadsource"), wd);
		return oppoloadsource;
	}
	
	public String getCreatedOppodescription(){
		String oppodescription = CommonUtils.getText("css", cro.getObject().getProperty("crm_createdoppo_description"), wd);
		return oppodescription;
	}
	
	
	//CREATING LEADS 

		public Crmservice clickOnDashboardLead(){
			CommonUtils.clickButton("css", cro.getObject().getProperty("login_dashboard_leads"), wd);
			return this;
		}
		
		public Crmservice clickOnCreateLead(){
			CommonUtils.clickButton("css", cro.getObject().getProperty("login_dashboard_createlead"), wd);
			return this;
		}
		
		public Crmservice enterLeadDetails(String firstname, String lastname,String accountname, String email, String phonenumber, String leadTitle) throws InterruptedException{
			CommonUtils.wait(2);
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_leads_salutationNamedd"), "value",	"Mr.", wd);
			CommonUtils.wait(1);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_firstname"), wd, firstname);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_lastname"), wd, lastname);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_accountname"), wd, accountname);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_email"), wd, email);
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("login_leads_createlead_phonedd"), "Mobile", "value" ,wd);
			CommonUtils.inserttext("css", cro.getObject().getProperty("login_leads_createlead_phonetab"), wd, phonenumber);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_title"), wd, leadTitle);
			CommonUtils.clickRadioButton("css", cro.getObject().getProperty("login_leads_createlead_donotcal"), wd);
			return this;
		}
		
		public Crmservice enterLeadAddressDetails(String street, String city, String state, String postalcode, String country){
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_street"), wd, street );
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_city"), wd, city);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_state"), wd, state );
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_postalcode"), wd, postalcode);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_country"), wd, country);
			return this;
		}
		
		public Crmservice enterLeadWebsite(String website){
			CommonUtils.inserttext("css", cro.getObject().getProperty("login_leads_createlead_website"), wd, website);
			return this;
		}
		
		public Crmservice clickSaveButtonAfterEnteringLeadDetails() throws InterruptedException{
			CommonUtils.clickButton("css", cro.getObject().getProperty("login_leads_createlead_save"), wd);
			return this;
		}
		
		public Crmservice enterLeadDetailsFields(String opportunityamount, String description ){
			CommonUtils.selectDropDownItem("css",  cro.getObject().getProperty("login_leads_createlead_details_status"), "value", "Assigned",  wd);
			CommonUtils.selectDropDownItem("css",  cro.getObject().getProperty("login_leads_createlead_details_source"),  "value" ,"Call", wd);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_details_opportunityamount"), wd, opportunityamount);
			CommonUtils.selectDropDownItem("css",  cro.getObject().getProperty("login_leads_createlead_details_industry"), "value" ,"Advertising", wd);
			CommonUtils.inserttext("css",  cro.getObject().getProperty("login_leads_createlead_details_description"), wd, description);
			return this;
		}
	
	//validation methods
	
		public String getExistingLeadName() {
			String firstname = CommonUtils.getText("css", cro.getObject().getProperty("crm_leads_exituser"), wd);
			System.out.println(firstname);
			return firstname;
		}
		
		public String getExistingLeadAccount() {
			String account = CommonUtils.getText("css", cro.getObject().getProperty("crm_leads_createdaccount"), wd);
			return account;
		}
		
		public ArrayList<String> getCreatedLeadNameList(){
	  		String leadnamelist = CommonUtils.getText("css", cro.getObject().getProperty("getcontact_name"), wd);
	  		ArrayList<String> leadname = new ArrayList<String>();
	  		String[] lname = leadnamelist.split(" ");
	  		String name = lname[0];
	  		String firstname = lname[1];
	  		String lastname = lname[2];
	  		leadname.add(name);
	  		leadname.add(firstname);
	  		leadname.add(lastname);
	  		System.out.println(leadname);
	  		return leadname;
	  		}
	  	
	  	public String getCreatedLeadEmail(){
	  		String contactemail = CommonUtils.getText("css", cro.getObject().getProperty("getcontact_email"), wd);
	  		System.out.println(contactemail);
	  		return contactemail;
	  	}
	 	
	  	public String getCreatedLeadPhone(){
	  		String contactphone = CommonUtils.getText("css", cro.getObject().getProperty("getcontact_phone"), wd);
	  		System.out.println(contactphone);
	  		return contactphone;
	  	}
	  	
	  	public String getCreatedLeadWebsite() {
	  		String leadwebsite = CommonUtils.getText("css", cro.getObject().getProperty("crm_createlead_website"), wd);
	  		System.out.println(leadwebsite);
	  		return leadwebsite;
	  	}
		
		//CREATE TASK
		
		public Crmservice clickDashboardTask() {
			CommonUtils.clickButton("css", cro.getObject().getProperty("login_dashboard_task"), wd);
			return this;
		}
		
		public Crmservice clickDashboardCreateTask() throws InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.clickButton("css", cro.getObject().getProperty("login_task_createtask"), wd);
			return this;
		}
		
		public Crmservice enterTaskName(String taskname) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_name"), wd, taskname);
			return this;
		}
		
		public Crmservice enterParentAccount(String parentaccount) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_account_parent"), wd, parentaccount);
			return this;
		}
		
		public Crmservice clickUpArrowButton() {
			CommonUtils.clickButton("css", cro.getObject().getProperty("task_createtask_uparrowbutton"), wd);
			return this;
		}
		
		public Crmservice clickTaskExistingUser(String exituser) throws InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.clickButton("css", cro.getObject().getProperty("task_createtask_existinguser_css"), wd);
			return this;
		}
		
		public Crmservice clickStatusButton() {
			CommonUtils.clickButton("css", cro.getObject().getProperty("task_createtask_status_button"), wd);
			return this;
		}
		
		public Crmservice enterTaskStatus(String taskstatus) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_status"), wd, taskstatus);
			return this;
		}
		
		public Crmservice enterTaskPriority(String priority) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_priority"), wd, priority);
			return this;
		}
		
		public Crmservice enterTaskDateStart(String taskdatestart) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_datestart"), wd, taskdatestart);
			return this;
		}
		
		public Crmservice enterTaskDateDue(String taskdatedue) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_datedue"), wd, taskdatedue);
			return this;
		}
		
		public Crmservice enterDescription(String description) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_description"), wd, description);
			return this;
		}
		
		public Crmservice enterTaskAssignUser(String assignuser) {
			CommonUtils.inserttext("css", cro.getObject().getProperty("task_createtask_assignuser"), wd, assignuser);
			return this;
		}
		
		//Validation methods
		
		public String getExistingTaskName() {
			String existingtask = CommonUtils.getText("css", cro.getObject().getProperty("task_exitstingtask"), wd);
			return existingtask;
		}
		
		public String getExistingParent() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitparent"), wd);
			return existingtaskp;
		}
		
		public String getExitStatus() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitstatus"), wd);
			System.out.println(existingtaskp);
			return existingtaskp;
		}
		
		public String getExitPriority() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitPriority"), wd);
			return existingtaskp;
		}
		
		public String getExitDateStart() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitdatestart"), wd);
			return existingtaskp;
		}
		
		public String getExitDateDue() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitdatedue"), wd);
			return existingtaskp;
		}
		
		public String getExitDescription() {
			String existingtaskp = CommonUtils.getText("css", cro.getObject().getProperty("task_exitdescription"), wd);
			return existingtaskp;
		}

		public String getExistingParentAccount() {
			String exitpatentaccount = CommonUtils.getText("css", cro.getObject().getProperty("task_exitdescription"), wd);
			return exitpatentaccount;
		}

		public boolean isBillingAddressCopied() {
			// TODO Auto-generated method stub
			return false;
		}

		public Crmservice navigateToHomePage() throws FindFailed  {
			sc.click("src//test//resources//appimages//account.png");
			sc.click("src//test//resources//appimages//addfield.png");
			sc.click("src//test//resources//appimages//asigned user.png");
			sc.click("src//test//resources//appimages//addfield.png");
			sc.click("src//test//resources//appimages//billingaddress.png");
			sc.click("src//test//resources//appimages//addfield.png");
			sc.click("src//test//resources//appimages//description.png");
			sc.click("src//test//resources//appimages//addfield.png");
			sc.click("src//test//resources//appimages//industry.png");
			return this;
		}
		
		public Crmservice clickImportBtn() throws InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.clickButton("css", cro.getObject().getProperty("import_administration"), wd);
			return this;
		}

		public Crmservice selectDropDownContact() throws InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.clickButton("css", cro.getObject().getProperty("import_contacts"), wd);
			return this;
		}
		
		public Crmservice clickChooseFile() throws FindFailed {
			sc.click("src//test//resources//appiamgecontacts//choosefile.png");
			return this;
		}
		
		public Crmservice clickImportFile() throws FindFailed {
			sc.click("src//test//resources//appiamgecontacts//csvfile.png");
			return this;
		}
		
		public Crmservice clickOpen() throws FindFailed {
			sc.click("src//test//resources//appiamgecontacts//open.png");
			return this;
		}
		
		public Crmservice clickCreateOnly() throws FindFailed, InterruptedException {
			CommonUtils.wait(1);
			sc.click("src//test//resources//appiamgecontacts//createonly2.png");
			return this;
		}
		
		public Crmservice clickNextBtn() {
			CommonUtils.clickButton("css", cro.getObject().getProperty("import_next_button"), wd);
			return this;
		}
		
		public Crmservice selectPhoneNumber() throws FindFailed, InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.selectDropDownItem("id", cro.getObject().getProperty("import_cont_phone"), "value","phoneNumberMobile",  wd);
			return this;
		}
		
		public Crmservice selectEmail() throws FindFailed, InterruptedException {
			CommonUtils.wait(2);
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_email"), "value", "emailAddress", wd);
			return this;
		}
		
		public Crmservice selectStreet() throws FindFailed {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_street"), "value", "addressStreet", wd);
			return this;
		}
		
		public Crmservice selectCity() throws FindFailed {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_city"), "value", "addressCity" , wd);
			return this;
		}
		
		public Crmservice selectState() throws FindFailed {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_state"), "value", "addressState",  wd);
			return this;
		}
		
		public Crmservice selectPostalCode() throws FindFailed {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_postalcode"), "value", "addressPostalCode", wd );
			return this;
		}
		
		public Crmservice selectCountry() throws FindFailed {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_cont_county"), "value", "addressCountry", wd);
			return this;
		}
		
		public Crmservice clickRunImportBtn() {
			CommonUtils.clickButton("css", cro.getObject().getProperty("run_import_btn"), wd);
			return this;
		}
		
		public Crmservice clickImportContact() {
			return this;
			
		}
		

		//creating task with CSV file
	
	public Crmservice selectEntityTypeTasks() throws InterruptedException {
		CommonUtils.clickButton("css", cro.getObject().getProperty("import_lead"), wd);
		//CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_lead"), "value", "Lead", wd);
		return this;
		}
	
	public Crmservice fillTasksDetails() throws InterruptedException{
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_tasks_parent"),  "value", "assignedUserName", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_field_status"),  "value", "status", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_field_priority"),  "value", "priority", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_field_datestart"),  "value", "dateStartDate", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_field_datedue"),  "value", "dateEndDate", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_field_desc"),  "value", "description", wd);
		return this;
		}
	
	public ArrayList<String> getCreatedContactDetails(){    ///////// all created contact methods are kept in an arraylist
		ArrayList<String> contactDetails =  new ArrayList<String>();
		contactDetails.add(getImportedContactName());
		contactDetails.add(getImportedContactEmail());
		contactDetails.add(getImportedContactPhone());
		contactDetails.addAll(getImportedContactAddress());
		return contactDetails;
		
	}
	
	public ArrayList<String> getCreatedContactDetailsOfDb(){    ///////// all created contact methods are kept in an arraylist
		ArrayList<String> contactDetails =  new ArrayList<String>();
		contactDetails.add(getImportedContactName());
	//	contactDetails.add(getCreatedContactEmailAddress());
	//	contactDetails.add(getCreatedContactMobileNumber());
		contactDetails.addAll(getImportedContactAddress());
		return contactDetails;
		
	}

	//creating leads with CVS file
	
	public Crmservice selectEntityTypeLeads() throws InterruptedException {
			CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("import_lead"), "value", "Lead", wd);
			return this;
		}
	
	public Crmservice enterFieldDetails() throws InterruptedException{
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_firstname"), "firstName", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_lastname"), "lastName", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_accountname"), "accountName", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_email"), "emailAddress", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_phone"), "phoneNumberMobile", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_title"), "title", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_street"), "addressStreet", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_city"), "addressCity", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_state"), "addressState", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_postalcode"), "addressPostalCode", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_country"), "addressCountry", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_website"), "website", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("ham_admin_leads_desc"), "description", "value", wd);
		return this;
		}
	
	public Crmservice clickOnRunImport() throws InterruptedException{
		CommonUtils.clickButton("css", cro.getObject().getProperty("ham_field_runimport"), wd);
		return this;
	}
	
	
	public Crmservice clickOnImportedContact() throws InterruptedException{
		CommonUtils.clickButton("css", cro.getObject().getProperty("ham_admin_field_importedcont"), wd);
		return this;
	}
	
	public Crmservice clickOnImportedTask() throws InterruptedException{
		CommonUtils.clickButton("css", cro.getObject().getProperty("ham_admin_field_imptaskname"), wd);
		return this;
	}
	
	public Crmservice clickOnImportedLead() throws InterruptedException{
		CommonUtils.clickButton("css", cro.getObject().getProperty("ham_admin_field_importedlead"), wd);
		return this;
	}
	
	public String getImportedLeadName(){
		String impLeadName= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadname"), wd);
		System.out.println(impLeadName);
		return impLeadName;
	}
	
	public String getImportedLeadEmail(){
		String impLeadEmail= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleademail"), wd);
		System.out.println(impLeadEmail);
		return impLeadEmail;
	}
	
	public String getImportedLeadAccount(){
		String impLeadAccount= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadaccount"), wd);
		System.out.println(impLeadAccount);
		return impLeadAccount;
	}
	
	public String getImportedLeadPhoneNumber(){
		String impLeadPhone= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadphone"), wd);
		System.out.println(impLeadPhone);
		return impLeadPhone;
	}
	
	public String getImportedLeadWebsite(){
		String impLeadWebsite= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadwebsite"), wd);
		System.out.println(impLeadWebsite);
		return impLeadWebsite;
	}
	
	public String getImportedLeadTitle(){
		String impLeadTitle= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadtitle"), wd);
		System.out.println(impLeadTitle);
		return impLeadTitle;
	}
	
	public String getImportedLeadDscription(){
		String impLeadDesc= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleaddescription"), wd);
		System.out.println(impLeadDesc);
		return impLeadDesc;
	}
	
	public String getImportedContactName(){
		String impConName= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimpname"), wd);
		System.out.println(impConName);
		return impConName;
	}
	
	public String getImportedContactEmail(){
		String impConEmail= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimpemail"), wd);
		System.out.println(impConEmail);
		return impConEmail;
	}
	
	public String getImportedContactPhone(){
		String impConPhone= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimpphone"), wd);
		System.out.println(impConPhone);
		return impConPhone;
	}
	
	public String getImportedTaskName(){
		String impTaskName= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_gettaskname"), wd);
		System.out.println(impTaskName);
		return impTaskName;
	}
	
	public String getImportedTaskStatus(){
		String impTaskStatus= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_gettaskstatus"), wd);
		System.out.println(impTaskStatus);
		return impTaskStatus;
	}
	
	public String getImportedTaskPriority(){
		String impTaskPriority= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_gettaskpriority"), wd);
		System.out.println(impTaskPriority);
		return impTaskPriority;
	}
	
		
	public String getImportedTaskDescription(){
		String impTaskDesc= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_gettaskdesc"), wd);
		System.out.println(impTaskDesc);
		return impTaskDesc;
	}
	
	public ArrayList<String> getImportedContactAddress(){
		String impConAddress = CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getconaddress"), wd);
		List<String> list =new ArrayList<String>();
		String biaddressxml[] = impConAddress.split(" ");
		System.out.println(biaddressxml.length);
		for (int i =0;i<biaddressxml.length; i++){
			Scanner scanner = new Scanner(biaddressxml[i]);
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				System.out.println(line);
				list.add(line);
			}
		}
		return (ArrayList<String>) list;
	}
	
	public List<String> getImportedLeadAddress(){
		String impLeadAddress= CommonUtils.getText("css", cro.getObject().getProperty("ham_field_getimmleadaddress"), wd);
		List<String> list = new ArrayList<String>();
		String impleadadd[] = impLeadAddress.split(" ");
		System.out.println(impleadadd.length);
		for(int i=0;i<impleadadd.length;i++){
			Scanner scanner = new Scanner(impleadadd[i]);
			while (scanner.hasNextLine()){		
			String line =scanner.nextLine();
			System.out.println(line);	
			list.add(line);
			}
		}
	return list;
	}
	
	public Crmservice createTasksWithCsvFile() throws FindFailed  {
		sc.click("src//test//resources//contactcsv//choosefile.png");
		sc.click("src//test//resources//Tasks//select tasks.png");
		sc.click("src//test//resources//contactcsv//open.png");
		return this;	
	}
	
	public Crmservice createLeadsWithCsvFile() throws FindFailed  {
		sc.click("src//test//resources//contactcsv//choosefile.png");
		sc.click("src//test//resources//Leads//clickleads.png");
		sc.click("src//test//resources//contactcsv//open.png");
		return this;	
	}

	
	public Crmservice selectLeadEntityTypeDD() {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_entitydd"), "Lead", "value", wd);
		return this;
	}
	
	public Crmservice chooseLeadCsvFile() throws FindFailed {
		sc.click("src//test//resources//CreatingContactImages//chosefile.png");
		sc.type("src//test//resources//CreatingContactImages//Filenametb.png", "leads.csv");
		sc.click("src//test//resources//CreatingContactImages//clickopen.png");
		return this;
	}
	
	public Crmservice selectLeadFieldValues() {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadsemaildd"), "emailAddress", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadsphonedd"), "phoneNumberMobile", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadstitledd"), "title", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadsstreetdd"), "addressStreet", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadscitydd"), "addressCity", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadsstatedd"), "addressState", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadspostalcodedd"), "addressPostalCode", "value", wd);
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_nextbutton_leadscountrydd"), "addressCountry", "value", wd);
		return this;
	}
	
//CREATING TASKS USING CSV FILE
	
	public Crmservice clickOnDashboardTasks() {
		CommonUtils.clicklink("css", cro.getObject().getProperty("login_dashboard_tasks"), wd);
		return this;
	}
	
	
	public Crmservice selectTasksEntityTypeDD() {
		CommonUtils.selectDropDownItem("css", cro.getObject().getProperty("crm_menubar_administration_import_entitydd"), "Task", "value", wd);
		return this;
	}
	
	public Crmservice chooseTasksCsvFile() throws FindFailed {
		sc.click("src//test//resources//CreatingContactImages//chosefile.png");
		sc.type("src//test//resources//CreatingContactImages//Filenametb.png", "tasks.csv");
		sc.click("src//test//resources//CreatingContactImages//clickopen.png");
		return this;
	}
	
	public Crmservice clickTaskNextButton() {
		CommonUtils.clickButton("css", cro.getObject().getProperty("crm_menubar_administration_import_tasknextbutton"), wd);
		return this;
	}
	
	
//VALIDATING TASKS PAGE OBJECTS
	
	public String getCreatedTaskName() {
		String taskname = CommonUtils.getText("css", cro.getObject().getProperty("getcreatedtask_name"), wd);
		System.out.println(taskname);
		return taskname;
	}
	
	public String getCreatedTaskStatus() {
		String taskstatus = CommonUtils.getText("css", cro.getObject().getProperty("getcreatedtask_status"), wd);
		System.out.println(taskstatus);
		return taskstatus;
	}
	
	public String getCreatedTaskPriority() {
		String taskpriority = CommonUtils.getText("css", cro.getObject().getProperty("getcreatedtask_priority"), wd);
		System.out.println(taskpriority);
		return taskpriority;
	}
	
	public String getCreatedTaskDescription() {
		String taskdescription = CommonUtils.getText("css", cro.getObject().getProperty("getcreatedtask_priority"), wd);
		System.out.println(taskdescription);
		return taskdescription;
	}
	
	public ArrayList<String> getCreatedTaskDetails() throws InterruptedException {
		ArrayList<String> taskinfo = new ArrayList<String>();
		taskinfo.add(getCreatedTaskName());
		taskinfo.add(getCreatedTaskStatus());
		taskinfo.add(getCreatedTaskPriority());
		taskinfo.add(getCreatedTaskDescription());
		return taskinfo;
	}

	
}

		
		
	

	
	
