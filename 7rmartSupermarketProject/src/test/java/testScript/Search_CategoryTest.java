package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Addcategory;
import pages.Home_Page;
import pages.Login_Page;
import pages.Search_CategoryPage;
import utilities.ExcelUtility;

public class Search_CategoryTest extends Base {
	public Home_Page homepage;
	public Addcategory add;
	public Search_CategoryPage search;

	@Test
	public void verifyTheUserIsAbleToDisplayTheSearchedCategory() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		add = homepage.userisabletoclikcategorybutton();
		search = add.userisabletoclicksearch();
		String categoryname = ExcelUtility.readStringData(3, 0, "Add_Category");
		search.userisableTosearchwithCategoryName(categoryname);
		search.userisableTosearchTheCategory();
		boolean isTableIsDisplayed = search.isTableisdisplayed();
		assertTrue(isTableIsDisplayed, Constant.ERRORMESSAGEFORSEARCHCATEGORY);
	}
}
