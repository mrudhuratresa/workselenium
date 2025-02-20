package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constands.Constants;
import utilities.FakeUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	FakeUtility faker=new FakeUtility();
	
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newsubcategorybutton;
	@FindBy(xpath="//select[@id='cat_id']")WebElement categorydropdown;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategoryfield;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement subcategorysearchbutton;
	@FindBy(xpath="//select[@id='un']")WebElement categorydropdownforsearch;
	@FindBy(xpath="//input[@class='form-control']")WebElement subcategoryfieldforsearch;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement finalsearchbutton;
	@FindBy(xpath="//span[@id='res']")WebElement resultnotfound;
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del=2425&page_ad=1']")WebElement deletebutton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement deletebutton;
	@FindBy(xpath="//span[@id='res']")WebElement deletedalert;	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deletedconfirmationalert;
	@FindBy(xpath="//span[@class='badge bg-success']")WebElement activestatus;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement activestatuschangealert;
	@FindBy(xpath="//input[@id='main_img']")WebElement imageupload;
	//input[@id='main_img']
	

 public SubCategoryPage clickOnNewSubCategoryButton()
 {
	 newsubcategorybutton.click();
	 return this;
 }
 

 public SubCategoryPage clickOnCategoryDropDown()
 {

	 page.selectDropdownWithVisibleText(categorydropdown,"Toys");
	 return this;
	 }
 
 
 public SubCategoryPage enterSubCategoryField()
 {
	 String subcategoryname="jonnybunny"+page.generateCurrentDateAndTime();
	 subcategoryfield.sendKeys(subcategoryname);
	 return this;
	 }
 
 public SubCategoryPage imageupload()
 {
	 //String filepath="C:\\Users\\amal\\eclipse-workspace\\Groceryapplications\\src\\test\\resources\\image\\png-toy-toys-bears-png-image-2803.png.crdownload";
	FileUploadUtility.fileuploadusingsendkeys(imageupload,Constants.IMAGE_UPLOAD);
	WaitUtility.waitForWebElementVisible(driver,imageupload);
	 return this; }
 
public SubCategoryPage clickOnSaveButton()
{
	//savebutton.click();
	page.clickJavaScriptExecutor(savebutton,driver);
	 return this;
}

public boolean isAlertDisplayed()
{
	//WaitUtility.waitForWebElementAlert(driver);
	return alertmessage.isDisplayed();
}
public SubCategoryPage clickOnSearcButton()
{
	subcategorysearchbutton.click();
	 return this;
}
public SubCategoryPage clickOnCategoryDropDownforSearch()
{

	page.selectDropdownWithVisibleText(categorydropdownforsearch,"Toys");
	 return this;
}
public SubCategoryPage enterSubCategoryfieldforSearch()
{
	
	String category=faker.generateEmailAddress();
	subcategoryfieldforsearch.sendKeys(category);
	 return this;		
	}
public SubCategoryPage clickOnFinalSearcButton()
{
	finalsearchbutton.click();
	 return this;
}
public boolean isResultNotFOundDisplayed()
{
	
	return resultnotfound.isDisplayed();
	
}
public SubCategoryPage isRowDeleted()
{
	deletebutton.click();
	page.alertaccept(driver,deletebutton);
	 return this;

//	driver.switchTo().alert().accept();
	}
public boolean isDeletedAlertDisplayed()
{
	
	return deletedconfirmationalert.isDisplayed();
	
}
public SubCategoryPage clickactiveButton()
{
	activestatus.click();
	 return this;
}
public boolean isactiveStatuschaneAlertDisplayed()
{
	
	return activestatuschangealert.isDisplayed();
	
}
}
