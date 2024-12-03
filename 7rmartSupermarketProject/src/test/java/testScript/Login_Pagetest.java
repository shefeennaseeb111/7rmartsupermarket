package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;

import pages.Login_Page;
import utilities.ExcelUtility;

public class Login_Pagetest extends Base {
  @Test
  @Parameters({"username","password"})
  public void verifytheUserIsAbleToLoginWithValidCredentials(String usrnam,String pasword) 
  {
	  Login_Page login=new Login_Page(driver);
	  login.enter_username(usrnam);
	  login.enter_password(pasword);
	  login.click_Signin();
	  boolean IsHomePageIsDisplayed=login.isDashBoardLoaded();
	  assertTrue(IsHomePageIsDisplayed,Constant.ERRORMESSAGEFORLOGIN);
	  
  }
  @DataProvider(name="credentials")
  public Object[][] testData()
  {
	  Object data[][]= {{"admin","admin"},{"shefeena","shef111"}};
	  return data;
  }
  
  @Test(dataProvider="credentials")
  public void verifytheUserisAbleToLoginWithInvalidCredentials(String usernm,String paswrd) 
  {
	  Login_Page login=new Login_Page(driver);
	  login.enter_username(usernm);
	  login.enter_password(paswrd);
	  login.click_Signin();
	  boolean IsHomePageIsDisplayed =login.isDashBoardLoaded();
	  assertTrue(IsHomePageIsDisplayed,Constant.ERRORMESSAGEFORINVALIDLOGIN);
	  //login.alert("Invalid credentials");
	  
  }
  @Test
 
  public void verifyTheuserisAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException 
  {
	 String username=ExcelUtility.readStringData(1, 0, "Login_Page");
	 String password=ExcelUtility.readStringData(1, 1, "Login_Page");
	  Login_Page login=new Login_Page(driver);
	  login.enter_username(username);
	  login.enter_password(password);
	  login.click_Signin();
	  boolean IsalertIsDisplayed=login.alert();
	  assertTrue(IsalertIsDisplayed,Constant.ERRORMESSAGEFORINVALIDUSERNAMEANDVALIDPASWRD);
	  
  }
  @Test
  public void verifyTheUserIsAbleToLoginWithValidUsernameAndInvalidPassword()
  {
	  Login_Page login=new Login_Page(driver);
	  login.enter_username("admin");
	  login.enter_password("123");
	  login.click_Signin();
	  boolean IsalertIsDisplayed=login.alert();
	  assertTrue(IsalertIsDisplayed,Constant.ERRORMESSAGEFORVALIDUSERANDINVALIDPASWRD);
  }
  
}
