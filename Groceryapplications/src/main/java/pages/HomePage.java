package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
public WebDriver driver;
PageUtility page=new PageUtility();
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}

@FindBy(xpath="//li//p[text()='Sub Category']")WebElement subcategory;
@FindBy(xpath="//p[text()='Manage Category']")WebElement category;
//@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement category;
@FindBy(xpath="//p[text()='Manage Contact']")WebElement managecontact;


public SubCategoryPage clickOnSubcategory()
{
	subcategory.click();
	return new SubCategoryPage(driver);//chaining
	}
public CategoryPage clickOnCategory()
{
	category.click();
	return new CategoryPage(driver);
	}
public ManageContact clickOnManageContactButton()
{
	//managecontact.click();
	page.clickJavaScriptExecutor(managecontact,driver);
	return new ManageContact(driver);
}
}
