package testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
//import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

//import dev.failsafe.internal.util.Assert;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class Home_Test extends Base {
	public Home_Page homepage;
  @Test
  public void isTheUserIsAbleToLogOut() throws IOException 
  {
		
	  
	  String username=ExcelUtility.readStringData(1, 0, "Login_Page");
	 String password=ExcelUtility.readStringData(1, 1, "Login_Page");
		  Login_Page login=new Login_Page(driver);
		  login.enter_username(username);
		  login.enter_password(password);
		  homepage=login.click_Signin(); 
		  homepage.clicklogoutbutton();
		 // login.click_Signin(); 
		 // Home_Page logout=new Home_Page(driver);
		  //logout.clickadminbutton();
		  //logout.clicklogoutbutton();
		  String expectedResult="Login | 7rmart supermarket";
		  String actualResult=driver.getTitle();
		 // boolean isLoginPageIsDisplayed=logout.loginpagetitle();
		 assertEquals(expectedResult,actualResult,"user cannot login");
		 
  }
}
