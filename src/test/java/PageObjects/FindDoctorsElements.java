package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindDoctorsElements extends BasePage{
	
	//Get the driver value
	public FindDoctorsElements(WebDriver driver)
	{
		super(driver);
	}
	
	//Declaration part of Explicit wait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	//Declaration part of JavascriptExecutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//Locators for Find Doctors Function Elements
	@FindBy(xpath="//div[contains(text(),'Find Doctors')]")
	WebElement findDoc_element;
	
	@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement search_speciality;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-item']/span/div[text()='Dentist']")
	WebElement recent_search;
	
	@FindBy(xpath="//h2[@class='doctor-name']")
	List<WebElement> doctors_name;
	
	@FindBy(xpath="//div[@class='u-d-flex']/span")
	List<WebElement> occupation_type;
	
	@FindBy(xpath="//button[@class='u-t-capitalize u-bold u-round-corner--large c-btn--dark-medium']")
	List<WebElement> bookfree_buttons;
	
	//Actions for Find doctors functionality
	public void findDocPage()
	{
		wait.until(ExpectedConditions.visibilityOf(findDoc_element));
		findDoc_element.click();
	}
	//Actions for Find Doctors page
	public void findDoctor(String spec) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(search_speciality));
		search_speciality.sendKeys(spec);//search specialist doctor in Dentist
		Thread.sleep(3000);
		WebElement r_srch=wait.until(ExpectedConditions.visibilityOf(recent_search));
		r_srch.click();
		
		js.executeScript("window.scrollBy(0,1800)",""); //scroll the page till pixel value
	}
	
	//Actions for get the doctors name
	public List<WebElement> doctersName()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(doctors_name));
		return doctors_name;
	}
	
	//Actions for get the doctors occupations
	public List<WebElement> occupations()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(occupation_type));
		return occupation_type;
	}
	
	//Actions for get the elements of book free
	public List<WebElement> bookFree()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(bookfree_buttons));
		return bookfree_buttons;
	}
	

}
