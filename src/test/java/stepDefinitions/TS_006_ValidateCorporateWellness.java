package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import PageObjects.PractoHomePageElements;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelInput;
import utilities.ExcelOutputUtility;


public class TS_006_ValidateCorporateWellness extends BaseClass{
	
	PractoHomePageElements practo=new PractoHomePageElements(getDriver());
	String[] inputs;
	String sheetName="AllTestCases";
	
	@Given("Click on Corporate Wellness Form")
	public void clickOnCorporateWellnessForm() {
		getLogger().info("**************Click on Corporate Wellness Form**************");
		practo.corporateWellnessAction();
	}

	@Given("Enter the name")
	public void enterTheName() throws IOException {
		getLogger().info("**************Enter the name**************");
		inputs=ExcelInput.getExcelData();
	    practo.user_name(inputs[1]);
	}

	@Given("Enter the Organization name")
	public void enterTheOrganizationName() {
		getLogger().info("**************Enter the Organization name**************");
	    practo.orga_Name(inputs[2]);
	}

	@Given("selects the organization size")
	public void selectTheOrganizationSize() {
		getLogger().info("**************selects the organization size**************");
	    practo.orga_size(inputs[3]);
	}

	@Given("select the Interested in option")
	public void selectTheInterestedInOption() {
		getLogger().info("**************select the Interested in option**************");
	    practo.user_Interest(inputs[4]);
	}

	@When("user enter the contact number as {string}")
	public void enter_contact_number_as(String number) {
		getLogger().info("**************user enter the contact number**************");
	    practo.phone_no(number);
	}

	@When("user enter the email id as {string}")
	public void enter_email_id_as(String email) {
	   getLogger().info("**************user enter the email id **************");
	   practo.email_id(email); 
	}

	@When("Login button should be Disabeld")
	public void loginButtonShouldBeDisabeld() {
	   getLogger().info("**************Login button should be Disabeld**************");
	   Assert.assertEquals(practo.submit_element().isEnabled(), false);
	}

	@Then("Login button should be enabeld")
	public void loginButtonShouldBeEnabeld() throws InterruptedException, InvalidFormatException, IOException {
	   getLogger().info("**************Login button should be enabeld**************");
	   practo.submitAction();
	   Thread.sleep(50000);
	   System.out.println(practo.confirmMessage());
	   Assert.assertEquals(practo.confirmMessage(),"THANK YOU");
	   ExcelOutputUtility.setExcelWrite(sheetName, 34, 0, "Test Case:18");
	   ExcelOutputUtility.setExcelWrite(sheetName, 35, 0, "CorporateWellness form valid");
	}
}
