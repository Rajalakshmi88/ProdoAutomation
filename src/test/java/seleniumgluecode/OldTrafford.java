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

public class OldTrafford extends BaseClass {
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
	
	 	@Given("^Launch the lancashirecricket Applicatin$")
	    public void launch_the_lancashirecricket_applicatin() throws Throwable {
	 		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
	    }


	    @Then("^Click on Event option to go Events Update$")
	    public void click_on_event_option_to_go_events_update() throws Throwable {
	    	ClickElement(pag.getEmirate().getEventsarrButton());
	    }
	 	
	    @Then("^Click News in the Top navigation$")
	    public void click_news_in_the_top_navigation() throws Throwable {
	    	ClickElement(pag.getEmirate().getEventsNewButon());
	    }


	    @And("^Check news page is displayed$")
	    public void check_news_page_is_displayed() throws Throwable {
	    	String New =driver.getTitle();
	    	Assert.assertEquals(New, "Latest Press Releases and News | Lancashire County Cricket Club");
	    	
	    }

}
