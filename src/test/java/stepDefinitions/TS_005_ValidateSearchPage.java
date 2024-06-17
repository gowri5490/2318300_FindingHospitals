package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import PageObjects.SearchPageElements;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelInput;
import utilities.ExcelOutputUtility;

public class TS_005_ValidateSearchPage extends BaseClass{
	
	SearchPageElements search=new SearchPageElements(getDriver());
	int hsptls_indexSize;
	int ratings_indexSize;
	int cities_size;
	String sheetName="AllTestCases";
	String sheetName4="TS_005_ValidateSearchPage";
	String sheetName5="TS_005_02";
	
	@When("Select Bangalore city and Search Hospitals")
	public void search_hospitals() throws InterruptedException, IOException {
		getLogger().info("**************Select Bangalore city and Search Hospitals**************");
		String[] inputs=ExcelInput.getExcelData();
	    search.searchActionCity(inputs[5]);
	    search.searchActionOption(inputs[6]);
	}

	@Then("Validate Bangalore city hospitals are displayed")
	public void validate_hospitals() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate Bangalore city hospitals are displayed**************");
	    Assert.assertEquals(search.cityHospitalsTitle().contains("Bangalore"),true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 26, 0, "Test Case:14");
	    ExcelOutputUtility.setExcelWrite(sheetName, 27, 0, "City Hospitals are displayed");
	}

	@When("Locate all day opened hospitals element")
	public void locate_openedHospitals() throws InterruptedException, InvalidFormatException, IOException {
		getLogger().info("**************Locate all day opened hospitals element**************");
	    List<Integer> hsptls_index=search.timeDetails();
	    List<WebElement> hsptl_ttles=search.hospitalName();
		System.out.println("===========================================");
		System.out.println("24/7 opening hospitals count: "+hsptls_index.size());
		for(int i=0;i<hsptls_index.size();i++)
		{	
			System.out.println("Hospital Name: "+hsptl_ttles.get(hsptls_index.get(i)).getText());
			ExcelOutputUtility.setExcelWrite(sheetName4, 0, 0, "24/7 opened Hospital names");
		    ExcelOutputUtility.setExcelWrite(sheetName4, i+1, 0,hsptl_ttles.get(hsptls_index.get(i)).getText());
		}
		hsptls_indexSize=hsptls_index.size();
	}

	@Then("Validate all day hospitals opened")
	public void validate_hospitals_isopened() throws InterruptedException, InvalidFormatException, IOException {
		getLogger().info("**************Validate all day hospitals opened**************");
	    Assert.assertEquals(hsptls_indexSize>0,true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 28, 0, "Test Case:15");
	    ExcelOutputUtility.setExcelWrite(sheetName, 29, 0, "Validated 24/7 hospitals opened");
	}

	@When("Get the rating of more than three hospitals")
	public void get_ratedHospitals() throws InvalidFormatException, IOException {
		getLogger().info("**************Get the rating of more than three hospitals**************");
		List<WebElement> hsptl_ttles=search.hospitalName();
	    List<Integer>rating_index=search.ratingDetails() ;
	    System.out.println("===========================================");
		System.out.println("More than 3.5 rated Hospital");
		for(int i=0;i<rating_index.size();i++)
		{
			System.out.println("Hospital Name: "+hsptl_ttles.get(rating_index.get(i)).getText());
			ExcelOutputUtility.setExcelWrite(sheetName5, 0, 0, "More than 3.5 rated Hospitals name");
		    ExcelOutputUtility.setExcelWrite(sheetName5, i+1, 0,hsptl_ttles.get(rating_index.get(i)).getText());
		}
		ratings_indexSize=rating_index.size();
	}

	@Then("Validate the hospitals more than three of rating")
	public void validate_highRatedHospitals() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate the hospitals more then three of rating**************");
	    Assert.assertEquals(ratings_indexSize>0, true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 30, 0, "Test Case:16");
	    ExcelOutputUtility.setExcelWrite(sheetName, 31, 0, "Validate more then 3.5 rated hospitals");
	}

	@When("Get the top city hospitals")
	public void get_cityHospitals() {
		getLogger().info("**************Get the top city hospitals**************");
		List<WebElement> top_cities=search.topCities();
		System.out.println("===========================================");
		System.out.println("Hospitals in Top Cities");
		for(WebElement city:top_cities)
		{
			System.out.println(city.getText());
		}
		cities_size=top_cities.size();
	}

	@Then("Validate top city hospitals")
	public void validate_cityHospitals() throws InvalidFormatException, IOException {
		getLogger().info("**************Validate top city hospitals**************");
	    Assert.assertEquals(cities_size>0, true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 32, 0, "Test Case:17");
	    ExcelOutputUtility.setExcelWrite(sheetName, 33, 0, "Top City hospitals valid");
	}

}
