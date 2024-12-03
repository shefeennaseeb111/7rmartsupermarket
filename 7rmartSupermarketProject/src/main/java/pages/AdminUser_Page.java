package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_utility;

public class AdminUser_Page {
	public WebDriver driver;
	public AdminUser_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
		}
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement moreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clicknew;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement UserType;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successalert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement failAlert;
	
	
	public AdminUser_Page createNew()
	{
	clicknew.click();
	return this;
	}
	public AdminUser_Page enterUsername(String usernamefield)
	{
		username.sendKeys(usernamefield);
		return this;
	}
	public AdminUser_Page enterPassword(String passwordfield)
	{
		password.sendKeys(passwordfield);
		return this;
	}
	public AdminUser_Page selectUsertype()
	{
	UserType.click();
		//Select dropdn1=new Select(UserType);
		//dropdn1.selectByIndex(2);
	Page_utility page=new Page_utility();
	page.selectByIndex(UserType, 2);
	return this;
	
	 }
	public AdminUser_Page clickSave()
	{
		save.click();
		return this;
	}
	public boolean greenAlert()
	{
		return successalert.isDisplayed(); 
	}
	public boolean redAlert()
	{
	return failAlert.isDisplayed(); 	
	}
	

}
