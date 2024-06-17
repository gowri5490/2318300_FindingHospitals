package stepDefinitions;



import PageObjects.PractoHomePageElements;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelOutputUtility;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

public class TS_001_ValidatePractoHomePage extends BaseClass{
	
	PractoHomePageElements home_page=new PractoHomePageElements(getDriver());
	String sheetName="AllTestCases";
	
	@When("Locate the Practo Logo Element")
	public boolean practo_logo_element() {
		getLogger().info("***************Locate the Practo Logo Element*************");
		boolean logo_result=home_page.isLogoPresent();
	    return logo_result;
	}

	@Then("Validate the Practo Logo is present")
	public void validate_the_practo_logo_is_present() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate the Practo Logo is present*************");
	    Assert.assertEquals(practo_logo_element(),true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 0, 0, "Test Case:1");
	    ExcelOutputUtility.setExcelWrite(sheetName, 1, 0, "Practo Logo is present");
	}

	@When("Locate the Login button Element")
	public boolean login_button_element() {
		getLogger().info("***************Locate the Login button Element*************");
	    boolean login_result=home_page.isLoginButtonPresent();
	    return login_result;
	}

	@Then("Validate the Login is present")
	public void validate_the_login_is_present() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate the Login button is present*************");
	    Assert.assertEquals(login_button_element(),true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 2, 0, "Test Case:2");
	    ExcelOutputUtility.setExcelWrite(sheetName, 3, 0, "Login is present");
	    
	}

	@When("Locate the Download Element")
	public boolean download_element() {
		getLogger().info("***************Locate the Download Element*************");
	    boolean dwld_result=home_page.isDownloadPresent();
	    return dwld_result;
	}

	@Then("Validate the download is present")
	public void validate_the_download_is_present() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate the download is present**************");
	    Assert.assertEquals(download_element(), true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 4, 0, "Test Case:3");
	    ExcelOutputUtility.setExcelWrite(sheetName, 5, 0, "Download is present");
	}
}
