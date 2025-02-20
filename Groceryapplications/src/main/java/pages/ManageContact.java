package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakeUtility;
import utilities.PageUtility;

public class ManageContact {
	PageUtility page=new PageUtility();
	FakeUtility faker=new FakeUtility();
	public WebDriver driver;
	public ManageContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumber;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//textarea[@id='content' and @placeholder='Enter the Address']")WebElement address;
	@FindBy(xpath="//textarea[@class='form-control' and @placeholder='Enter Delivery Time']")WebElement deliverytime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliverychargelimit;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement updatebutton;
	@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement updatealert;
	public ManageContact clickOnManageContacteditButton()
	{
		editbutton.click();
		return this;
	}
	public ManageContact enterPhoneNumber()
	{
		phonenumber.clear();
		String phone=faker.generatePhoneNumber();
		phonenumber.sendKeys(phone);
		return this;
	}
	public ManageContact enterEmail()
	{
		email.clear();
		String emailaddress=faker.generateEmailAddress();
		email.sendKeys(emailaddress);
		return this;
	}
	public ManageContact enterAddress()
	{
		address.clear();
		String addres=faker.generateAddress();
		address.sendKeys(addres);
		return this;
	}
	public ManageContact enterDeliveryTime()
	{
		deliverytime.clear();
		String time=faker.generateTime();
		deliverytime.sendKeys(time);
		return this;
	}
	public ManageContact enterDeliverychargeLimit()
	{
		deliverychargelimit.clear();
		deliverychargelimit.sendKeys("500");
		return this;
	}
	public ManageContact clickUpdateButton()
	{
		
		page.clickJavaScriptExecutor(updatebutton,driver);
		return this;
	}
	public boolean isAlertDisplayed()
	{
		
		return updatealert.isDisplayed();
		
	}
}
