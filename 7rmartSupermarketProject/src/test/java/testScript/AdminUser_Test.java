package testScript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import constants.Constant;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class AdminUser_Test extends Base {
	public Home_Page homepage;
	public AdminUser_Page adminuser; 
	
  @Test
  public void userIsAbleToAddNewAdminwithvaliddetails() throws IOException
  {
	  String username=ExcelUtility.readStringData(1, 0, "Login_Page");
	  String password=ExcelUtility.readStringData(1, 1, "Login_Page");
	  Login_Page login=new Login_Page(driver);
	  login.enter_usernameandpassword(username,password);
	  homepage=login.click_Signin();
	  adminuser=homepage.userisabletoclickMoreInfo();
	  adminuser.userisabletoclickcreateNew();
	  String usrname=ExcelUtility.readStringData(1, 0, "Admin_Pageadd");
	  String pasword=ExcelUtility.readStringData(1, 1, "Admin_Pageadd");
	  adminuser.userisabletoenterUsername(usrname).userisabletoenterPassword(pasword).userisabletoselectUsertype().userisabletoclickSave();
	  boolean IsgreenAlertIsDisplayed=adminuser.greenAlertisdisplayed();
	  assertTrue(IsgreenAlertIsDisplayed,Constant.ERRORMESSAGEFORADMINUSERTEST);
	  
  }
  @Test
  public void userIsAbleToAddNewAdminWithduplicateDetails() throws IOException 
  {
	  String username=ExcelUtility.readStringData(1, 0, "Login_Page");
	  String password=ExcelUtility.readStringData(1, 1, "Login_Page");
	  Login_Page login=new Login_Page(driver);
	  login.enter_usernameandpassword(username,password);
	  homepage=login.click_Signin();
	  adminuser=homepage.userisabletoclickMoreInfo();
	  adminuser.userisabletoclickcreateNew();
	  String usrname=ExcelUtility.readStringData(1, 0, "Admin_Pageadd");
	  String pasword=ExcelUtility.readStringData(1, 1, "Admin_Pageadd");
	  adminuser.userisabletoenterUsername(usrname).userisabletoenterPassword(pasword).userisabletoselectUsertype().userisabletoclickSave();
	  boolean IsRedAlertIsDisplayed=adminuser.redAlertisdisplayed();
	  assertTrue(IsRedAlertIsDisplayed,Constant.ERRORMESSAGEFORADDADMINUSERTEST);  
  }
}
