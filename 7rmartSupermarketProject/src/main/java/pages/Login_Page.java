package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_utility;

public class Login_Page {
	public WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public Login_Page enter_usernameandpassword(String Usernamefield, String Passwordfield) {

		username.sendKeys(Usernamefield);
		password.sendKeys(Passwordfield);
		return this;
	}

	public Home_Page click_Signin() {
		Wait_utility wait = new Wait_utility();
		wait.waitForElementsToBeClickable(driver, signin);
		signin.click();
		return new Home_Page(driver);
	}

	public boolean isDashBoardLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean alert() {

		return alert.isDisplayed();
	}

}
