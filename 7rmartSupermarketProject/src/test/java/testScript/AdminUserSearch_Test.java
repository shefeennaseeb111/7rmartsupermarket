package testScript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserSearch_Page;
import pages.AdminUser_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class AdminUserSearch_Test extends Base {
	public Home_Page homepage;
	public AdminUser_Page adminuser;
	public AdminUserSearch_Page search;

	@Test
	public void searchForParticularUserNameAndPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username,password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		String uname = ExcelUtility.readStringData(3, 0, "Admin_search");
		search=adminuser.userisabletoclicksearchbutton();
		search.userisabletoenterusername(uname);
		search.userisabletoselectusertype();
		search.userisabletosearchdetails();
		boolean isTableIsDisplayed = search.searchforparticularusernameintable();
		assertTrue(isTableIsDisplayed, Constant.ERRORMESSAGEFORSEARCHADMIN);
	}

	@Test
	public void searchItemNotFound() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username,password);
		homepage = login.click_Signin();
		adminuser = homepage.userisabletoclickMoreInfo();
		String usname = ExcelUtility.readStringData(2, 0, "Admin_search");
		search=adminuser.userisabletoclicksearchbutton();
		search.userisabletoenterusername(usname);
		search.userisabletoselectusertype();
		search.userisabletosearchdetails();
		boolean itemNotFound = search.searchnotFound();
		assertTrue(itemNotFound, Constant.ERRORMESSAGEFORSEARCHADMINTEST);
	}
}
