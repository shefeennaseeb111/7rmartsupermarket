package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Page_utility;

public class Search_SubCategoryPage {
	public WebDriver driver;

	public Search_SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "un")
	WebElement category;
	@FindBy(name = "ut")
	WebElement subcategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement clickonsearch;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement table;

	public Search_SubCategoryPage verifyuserisabletoselectcategoryfield() {
		category.click();
		Page_utility page = new Page_utility();
		page.selectByIndex(category, 2);
		return this;
	}

	public Search_SubCategoryPage verifyuserisabletoentersubcategory(String subcategoryfield) {
		subcategory.sendKeys(subcategoryfield);
		return this;
	}

	public Search_SubCategoryPage verifyTheUserIsAbleToSearchDetails() {
		clickonsearch.click();
		return this;
	}

	public boolean isTableDisplayed() {
		return table.isDisplayed();
	}
}
