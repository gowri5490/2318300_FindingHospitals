package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import PageObjects.FindDoctorsElements;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelInput;
import utilities.ExcelOutputUtility;

public class TS_002_ValidateFindDoctors extends BaseClass {
	
	FindDoctorsElements find_doc=new FindDoctorsElements(getDriver());
	String sheetName="AllTestCases";
	String sheetName1="TS_002_ValidateFindDoctors";
	
	@Given("Navigate to Find Doctors page")
	public void navigate_doctorspage() {
	   getLogger().info("***************Navigate to Find Doctors page*************");
	   find_doc.findDocPage();
	}

	@When("Send the value to searchbox")
	public void searchbox() throws InterruptedException, IOException {
		getLogger().info("***************Send the value to searchbox*************");
		String[] inputs=ExcelInput.getExcelData();
	    find_doc.findDoctor(inputs[0]);
	}

	@Then("Validate the Doctors Name")
	public void validate_doctorsName() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate the Doctors Name*************");
		List<WebElement>doctors_name=find_doc.doctersName();
		List<WebElement>occupation_type=find_doc.occupations();
		for(int i=0;i<doctors_name.size();i++)
		{
			String doctor_occupation=occupation_type.get(i).getText();
			
			if(doctor_occupation.equals("Dentist"))
			{
				System.out.println("Doctor Name: "+doctors_name.get(i).getText()+" - "+doctor_occupation);
				Assert.assertTrue(true);
				ExcelOutputUtility.setExcelWrite(sheetName1, 0, 0, "Dentist Doctors Name");
			    ExcelOutputUtility.setExcelWrite(sheetName1, i+1, 0,doctors_name.get(i).getText() );
			}
			else
			{
				System.out.println("Occupation Mismatched");
				Assert.assertTrue(false);
			}
			
		}
		ExcelOutputUtility.setExcelWrite(sheetName, 6, 0, "Test Case:4");
	    ExcelOutputUtility.setExcelWrite(sheetName, 7, 0, "DoctorName is validated");
	}

	@Then("Valiadate the Book Free option")
	public void valiadate_the_book_free_option() throws InvalidFormatException, IOException {
		getLogger().info("***************Valiadate the Book Free option*************");
		List<WebElement> bookfree_buttons=find_doc.bookFree();
		boolean result=false;
		for(WebElement button:bookfree_buttons)
		{
			if(button.isEnabled())
			result=true;
			else
			{
				result=false;
				break;
			}
		}
		if(result==true)
		{
			System.out.println("BookFree button is present");
			Assert.assertTrue(true);
			ExcelOutputUtility.setExcelWrite(sheetName, 8, 0, "Test Case:5");
		    ExcelOutputUtility.setExcelWrite(sheetName, 9, 0, "BookFree button is present");
			
		}
		else
		{
			System.out.println("BookFree button is not present");
			Assert.assertTrue(false);
			ExcelOutputUtility.setExcelWrite(sheetName, 8, 0, "Test Case:5");
		    ExcelOutputUtility.setExcelWrite(sheetName, 9, 0, "BookFree button is not present");
		}
	}

}
