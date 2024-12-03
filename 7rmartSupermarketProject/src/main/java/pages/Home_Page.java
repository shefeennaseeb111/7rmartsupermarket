package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;
	public Home_Page(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminbtn;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logoutbtn;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginpagetitle;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[1]/div/a")WebElement moreinfo;
	public Home_Page clickadminbutton() {
		adminbtn.click();
		return this;

	}
	public Home_Page clicklogoutbutton()
	{
		logoutbtn.click();
		 // System.out.println(driver.getTitle());
		return this;

	}
	public AdminUser_Page clickMoreInfo()
	{
	moreinfo.click();	
	return new AdminUser_Page(driver);
	}
	/*public void loginpagetitle()
	{
		//String loginpagetitle=driver.getTitle();

		loginpagetitle.isDisplayed(); 
	}*/

}
