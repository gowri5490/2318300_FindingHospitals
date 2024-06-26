package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	 static WebDriver driver;
     static Properties p;
     static Logger logger;
  	     
     public static WebDriver initilizeBrowser() throws IOException{       //initializing browser and os
    	 
    	//This is used for run remote mode
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities = new DesiredCapabilities(); //set the WebDriver
			
			//This is used for run which OS user want
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			
			//browser setup for remote mode
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		//browser setup for local mode
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) {
					case "chrome":
				        driver=new ChromeDriver();
				        break;
				    case "edge":
				    	driver=new EdgeDriver();
				        break;
				    default:
				        System.out.println("No matching browser");
				        driver=null;
				}
			} 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait command

			 return driver;
		 
	     }

     //This method for return the web driver
     public static WebDriver getDriver(){
    	 
		return driver;
	}

     //This method for read the properties file
     public static Properties getProperties() throws IOException{	
    	 
	    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\URL\\URL.properties");
	   		
	    p=new Properties();
		p.load(file); //load the properties file
		return p;
     }

     //This method for store all actions in logger
     public static Logger getLogger() {
    	 
		logger=LogManager.getLogger(); //load Log4j
		return logger;
     }


}
