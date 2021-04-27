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

public class BramfordNews extends BaseClass{
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
	@Given("^Launch the Bramford Application Website$")
    public void launch_the_bramford_application_website() throws Throwable {
	    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
	    	
	    }
	 @Then("^Click news to go to the page$")
	    public void click_news_to_go_to_the_page() throws Throwable {
	    	ClickElement(pag.getBram().getNewsNav());
	    	List <WebElement> New=	pag.getBram().getNewsoption();
	    	for(WebElement elemt:New) {
	    		System.out.println(elemt.getAttribute("href"));
	    	
		    		if(elemt.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/news/")) {
		    			ClickElement(elemt);
		    			break;
		    		}
	    	}
	    }

	    @Then("^Check the News Page is dispalyed$")
	    public void check_the_news_page_is_dispalyed() throws Throwable {
	    	String NewsTitle=driver.getTitle();
	    	Assert.assertEquals(NewsTitle, "News | Bromford");

	   
	    }

}
