package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//this is used for Junit runner class to run Cucumber tests
@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features"},
					
				//features= {".//Features/TS_001_HomePage.feature"},
//					features= {".//Features/TS_002_FindDoctorsPage.feature"},
//					features= {".//Features/TS_003_VideoConsultPage.feature"},
//					features= {".//Features/TS_004_SurgeriesPage.feature"},
//					features= {".//Features/TS_005_SearchPage.feature"},
//					features= {".//Features/TS_006_CorporateWellnessForm.feature"},
				//features= {"@target/rerun.txt"},
				
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
		)
//For running the Cucumber tests
public class TestRunner {

		}

