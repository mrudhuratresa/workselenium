package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constands.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	CategoryPage category;
  @Test
  public void verifyAddCategorywithValidData() throws IOException {
	  login =new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  category=home.clickOnCategory().clickONnewCategorybutton().enterCategoryField().clickSelectGroup().clickOnSaveButton();

	  category.selectShowonTopMenuRadioButton();
	  category.selectShowonLeftMenuRadioButton();
	  //ca.clickOnSaveButton();
	  boolean isalertpresent=category.isNewCategoryAddAlertPresent();
	  Assert.assertTrue(isalertpresent,Constants.CP_VERIFYNEWCATEGORYWITHVALIDDATA);
  }
  @Test
  public void verifyUsercanSearchNonExistingCategory() throws IOException
  {
	  
		  login =new LoginPage(driver);
		  home=login.loginUsingExcelData();
		  category=home.clickOnCategory().clickOnSearchCategoryButton().enterCategoryFieldforSearch().clickOSearchbutton();

		  boolean isalertpresent=category.isAlertPresent();
			  Assert.assertTrue(isalertpresent,Constants.CP_VERIFYSEARCHWITHNONEXISTINGDATA);
		  
  }
  @Test
  public void verifydeletecategory() throws IOException
  {
	  login =new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  category=home.clickOnCategory().clickODeleteButton();
  
	  boolean isalertpresent=category.isDeleteAlertPresent();
	  Assert.assertTrue(isalertpresent,Constants.CP_VERIFYDELETECATEGORY);
  }
  @Test
  public void verifyStatusButton() throws IOException
  {
	  login =new LoginPage(driver);
	  home=login.loginUsingExcelData();
	  category=home.clickOnCategory().clickOnStatusButton();

	  boolean isalertpresent=category.isStatusAlertPresent();
	  Assert.assertTrue(isalertpresent,Constants.CP_VERIFYSTATUSCHANGE);
  
}
}
