package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_utility;

public class AdminUser_Page {
	public WebDriver driver;

	public AdminUser_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknew;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement UserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement failAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbtn;

	public AdminUser_Page userisabletoclickcreateNew() {
		clicknew.click();
		return this;
	}

	public AdminUser_Page userisabletoenterUsername(String usernamefield) {
		username.sendKeys(usernamefield);
		return this;
	}

	public AdminUser_Page userisabletoenterPassword(String passwordfield) {
		password.sendKeys(passwordfield);
		return this;
	}

	public AdminUser_Page userisabletoselectUsertype() {
		UserType.click();
		Page_utility page = new Page_utility();
		page.selectByIndex(UserType, 2);
		return this;

	}

	public AdminUser_Page userisabletoclickSave() {
		save.click();
		return this;
	}

	public boolean greenAlertisdisplayed() {
		return successalert.isDisplayed();
	}

	public boolean redAlertisdisplayed() {
		return failAlert.isDisplayed();
	}

	public AdminUserSearch_Page userisabletoclicksearchbutton() {
		searchbtn.click();
		return new AdminUserSearch_Page(driver);
	}

}
