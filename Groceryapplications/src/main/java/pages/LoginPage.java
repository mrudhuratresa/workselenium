package pages;




import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage{
	public WebDriver driver;
	public LoginPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//driver.:initialisation of all webelements of this class
	}
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement signinbutton;
	@FindBy(xpath="//span[@class='brand-text font-weight-light']")WebElement homepage;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertmessage;
	
	public void enterusernameonusernamefield(String username) throws IOException
	{
		usernamefield.sendKeys(username);
		
	}
	public void enterPasswordPasswordField(String password) throws IOException
	{
		passwordfield.sendKeys(password);
	}
	
	public HomePage loginUsingExcelData() throws IOException{
		String username=ExcelUtility. readUsenameData(1,0,"LoginPage");
		usernamefield.sendKeys(username);
		String password=ExcelUtility.readPasswordData(1,1,"LoginPage");
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new HomePage(driver);
	}
	
	
	
	public HomePage clickOnLoginButton()
	{
		signinbutton.click();
		return new HomePage(driver);
	}
	public boolean isHomePageLoaded()
	{
		return homepage.isDisplayed();
		
	}
	public String getAlertMessage()
	{
		return alertmessage.getText();
	}
}

