package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import PageObjects.VideoConsultElements;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelOutputUtility;

public class TS_003_ValidateVideoConsult extends BaseClass{
	
	VideoConsultElements video=new VideoConsultElements(getDriver());
	boolean Con_result;
	int specialities_size;
	int commonHealthConcerns_size;
	int offers_size;
	String sheetName="AllTestCases";
	String sheetName2="TS_003_ValidateVideoConsult";
	
	@Given("Navigate to video Consult page")
	public void navigate_to_video_consult_page() {
		getLogger().info("***************Navigate to video Consult page*************");
	    video.videoConsultAction();
	}

	@When("Locate the video consult element")
	public boolean video_consult() {
		getLogger().info("***************Locate the video consult element*************");
	    Con_result=video.isConsultEnabled();
	    return Con_result;
	}

	@Then("Validate Consult Now button is present")
	public void validate_consult_now() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate Consult Now button is present*************");
	    Assert.assertEquals(video_consult(),true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 10, 0, "Test Case:6");
	    ExcelOutputUtility.setExcelWrite(sheetName, 11, 0, "Consult Now button is present");
	}

	@When("Get all specialities datas")
	public void specialities_data() throws InvalidFormatException, IOException {
		getLogger().info("***************Get all specialities datas*************");
	    List<WebElement> specialities_element=video.specialities();
		System.out.println("===================================");
		System.out.println("Top Specialities");
		int i=0;
		for(WebElement Speciality:specialities_element)
		{
			System.out.println(Speciality.getText());
			ExcelOutputUtility.setExcelWrite(sheetName2, 0, 0, "Specialities");
		    ExcelOutputUtility.setExcelWrite(sheetName2, i+1, 0,Speciality.getText());
		    i++;
		}
		specialities_size=specialities_element.size();
		
	}

	@Then("Validate specialities availability")
	public void validate_specialities() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate specialities availability*************");
		Assert.assertEquals(specialities_size>0, true);
		ExcelOutputUtility.setExcelWrite(sheetName, 12, 0, "Test Case:7");
	    ExcelOutputUtility.setExcelWrite(sheetName, 13, 0, "Specialities data is present");
	}

	@When("Get all Common Health Concern datas and price")
	public void health_concern_datas() {
		getLogger().info("***************Get all Common Health Concern datas and price*************");
		List<WebElement> commonHealthConcerns=video.commonHealthConcern();
		List<WebElement> healthConcernPrice=video.concernPrice();
		System.out.println("===================================");
		System.out.println("Common Health Concerns");
		for(int i=0;i<4;i++)
		{
			System.out.println(commonHealthConcerns.get(i).getText()+" - "+healthConcernPrice.get(i).getText());
		}
		commonHealthConcerns_size=commonHealthConcerns.size();
	}

	@Then("Validate CommonHealthConcern availability")
	public void validate_common_health_concern_availability() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate CommonHealthConcern availability*************");
		 Assert.assertEquals(commonHealthConcerns_size>0,true);
		 ExcelOutputUtility.setExcelWrite(sheetName, 14, 0, "Test Case:8");
		 ExcelOutputUtility.setExcelWrite(sheetName, 15, 0, "CommonHealthConcern is present");
	}
	
	@When ("Get all Offer details")
	public void offer_datas()
	{
		getLogger().info("***************Get all Offer details*************");
		List<WebElement>offers=video.consultOffers();
		System.out.println("===================================");
		System.out.println("Offers");
		for(WebElement offer:offers)
			System.out.println(offer.getText());
		offers_size= offers.size();
	}

	@Then("Validate Consult Offers availability")
	public void validate_consult_offers_availability() throws InvalidFormatException, IOException {
		getLogger().info("***************Validate Consult Offers availability*************");
	    Assert.assertEquals(offers_size>0,true);
	    ExcelOutputUtility.setExcelWrite(sheetName, 16, 0, "Test Case:9");
	    ExcelOutputUtility.setExcelWrite(sheetName, 17, 0, "Offers is present");
	}


}
