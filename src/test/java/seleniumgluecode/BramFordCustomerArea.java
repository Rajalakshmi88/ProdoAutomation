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

public class BramFordCustomerArea extends BaseClass{
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
	 @Given("^Launch the Bramford Application$")
	    public void launch_the_bramford_application() throws Throwable {
	    	driver.get(FileReaderManager.getInstance().getCRInstance().getData("BramfordURL"));
	    	
	    }
	 @Then("^Click on Customer Area to go to the page$")
	    public void click_on_customer_area_to_go_to_the_page() throws Throwable {
	    	ClickElement(pag.getBram().getCustomerarea());
	    	
	    		List <WebElement> Cus=	pag.getBram().getCustareaoption();
	    	for(WebElement elem:Cus) {
	    		System.out.println(elem.getAttribute("href"));
	    	
		    		if(elem.getAttribute("href").equalsIgnoreCase("https://www.bromford.co.uk/customer-area/")) {
		    			ClickElement(elem);
		    			break;
		    		}
	    	}
	    }

	    @Then("^Check the Customer Area Page is dispalyed$")
	    public void check_the_customer_area_page_is_dispalyed() throws Throwable {
	    	String CustomerAreaT=driver.getTitle();
	    	Assert.assertEquals(CustomerAreaT, "Welcome to the Bromford customer area | Bromford");

	    }
}
