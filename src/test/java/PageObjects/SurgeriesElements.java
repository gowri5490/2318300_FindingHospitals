package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurgeriesElements extends BasePage{
	
	//Get the parent constructor driver value
	public SurgeriesElements(WebDriver driver)
	{
		super(driver);
	}
	//Declaration part of JavascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Declaration part of Explicit wait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	//Locators for Surgeries Function elements
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement surgeries_element;
	
	@FindBy(xpath="//div[@class='flex items-center gap-12px']/h1")
	WebElement care_no;
	
	@FindBy(xpath="//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeries_list;
	
	@FindBy(xpath="//h1[@class='text-module_base__1vdUh text-16px font-bold text-black']")
	List<WebElement> departments;
	
	@FindBy(xpath="//h1[@class='list-module_sizeSmallItemContentTitle__kaSwM list-module_itemContentTitle__XreVD text-gray-2']")
	List<WebElement> benifits_element;
	
	
	//click action for surgeries functionality
	public void surgeriesAction()
	{
		wait.until(ExpectedConditions.visibilityOf(surgeries_element));
		surgeries_element.click();
	}
	
	//This method to get PractoCare number
	public String practoCare()
	{
		wait.until(ExpectedConditions.visibilityOf(care_no));
		return care_no.getText();
	}
	
	//This method to locate the popular surgeries WebElements
	public List<WebElement> popularSurgeries()
	{
		js.executeScript("window.scrollBy(0,600);","");
		wait.until(ExpectedConditions.visibilityOfAllElements(surgeries_list));
		return surgeries_list;
	}
	
	//This method for get the departments WebElements
	public List<WebElement> ourDepartments()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(departments));
		return departments;
	}
	
	//This method for get the PractoCare benefits WebElements 
	public List<WebElement> practoCareBenifits()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(benifits_element));
		return benifits_element;
	}
	
}
