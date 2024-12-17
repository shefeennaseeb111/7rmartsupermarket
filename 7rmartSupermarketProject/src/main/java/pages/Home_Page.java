package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbtn;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutbtn;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginpagetitle;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[1]/div/a")
	WebElement moreinfo;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[3]/div/a")
	WebElement clickcategory;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[4]/div/a")
	WebElement subcategoryclick;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement clickmanaganews;
	@FindBy(xpath = "/html/body/div/div[1]/section/div/div/div[10]/div/a")
	WebElement managefooterclick;

	public Home_Page userisabletoclickadminbutton() {
		adminbtn.click();
		return this;

	}

	public Home_Page userisabletoclicklogoutbutton() {
		logoutbtn.click();
		return this;

	}

	public AdminUser_Page userisabletoclickMoreInfo() {
		moreinfo.click();
		return new AdminUser_Page(driver);
	}

	public Addcategory userisabletoclikcategorybutton() {
		clickcategory.click();
		return new Addcategory(driver);
	}

	public Add_Subcategory userisabletoclicksubcategorybutton() {
		subcategoryclick.click();
		return new Add_Subcategory(driver);
	}

	public Manage_NewsPage userisabletoclickmanageNews() {
		clickmanaganews.click();
		return new Manage_NewsPage(driver);
	}

	public ManageFooterText_Page userIsAbleToClickManageFooterText() {
		managefooterclick.click();
		return new ManageFooterText_Page(driver);
	}

}
