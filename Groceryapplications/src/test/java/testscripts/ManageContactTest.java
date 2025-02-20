package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constands.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest  extends BaseClass {
	//aggregation in java
		LoginPage login;
		HomePage home;
		ManageContact managecontact;

  @Test
  public void verifyeditManageContact() throws IOException {
	  login=new LoginPage(driver);
	  home= login.loginUsingExcelData();
	  managecontact=home.clickOnManageContactButton().clickOnManageContacteditButton().enterPhoneNumber().enterEmail().enterAddress().
			  enterDeliveryTime().enterDeliverychargeLimit().clickUpdateButton();
//	  login.loginUsingExcelData();
//	  home=new HomePage(driver);
//	  home.clickOnManageContactButton();
//	  managecontact = new ManageContact(driver);
//	  managecontact.clickOnManageContacteditButton();
//	  managecontact.enterPhoneNumber();
//	  managecontact.enterEmail();
//	  managecontact.enterAddress();
//	  managecontact.enterDeliveryTime();
//	  managecontact.enterDeliverychargeLimit();
//	  managecontact.clickUpdateButton();
	  boolean isalertpresent=managecontact.isAlertDisplayed();
	  Assert.assertTrue(isalertpresent,Constants.MCP_VERIFYUPDATEMANAGECONTACT);
	  
  }
  
}
