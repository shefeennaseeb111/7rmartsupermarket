package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Addcategory;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class AddCategory_Test extends Base {
	public Home_Page homepage;
	public Addcategory add;

	@Test
	public void toEnterCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		add = homepage.userisabletoclikcategorybutton();
		add.userisabletoclicknewbutton();
		String categoryname = ExcelUtility.readStringData(2, 0, "Add_Category");
		add.userisabletoentercategoryname(categoryname).userisabletoclickdiscount().userisabletouploadfile()
				.userisabletoselecttopmenu().userisabletoselectleftmenu().userisabletocliksave();
		boolean alertt = add.isalertisDisplayed();
		assertTrue(alertt, Constant.ERRORMESSAGEFORNEWCATEGORY);

	}
}
