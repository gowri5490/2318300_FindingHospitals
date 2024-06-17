package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoConsultElements extends BasePage{
	
	//Get the parent constructor driver value
	public VideoConsultElements(WebDriver driver)
	{
		super(driver);
	}
		
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
		videoCon_element.click();
	}
	
	//this method for get consult button status
	public boolean isConsultEnabled()
	{
		return consult_button.isEnabled();
	}
	
	//this method for get Specialities WebElements 
	public List<WebElement> specialities()
	{
		return specialities_element;
	}
	
	//this method for get CommonHealth concern WebElements
	public List<WebElement> commonHealthConcern()
	{
		return commonHealthConcerns;
	}
	
	//this method for get concern price WebElements
	public List<WebElement> concernPrice()
	{
		return healthConcernPrice;
	}
	
	//this method for get consult offers WebElements
	public List<WebElement> consultOffers()
	{
		return offers;
	}
}