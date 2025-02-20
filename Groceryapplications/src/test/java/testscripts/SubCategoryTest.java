package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constands.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class SubCategoryTest extends BaseClass {
	//aggregation in java
	LoginPage login;
	HomePage home;
	SubCategoryPage subcategory;
  @Test
  public void verifyAddNewSubcategorywithValidDetails() throws IOException
  {
	  login=new LoginPage(driver);
	 
	home=login.loginUsingExcelData();
	subcategory=home.clickOnSubcategory().clickOnNewSubCategoryButton().clickOnCategoryDropDown().enterSubCategoryField().
			imageupload().clickOnSaveButton();

	  boolean isalertpresent=subcategory.isAlertDisplayed();
	  Assert.assertTrue(isalertpresent,Constants.SCP_VERIFYADDNEWSUBCATEGORY);
	  

  }
  @Test
  public void verifyUsercanSerachNonExistingSubCategory() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  subcategory=home.clickOnSubcategory().clickOnSearcButton().clickOnCategoryDropDownforSearch().enterSubCategoryfieldforSearch().clickOnFinalSearcButton();

	  boolean isnotfoundpresent=subcategory.isResultNotFOundDisplayed();
	  Assert.assertTrue(isnotfoundpresent,Constants.SCP_VERIFYSEARCHNONEXISTINGSUBCATEGORY);
	  

	  
  }
  @Test
  public void verifydeletesubcategorybutton() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  subcategory=home.clickOnSubcategory().isRowDeleted();

 
	  boolean isalertpresent=subcategory.isDeletedAlertDisplayed();
	  Assert.assertTrue(isalertpresent,Constants.SCP_VERIFYDELETESUBCATEGORY);
  }
  @Test
  public void verifyStatusChange() throws IOException
  {
	  login=new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  subcategory=home.clickOnSubcategory().clickactiveButton();

	  
	  boolean isstatuschangepresent=subcategory.isactiveStatuschaneAlertDisplayed();
	  Assert.assertTrue(isstatuschangepresent,Constants.SCP_VERIFYSTATUSCHANGE);
}
}
