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
	  login.enter_username(username);
	  login.enter_password(password);
	  homepage=login.click_Signin();
	  adminuser=homepage.clickMoreInfo();
	 // login.click_Signin();
	  //AdminUser_Page addNew=new AdminUser_Page(driver);
	  //addNew.clickMoreInfo();
	  adminuser.createNew();
	  String usrname=ExcelUtility.readStringData(1, 0, "Admin_Pageadd");
	  String pasword=ExcelUtility.readStringData(1, 1, "Admin_Pageadd");
	  adminuser.enterUsername(usrname);
	  adminuser.enterPassword(pasword);
	  adminuser.selectUsertype();
	  adminuser.clickSave();
	  boolean IsgreenAlertIsDisplayed=adminuser.greenAlert();
	  assertTrue(IsgreenAlertIsDisplayed,Constant.ERRORMESSAGEFORADMINUSERTEST);
	  
  }
  @Test
  public void userIsAbleToAddNewAdminWithduplicateDetails() throws IOException 
  {
	  String username=ExcelUtility.readStringData(1, 0, "Login_Page");
	  String password=ExcelUtility.readStringData(1, 1, "Login_Page");
	  Login_Page login=new Login_Page(driver);
	  login.enter_username(username);
	  login.enter_password(password);
	  homepage=login.click_Signin();
	  adminuser=homepage.clickMoreInfo();
	  //login.click_Signin();
	  //AdminUser_Page addNew=new AdminUser_Page(driver);
	  //addNew.clickMoreInfo();
	  adminuser.createNew();
	  String usrname=ExcelUtility.readStringData(1, 0, "Admin_Pageadd");
	  String pasword=ExcelUtility.readStringData(1, 1, "Admin_Pageadd");
	  adminuser.enterUsername(usrname);
	  adminuser.enterPassword(pasword);
	  adminuser.selectUsertype();
	  adminuser.clickSave();
	  boolean IsRedAlertIsDisplayed=adminuser.redAlert();
	  assertTrue(IsRedAlertIsDisplayed,"green alert displayed");  
  }
}
