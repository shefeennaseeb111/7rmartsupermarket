package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_CategoryPage {
	public WebDriver driver;
	public Search_CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")WebElement categoryname;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchbutton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement table;

	
	public Search_CategoryPage userisableTosearchwithCategoryName(String categorynamefield)
	{
		categoryname.sendKeys(categorynamefield);
		return this;
	}
	public Search_CategoryPage userisableTosearchTheCategory()
	{
		searchbutton.click();
		return this;
	}
	public boolean isTableisdisplayed()
	{
		return table.isDisplayed(); 
	}
	
}
