package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page_utility {
	public WebDriver driver;
	public void selectByIndex(WebElement dropdown,int index)
	{
	Select dropdn=new Select(dropdown);
	dropdn.selectByIndex(index);
	}

}
