package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Add_Subcategory;
import pages.Home_Page;
import pages.Login_Page;
import pages.Search_SubCategoryPage;
import utilities.ExcelUtility;

public class Search_SubCategoryTest extends Base {
	public Home_Page homepage;
	public Add_Subcategory addsubcategory;
	public Search_SubCategoryPage subcategory;

	@Test
	public void verifyUserIsAbleToSearchWithSubCategoryName() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		addsubcategory=homepage.userisabletoclicksubcategorybutton();
		subcategory=addsubcategory.userisabletoclicksearchbutton();
		subcategory.verifyuserisabletoselectcategoryfield();
		String subcategoryname = ExcelUtility.readStringData(3, 0, "Add_SubCategory");
		subcategory.verifyuserisabletoentersubcategory(subcategoryname);
		subcategory.verifyTheUserIsAbleToSearchDetails();
		boolean isTableIsDisplayed =subcategory.isTableDisplayed();
		assertTrue(isTableIsDisplayed,Constant.ERRORMESSAGEFORSEARCHSUBCATEGORY);
	}
	
}
