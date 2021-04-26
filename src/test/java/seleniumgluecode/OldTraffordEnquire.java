package seleniumgluecode;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class OldTraffordEnquire extends BaseClass{
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario Name is :" +name);
	}
	
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	@Given("^Launch the lancashireCC Applicatin$")
    public void launch_the_lancashirecc_applicatin() throws Throwable {
		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
    }

    @Then("^Click on Event option to go Event Update$")
    public void click_on_event_option_to_go_event_update() throws Throwable {
    	ClickElement(pag.getEmirate().getEventsarrButton());
    }

    @Then("^Click Enquire in the Top navigation$")
    public void click_enquire_in_the_top_navigation() throws Throwable {
    	 ClickElement(pag.getEmirate().getEventsEnqButon());
    }

    @And("^Check  Enquire page is displayed$")
    public void check_enquire_page_is_displayed() throws Throwable {
    	String EnqTitle= driver.getTitle();
    	Assert.assertEquals(EnqTitle, "Booking a venue in Manchester | Lancashire County Cricket Club");
    	
    }
	
	
	
}
