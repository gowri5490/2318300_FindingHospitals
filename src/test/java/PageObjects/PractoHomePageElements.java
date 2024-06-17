package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PractoHomePageElements extends BasePage{
	
	//create the constructor for get the current driver value 
	public PractoHomePageElements(WebDriver driver)
	{
		super(driver);
	}
	//Declaration part of JavascriptExecutor
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	//Declaration part of Explicit wait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	//Locators for HomePage Elements
	@FindBy(xpath="//span[@class='practo-logo']//i[@class='practo_logo_new']")
	WebElement logo_icon;
	
	@FindBy(xpath="//a[@class='btn-border nav-login nav-interact ']")
	WebElement login_button;
	
	@FindBy(xpath="//div[@class='downloads']")
	WebElement download_option;
	
	@FindBy(xpath="//span[text()='Wellness Plans']")
	WebElement wellness_plan;
	
	@FindBy(xpath="//header[@id='header']//input[@id='name']")
	WebElement user_name;
	
	@FindBy(xpath="//header[@id='header']//input[@id='organizationName']")
	WebElement organization_name;
	
	@FindBy(xpath="//header[@id='header']//input[@id='contactNumber']")
	WebElement contact_no;
	
	@FindBy(xpath="//header[@id='header']//input[@id='officialEmailId']")
	WebElement official_emailId;
	
	@FindBy(xpath="//header[@id='header']//select[@id='organizationSize']")
	WebElement organization_size;
	
	@FindBy(xpath="//header[@id='header']//select[@id='interestedIn']")
	WebElement InterestedIn;
	
	@FindBy(xpath="//header[@id='header']//button[@type='submit']")
	WebElement submit_button;
	
	@FindBy(xpath="//div[@class='ReactModalPortal'][1]/div/div/div/div[1]")
	WebElement txt_confirm;
	
	//Actions for Practo page logo
	public boolean isLogoPresent()
	{
		BasePage.highlightElement(jse, logo_icon);
		return logo_icon.isDisplayed();
	}
	
	//Actions for login button option
	public boolean isLoginButtonPresent()
	{
		BasePage.highlightElement(jse, login_button);//highlight the element
		return login_button.isDisplayed();
	}
	//Actions for download option
	public boolean isDownloadPresent()
	{
		
		jse.executeScript("arguments[0].scrollIntoView(true);",download_option);//scroll the page till the web element
		WebElement dwnld=wait.until(ExpectedConditions.visibilityOf(download_option));//usage part of the explicit wait
		BasePage.highlightElement(jse, dwnld);//highlight the element
		return dwnld.isDisplayed();
	}
	//Actions for corporate wellness form page
	public void corporateWellnessAction()
	{
		wellness_plan.click();
		Set<String>windows=driver.getWindowHandles();//handle the multiple windows
		List<String> windowId=new ArrayList<>(windows);
		driver.switchTo().window(windowId.get(1));//switch to current window
	
	}
	//Action for user name 
	public void user_name(String Name)
	{
		user_name.sendKeys(Name);
	}
	//Action for organization name
	public void orga_Name(String org_Name)
	{
		organization_name.sendKeys(org_Name);
	}
	//Action for phone number
	public void phone_no(String pno)
	{
		contact_no.sendKeys(pno);
	}
	//this method for mail id
	public void email_id(String email)
	{
		official_emailId.sendKeys(email);
	}
	//this method for organization size
	public void orga_size(String org_size)
	{
		Select orgs_size=new Select(organization_size);
		orgs_size.selectByVisibleText(org_size);
	}
	//this method for select interest
	public void user_Interest(String interest)
	{
		Select sl_interest=new Select(InterestedIn);
		sl_interest.selectByVisibleText(interest);
	}
	//this method for submit the form
	public WebElement submit_element()
	{
		WebElement submit_button_wait=wait.until(ExpectedConditions.visibilityOf(submit_button));
		return submit_button_wait;
	}
	//perform the action
	public void submitAction()
	{
		submit_button.click();
	}
	//this method for confirm message element
	public String confirmMessage()
	{
		WebElement confirm_msg=wait.until(ExpectedConditions.visibilityOf(txt_confirm));
		return confirm_msg.getText();
	}
	
}
