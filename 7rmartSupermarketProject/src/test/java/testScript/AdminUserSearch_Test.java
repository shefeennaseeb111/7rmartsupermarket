package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUserSearch_Page;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class AdminUserSearch_Test extends Base {
	public Home_Page homepage;
	public AdminUser_Page adminuser; 
  @Test
  public void searchForParticularUserNameAndPassword() throws IOException 
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
	  //addnew.clickMoreInfo();
	  String uname=ExcelUtility.readStringData(3, 0, "Admin_search");
	   AdminUserSearch_Page search=new AdminUserSearch_Page(driver);
	  search.firstsearch();
	  search.enterusername(uname);
	  search.enterusertype();
	  search.searchclick();
	  boolean isTableIsDisplayed=search.searchforparticularusernameintable();
	  assertTrue(isTableIsDisplayed,"user not found");
  }
  @Test
  public void searchItemNotFound()
  {
	  Login_Page login=new Login_Page(driver);
	  login.enter_username("admin");
	  login.enter_password("admin");
	  homepage=login.click_Signin();
	  adminuser=homepage.clickMoreInfo();
	  //login.click_Signin();
	  //AdminUser_Page addNew=new AdminUser_Page(driver);
	 // addNew.clickMoreInfo();
	  AdminUserSearch_Page search=new AdminUserSearch_Page(driver);
	  search.firstsearch();
	  search.enterusername("teena");
	  search.enterusertype();
	  search.searchclick();
	  boolean itemNotFound=search.notFound();
	  assertTrue(itemNotFound,"user found");  
  }
}
