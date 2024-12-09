package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constant;
import pages.Home_Page;
import pages.Login_Page;
import pages.Manage_NewsPage;
import utilities.ExcelUtility;

public class ManageNews_Test extends Base {
	public Home_Page homepage;
	public Manage_NewsPage news;

	@Test
	public void toManageNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		homepage = login.click_Signin();
		news = homepage.userisabletoclickmanageNews();
		news.userisabletoclicknewbutton();
		String newsfield = ExcelUtility.readStringData(3, 0, "Manage_News");
		news.userisabletoenterNewsinnewsfield(newsfield).userisabletoclicksavebutton();
		boolean IsalertAlertIsDisplayed = news.isalertdisplayed();
		assertTrue(IsalertAlertIsDisplayed, Constant.ERRORMESSAGEFORMANAGENEWS);

	}
}
