package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Factory;

public class AdminUserSearch_Page {
	public WebDriver driver;

	public AdminUserSearch_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement username;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement userType;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchbynameandtype;
	@FindBy(xpath = "//div[@class='row-sm-12']")
	WebElement table;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement notfound;

	public AdminUserSearch_Page userisabletoenterusername(String usernamefield) {
		username.sendKeys(usernamefield);
		return this;
	}

	public AdminUserSearch_Page userisabletoselectusertype() {
		userType.click();
		Select dropdn1 = new Select(userType);
		dropdn1.selectByIndex(2);
		return this;
	}

	public AdminUserSearch_Page userisabletosearchdetails() {
		searchbynameandtype.click();
		return this;
	}

	public boolean searchforparticularusernameintable() {

		return table.isDisplayed();

	}

	public boolean searchnotFound() {
		return notfound.isDisplayed();
	}

}
