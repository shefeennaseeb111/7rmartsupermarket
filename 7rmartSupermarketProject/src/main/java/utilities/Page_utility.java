package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_utility {
	public WebDriver driver;
	JavascriptExecutor javascript = (JavascriptExecutor) driver;

	public void selectByIndex(WebElement dropdown, int index) {
		Select dropdn = new Select(dropdown);
		dropdn.selectByIndex(index);
	}

	public void darganddrop(WebElement drag, WebElement destination) {
		Actions action = new Actions(driver);
		action.moveToElement(drag);
		action.doubleClick(drag).perform();
		action.dragAndDrop(drag, destination).build().perform();

	}

	public void adminuser_click(WebElement click) {
		javascript.executeScript("arguments[0].click();", click);
	}

	public void scroll(WebElement scroll) {
		javascript.executeScript("window.scrollTo(0,1000)");
	}

	public void doubleclick(WebElement click) {
		Actions action = new Actions(driver);
		action.doubleClick(click).perform();

	}

}
