package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManageFooterText_Page;
import utilities.ExcelUtility;

public class ManageFooterText_Test extends Base {
	public Home_Page homepage;
	public ManageFooterText_Page text;
  @Test
  public void verifyTheUserIsAbleToManageFooterText() throws IOException {
	  	String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		text=homepage.userIsAbleToClickManageFooterText();
		text.userIsAbleToClickUpdateicon();
		String address = ExcelUtility.readStringData(1, 0, "ManageFooter_Text");
		text.userIsAbleToAddAddress(address);
		String email = ExcelUtility.readStringData(1, 1, "ManageFooter_Text");
		text.userIsAbleToAddEmail(email);
		String phone = ExcelUtility.readIntegerData(1, 2, "ManageFooter_Text");
		text.userIsAbleToAddPhoneNumber(phone);
		text.userIsAbleToclickupdate();
		boolean IsFooterTextCanUpdateSuccessfully=text.isFooterTextUpdateSuccessfully();
		assertTrue(IsFooterTextCanUpdateSuccessfully,Constant.ERRORMESSAGEFORMANAGEFOOTERTEXTPAGE);
		
  }
}
