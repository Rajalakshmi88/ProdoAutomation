package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Lancashirecricket extends BaseClass {
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
	 @Given("^Launch the lancashirecricket Application$")
	    public void launch_the_lancashirecricket_application() throws Throwable {
		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
	    }

	    @Then("^Click on Cricket option to go view circket updates$")
	    public void click_on_cricket_option_to_go_view_circket_updates() throws Throwable {
	    	 ClickElement(pag.getLancashirecricketPage().getCricketarrowbutton());
	    }

	    @Then("^Click Fixtures & Results in the top nav$")
	    public void click_fixtures_results_in_the_top_nav() throws Throwable {
//	    	
	       MoveToElement(pag.getLancashirecricketPage().getFixtuResultsbut());
	      
	    	}
	    
	    
	    @And("^click any results to visit the page$")
	    public void click_any_results_to_visit_the_page() throws Throwable {
	    	String Actualtitle	= "Lancashire v Northamptonshire, County Championship | Lancashire Cricket Club";
	    	
//		      try {
		    	  
		    	 driver.findElement(By.xpath("//*[@class='results_box']/ul/li[1]")).click();
//		    	 for(WebElement jo:che1) {
//				if(driver.getTitle().equalsIgnoreCase("Lancashire v Northamptonshire, County Championship | Lancashire Cricket Club")) {
//				break;
//				}
//				else if (jo.getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/match-centre/lancashire-v-northamptonshire-2021-county-championship/")) {
//					
//					    		  jo.click();
//					    		System.out.println(  driver.getTitle());
//					    		 
//					    		  }
//					    	 
//					    	  } 
//		    		  
//		    	  }catch(Exception ele1) {
//		    		  ele1.printStackTrace();
//		    	  }
	    }
		  
		      

	    @Then("^Refresh the page 5 times with a 10 second wait in between each refresh$")
	    public void refresh_the_page_5_times_with_a_10_second_wait_in_between_each_refresh() throws Throwable {
	    	
	    	for(int i=1;i<=5;i++) {
	    		driver.navigate().to(driver.getCurrentUrl());
	    		Thread.sleep(10000);
	    	}
	    	String LCCPag= driver.getTitle();
	    	
	    	Assert.assertEquals(LCCPag, "Kent v Lancashire, County Championship | Lancashire Cricket Club");
	    }

   
}
