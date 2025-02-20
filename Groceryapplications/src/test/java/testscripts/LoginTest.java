package testscripts;

import org.testng.annotations.Test;

import automationcore.BaseClass;
import constands.Constants;
import pages.LoginPage;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginTest extends BaseClass {
	@Test
	  public void verifyUserLoginWithValidCredentials()throws IOException {
		  LoginPage login=new LoginPage(driver); //java page which we use give object for that page is done here
		
		  login.loginUsingExcelData();
		  boolean expectedResult=true;
		  boolean actualResult=login.isHomePageLoaded();
		  Assert.assertEquals(actualResult, expectedResult,Constants.LP_VERIFYLOGINWITHVALIDCREDIANTLS);
	  }
	 @Test(groups="smoke")
	  public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
		  String username="mrudhura";
		  String password="admin";
		  login.enterusernameonusernamefield(username);
		  login.enterPasswordPasswordField(password);
		  login.clickOnLoginButton();
		  //boolean expectedResult=true;
		  boolean actualResult=login.getAlertMessage().contains("Invalid Username/Password");
		  Assert.assertTrue(actualResult,Constants.LP_VERIFYUSERLOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD);
	  }
	 @Test(groups="smoke")
	  public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
		  String username="admin";
		  String password="1iiiiii";
		  login.enterusernameonusernamefield(username);
		  login.enterPasswordPasswordField(password);
		  login.clickOnLoginButton();
		  //boolean expectedResult=true;
		  boolean actualResult=login.getAlertMessage().contains("Invalid Username/Password");
		  Assert.assertTrue(actualResult,Constants.LP_VERIFYUSERLOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD); 
	  }

	  @Test(dataProvider = "dataprovider")
	  public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username,String password) throws IOException
	  {
		  LoginPage login=new LoginPage(driver);
		 // String username="hggggj";
		 // String password="1iiiiii";
		  login.enterusernameonusernamefield(username);
		  login.enterPasswordPasswordField(password);
		 
		  login.clickOnLoginButton();
		  //boolean expectedResult=true;
		  boolean actualResult=login.getAlertMessage().contains("Invalid Username/Password");
		  Assert.assertTrue(actualResult,Constants.LP_VERIFYUSERLOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD); 
	  }
	  @DataProvider(name="dataprovider")
	  public Object[][]dpmethod3(){
	    return new Object[][] 
	      {{"shena","hgh776"},{"hello","gvgh"},{"welc","jhj"},{"yam","hhgh"}};
	  }
	  
	 
}
