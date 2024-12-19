package testScript;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constant;
import pages.Login_Page;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class Login_Pagetest extends Base {
	@Test
	@Parameters({ "username", "password" })
	public void verifytheUserIsAbleToLoginWithValidCredentials(String usrnam, String pasword) {
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(usrnam, pasword);
		login.click_Signin();
		boolean IsHomePageIsDisplayed = login.isDashBoardLoaded();
		assertTrue(IsHomePageIsDisplayed, Constant.ERRORMESSAGEFORLOGIN);

	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" }, { "shefeena", "shef111" } };
		return data;
	}

	@Test(dataProvider = "credentials")
	public void verifytheUserisAbleToLoginWithInvalidCredentials(String usernm, String paswrd) {
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(usernm, paswrd);
		login.click_Signin();
		boolean IsHomePageIsDisplayed = login.isDashBoardLoaded();
		assertTrue(IsHomePageIsDisplayed, Constant.ERRORMESSAGEFORINVALIDLOGIN);

	}

	@Test(groups = { "smoke" })

	public void verifyTheuserisAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		FakerUtility fake = new FakerUtility();
		String username = fake.getFakeFirstName();
		// String username = ExcelUtility.readStringData(4, 0, "Login_Page");
		// String password = ExcelUtility.readStringData(4, 1, "Login_Page");
		String password = fake.getFakeLastName();
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		login.click_Signin();
		boolean IsalertIsDisplayed = login.alert();
		assertTrue(IsalertIsDisplayed, Constant.ERRORMESSAGEFORINVALIDUSERNAMEANDVALIDPASWRD);

	}

	@Test(groups = { "smoke" })
	public void verifyTheUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(3, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username, password);
		login.click_Signin();
		boolean IsalertIsDisplayed = login.alert();
		assertTrue(IsalertIsDisplayed, Constant.ERRORMESSAGEFORVALIDUSERANDINVALIDPASWRD);
	}

}
