package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUpload_Utilities;
import utilities.Page_utility;

public class Add_Subcategory {
	public WebDriver driver;

	public Add_Subcategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newclick;
	@FindBy(xpath="//select[@id='cat_id']")WebElement category;
	@FindBy(xpath="//input[@id='subcategory']")WebElement subcategory;
	@FindBy(xpath="//input[@id='main_img']")WebElement file;
	@FindBy(xpath="//button[text()='Save']")WebElement clicksave;
	@FindBy(xpath="//button[@data-dismiss='alert']")WebElement alertt;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	
	public Add_Subcategory userisabletoclicknewbutton()
	{
		newclick.click();
		return this;
	}
	public Add_Subcategory userisabletoselectcategoryfield()
	{
		category.click();
		Page_utility page = new Page_utility();
		page.selectByIndex(category, 3);
		return this;
	}
	public Add_Subcategory userisabletoentersubcategory(String subcategoryname)
	{
		subcategory.sendKeys(subcategoryname);
		return this;
	}
	public Add_Subcategory userisabletouploadimage()
	{
		String imagepath = Constant.TESTIMAGEFORSUBCATEGORY;
		FileUpload_Utilities file1 = new FileUpload_Utilities();
		file1.sendKeysUpload(file, imagepath);
		return this;
	}
	public Add_Subcategory userisabletoclicksavebutton()
	{
		clicksave.click();
		return this;
	}
	public boolean isalertDisplayed()
	{
		return alertt.isDisplayed(); 
	}
	public Search_SubCategoryPage userisabletoclicksearchbutton()
	{
		searchbutton.click();
		return new Search_SubCategoryPage(driver);
	}
	

}
