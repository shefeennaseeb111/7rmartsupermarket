package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Add_Subcategory;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class Add_SubCategoryTest extends Base {
	public Home_Page homepage;
	public Add_Subcategory addsubcategory;

	@Test
	public void toAddSubCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		addsubcategory = homepage.userisabletoclicksubcategorybutton();
		addsubcategory.userisabletoclicknewbutton().userisabletoselectcategoryfield();
		String subcategoryname = ExcelUtility.readStringData(2, 0, "Add_SubCategory");
		addsubcategory.userisabletoentersubcategory(subcategoryname).userisabletouploadimage().userisabletoclicksavebutton();
		boolean IsAlertIsDispalyed=addsubcategory.isalertDisplayed();
		assertTrue(IsAlertIsDispalyed,Constant.ERRORMESSAGEFORADDSUBCATEGORY);
	}
}
