package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
	public static WebDriver driver;
	
	//Use this constructor to get the current driver value
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
		PageFactory.initElements(driver,this);//this class for page object design patterns
	}

	//This method for highlight the element
	public static void highlightElement(JavascriptExecutor jExecutor, WebElement element) {
		jExecutor.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}
}
