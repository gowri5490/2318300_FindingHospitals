package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoConsultElements extends BasePage{
	
	//Get the parent constructor driver value
	public VideoConsultElements(WebDriver driver)
	{
		super(driver);
	}
	
	//Declaration part of Explicit wait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
	//Locators for Video Consult Function Elements
	@FindBy(xpath="//div[text()='Video Consult']")
	WebElement videoCon_element;
		
	@FindBy(xpath="//div[@class='content']//a[@class='link primary-button cta'][normalize-space()='Consult Now']")
	WebElement consult_button;
		
	@FindBy(xpath="//div[@id='TopSpecialityCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement> specialities_element;
		
	@FindBy(xpath="//div[@id='HealthProblemCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement> commonHealthConcerns;
		
	@FindBy(xpath="//div[@id='HealthProblemCardsContainer']/descendant::div[@class='content']/p")
	List<WebElement> healthConcernPrice;
		
	@FindBy(xpath="//div[@id='OfferCardsContainer']/descendant::div[@class='content']/h4")
	List<WebElement>offers;
		
	//click Action for video consult function
	public void videoConsultAction()
	{
		wait.until(ExpectedConditions.visibilityOf(videoCon_element));
		videoCon_element.click();
	}
	
	//This method to get consult button status
	public boolean isConsultEnabled()
	{
		wait.until(ExpectedConditions.visibilityOf(consult_button));
		return consult_button.isEnabled();
	}
	
	//This method for get Specialities WebElements 
	public List<WebElement> specialities()
	{
		return specialities_element;
	}
	
	//This method for get CommonHealth concern WebElements
	public List<WebElement> commonHealthConcern()
	{
		return commonHealthConcerns;
	}
	
	//This method for get concern price WebElements
	public List<WebElement> concernPrice()
	{
		return healthConcernPrice;
	}
	
	//This method for get consult offers WebElements
	public List<WebElement> consultOffers()
	{
		return offers;
	}
}
