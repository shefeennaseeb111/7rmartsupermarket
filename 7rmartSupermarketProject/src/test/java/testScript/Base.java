package testScript;

import org.testng.annotations.Test;

import constants.Constant;
import utilities.Screen_ShotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;

	@BeforeMethod
	@Parameters("browzer")
	public void beforeMethod(String browzer) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browzer.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browzer.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browzer.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod(ITestResult itResult) throws IOException {

		if (itResult.getStatus() == ITestResult.FAILURE) {
			Screen_ShotUtility sc = new Screen_ShotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	}

}
