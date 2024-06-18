package stepDefinitions;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	 WebDriver driver;
	 Properties p;
	 
    
	@Before
   public void setup() throws IOException
   {
   	driver=BaseClass.initilizeBrowser();
   	    	
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("Test_URL"));
   	driver.manage().window().maximize();
   	BaseClass.getLogger().info("Website is opened");
   
   			
	}
	
	@AfterStep
	   public void addScreenshot(Scenario scenario) {
	       
	       	TakesScreenshot ts=(TakesScreenshot) driver;
	       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	       	scenario.attach(screenshot, "image/png",scenario.getName());
	       	BaseClass.getLogger().info("Taking screenshot"); 	
	       	         
	   }
		
	@After 
	   public void tearDown(Scenario scenario){
		   		
	      driver.quit();
	  	
	   }
	   
   

   
}
