package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import PageObjects.SurgeriesElements;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelOutputUtility;

public class TS_004_ValidateSurgeries extends BaseClass{
	
	SurgeriesElements surgery=new SurgeriesElements(getDriver());
	int surgeries_Size;
	int departments_size;
	int benifits_size;
	String sheetName="AllTestCases";
	String sheetName3="S_004_ValidateSurgeries";
	
	@Given("Navigate to Surgeries Page")
	public void surgeries_page() {
		getLogger().info("***************Navigate to Surgeries Page*************");
	    surgery.surgeriesAction();
	}

	@When("Get PractoCare Phone number")
	public String get_phone_number() {
		getLogger().info("***************Get PractoCare Phone number*************");
	    return surgery.practoCare(); 
	}

	@Then("Validate the Phone number")
	public void validate_phoneNumber() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate the Phone number*************");
		System.out.println("===========================");
		System.out.println("Validate phone number");
		String p_no=get_phone_number();
		if(p_no.matches("^[0-9]+$")&&p_no.length()==11)
		{
			System.out.println("Valid mobile number");
			Assert.assertTrue(true);
			ExcelOutputUtility.setExcelWrite(sheetName, 18, 0, "Test Case:10");
		    ExcelOutputUtility.setExcelWrite(sheetName, 19, 0, "Mobile Number valid");
		}
		else
		{
			System.out.println("Mobile number not valid");
			Assert.assertTrue(false);
			ExcelOutputUtility.setExcelWrite(sheetName, 18, 0, "Test Case:10");
		    ExcelOutputUtility.setExcelWrite(sheetName, 19, 0, "Mobile Number not valid");
		}  
	}

	@When("Get Popular Surgeries data")
	public void get_surgeriesData() throws InvalidFormatException, IOException {
		getLogger().info("***************Get Popular Surgeries data*************");
		List<WebElement> surgeries_list=surgery.popularSurgeries();
		System.out.println("===========================");
		System.out.println("Popular Surgeries");
		int i=0;
		for(WebElement surgery:surgeries_list)
		{
			System.out.println(surgery.getText());
			ExcelOutputUtility.setExcelWrite(sheetName3, 0, 0, "Popular Surgeries");
		    ExcelOutputUtility.setExcelWrite(sheetName3, i+1, 0,surgery.getText());
		    i++;
		}
		surgeries_Size=surgeries_list.size();
	}

	@Then("Validate the Popular Surgeries")
	public void validate_the_popular_surgeries() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate the Popular Surgeries**************");
	    Assert.assertEquals(surgeries_Size>0, true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 20, 0, "Test Case:11");
	    ExcelOutputUtility.setExcelWrite(sheetName, 21, 0, "Popular Surgeries are available");
	}

	@When("Get Our Departments data")
	public void get_ourDepartmentsData() {
		getLogger().info("**************Get Our Departments data**************");
		List<WebElement> departments=surgery.ourDepartments();
		System.out.println("===========================");
		System.out.println("Our Departments");
		for(WebElement department:departments)
		{
			System.out.println(department.getText());
		}
		departments_size=departments.size();
	}

	@Then("Valiadate the Our Departments")
	public void valiadate_the_our_departments() throws InvalidFormatException, IOException {
		getLogger().info("**************Valiadate the Our Departments**************");
	    Assert.assertEquals(departments_size>0, true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 22, 0, "Test Case:12");
	    ExcelOutputUtility.setExcelWrite(sheetName, 23, 0, "OurDepartments present");
	}

	@When("Get the PractoCare Benifits Data")
	public void get_benifits_data() {
		getLogger().info("**************Get the PractoCare Benifits Data**************");
		List<WebElement> benifits_element=surgery.practoCareBenifits();
		System.out.println("===========================");
		System.out.println("Practo Care Benefits");
		for(WebElement benefit:benifits_element)
		{
			System.out.println(benefit.getText());
		}
		benifits_size=benifits_element.size();
	}

	@Then("Validate PractoCare Data availability")
	public void validate_dataAvailability() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate PractoCare Data availability**************");
	    Assert.assertEquals(benifits_size>0, true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 24, 0, "Test Case:13");
	    ExcelOutputUtility.setExcelWrite(sheetName, 25, 0, "PractoCare availability validated");
	}

}
