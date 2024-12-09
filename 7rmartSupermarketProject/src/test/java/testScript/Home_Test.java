package testScript;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.Home_Page;
import pages.Login_Page;
import utilities.ExcelUtility;

public class Home_Test extends Base {
	public Home_Page homepage;

	@Test
	public void isTheUserIsAbleToLogOut() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		Login_Page login = new Login_Page(driver);
		login.enter_usernameandpassword(username,password);
		homepage = login.click_Signin();
		homepage.userisabletoclickadminbutton();
		homepage.userisabletoclicklogoutbutton();
		String expectedResult = "Login | 7rmart supermarket";
		String actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult,Constant.ERRORMESSAGEFORHOMEPAGE);

	}
}
