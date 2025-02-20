package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CategoryPage {
public WebDriver driver;
PageUtility page=new PageUtility();
public CategoryPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")WebElement newcategorypagebutton;
@FindBy(xpath ="//input[@id='category']")WebElement entercategory;
@FindBy(xpath ="//li[@id='134-selectable']")WebElement selectgroup;
@FindBy(xpath="//input[@name='top_menu' and @checked='checked']")WebElement showontopmenuradiobutton;
@FindBy(xpath="//input[@name='show_home' and @checked='checked']")WebElement showonleftmenuradiobutton;
@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement isalertpresent;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement categorysearchbutton;
@FindBy(xpath="//input[@class='form-control']")WebElement categoryfieldforsearchbutton;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement finalsearchbuttonforcategoryfiled;
@FindBy(xpath="//span[@id='res']")WebElement resultnotfoundalert;
@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")WebElement deletecategorybutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement deletealert;
@FindBy(xpath="//span[@class='badge bg-success']")WebElement statusbutton;
@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement statuschangealert;



public CategoryPage clickONnewCategorybutton()
{
	newcategorypagebutton.click();
	return this;
	}
public CategoryPage enterCategoryField()
{
	String cat="Toys"+page.generateCurrentDateAndTime();
	entercategory.sendKeys(cat);
	return this;
	}
public CategoryPage clickSelectGroup()
{
	selectgroup.click();
	return this;
	}
public void selectShowonTopMenuRadioButton()
{
if(!showontopmenuradiobutton.isSelected())
{
	showontopmenuradiobutton.click();

}
}
public void selectShowonLeftMenuRadioButton()
{
if(!showonleftmenuradiobutton.isSelected())
{
	showonleftmenuradiobutton.click();
	
}
}
public CategoryPage clickOnSaveButton()
{
	savebutton.click();
	return this;
	}
public boolean isNewCategoryAddAlertPresent()
{
	return isalertpresent.isDisplayed();
	}
public CategoryPage clickOnSearchCategoryButton()
{
	categorysearchbutton.click();
	return this;
	}
public CategoryPage enterCategoryFieldforSearch()
{
	String category="woods";
	categoryfieldforsearchbutton.sendKeys(category);
	return this;
	}
public CategoryPage clickOSearchbutton()
{
	finalsearchbuttonforcategoryfiled.click();
	return this;
	}
public boolean isAlertPresent()
{
	return resultnotfoundalert.isDisplayed();
	}
public CategoryPage clickODeleteButton()
{
	deletecategorybutton.click();
	driver.switchTo().alert().accept();
	return this;
	}
public boolean isDeleteAlertPresent()
{
	return deletealert.isDisplayed();
	
	}
public CategoryPage clickOnStatusButton()
{
	//statusbutton.click();
	page.clickJavaScriptExecutor(statusbutton,driver);
	return this;
}
public boolean isStatusAlertPresent()
{
	return statuschangealert.isDisplayed();
	}
} 
