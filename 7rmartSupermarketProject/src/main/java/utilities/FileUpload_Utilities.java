package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Constant;

public class FileUpload_Utilities {
	public WebDriver driver;

	public void sendKeysUpload(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void robotForFileUpload(WebElement element, String path) throws AWTException {
		StringSelection select = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		robot.delay(0);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
