package seleniumgluecode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class Bromford extends BaseClass{
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

	@Given("^Launch the  Application BramFord$")
    public void launch_the_application_bramford() throws Throwable {
    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
    	ClickElement(pag.getBram().getCookie());
    	
    }

    @Then("^Click on about us to go to the page$")
    public void click_on_about_us_to_go_to_the_page() throws Throwable {
    	ClickElement(pag.getBram().getAbtUsNav());
    	List <WebElement> Cislementss=	pag.getBram().getAbtUs();
    	for(WebElement ele:Cislementss) {
	    		if(ele.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/about-us/")) {
	    				ClickElement(ele);
	    				break;
	    		}
    	}
    }

    @Then("^Check the about Us Page is dispalyed$")
    public void check_the_about_us_page_is_dispalyed() throws Throwable {
    String AbutUsTitle=driver.getTitle();
    	Assert.assertEquals(AbutUsTitle, "We're a housing association that invests in homes and relationships so people can thrive | Bromford");
    }
	
   
	
    
    
	
}
