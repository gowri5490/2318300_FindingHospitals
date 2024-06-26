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
	
	//Action for Practo page logo
	public boolean isLogoPresent()
	{
		BasePage.highlightElement(jse, logo_icon);
		return logo_icon.isDisplayed();
	}
	
	//Action for login button option
	public boolean isLoginButtonPresent()
	{
		BasePage.highlightElement(jse, login_button);//highlight the element
		return login_button.isDisplayed();
	}
	//Action for download option
	public boolean isDownloadPresent()
	{
		jse.executeScript("arguments[0].scrollIntoView(true);",download_option);//scroll the page till the web element
		wait.until(ExpectedConditions.visibilityOf(download_option));//usage part of the explicit wait
		BasePage.highlightElement(jse, download_option);//highlight the element
		return download_option.isDisplayed();
	}
	//Action for corporate wellness form page
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
		wait.until(ExpectedConditions.visibilityOf(user_name));
		user_name.sendKeys(Name);
	}
	//Action for organization name
	public void orga_Name(String org_Name)
	{
		wait.until(ExpectedConditions.visibilityOf(organization_name));
		organization_name.sendKeys(org_Name);
	}
	//Action for phone number
	public void phone_no(String pno)
	{
		wait.until(ExpectedConditions.visibilityOf(contact_no));
		contact_no.sendKeys(pno);
	}
	//Action for mail id
	public void email_id(String email)
	{
		wait.until(ExpectedConditions.visibilityOf(official_emailId));
		official_emailId.sendKeys(email);
	}
	//Action for organization size
	public void orga_size(String org_size)
	{
		wait.until(ExpectedConditions.visibilityOf(organization_size));
		Select orgs_size=new Select(organization_size);
		orgs_size.selectByVisibleText(org_size);
	}
	//Action for select interest
	public void user_Interest(String interest)
	{
		wait.until(ExpectedConditions.visibilityOf(InterestedIn));
		Select sl_interest=new Select(InterestedIn);
		sl_interest.selectByVisibleText(interest);
	}
	//Action for submit the form
	public WebElement submit_element()
	{
		wait.until(ExpectedConditions.visibilityOf(submit_button));
		return submit_button;
	}
	//Action for submit form
	public void submitAction()
	{
		submit_button.click();
	}
	//Action for confirm message
	public String confirmMessage()
	{
		wait.until(ExpectedConditions.visibilityOf(txt_confirm));
		return txt_confirm.getText();
	}
	
}
