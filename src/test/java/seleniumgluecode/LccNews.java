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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class LccNews extends BaseClass{
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
		@Given("^Launch the lancashirecricket App$")
		public void launch_the_lancashirecricket_app() throws Throwable {
		 driver.get(FileReaderManager.getInstance().getCRInstance().getData("LCCURL"));
	    }

	    @Then("^Click on Cricket option to go view circket update$")
	    public void click_on_cricket_option_to_go_view_circket_update() throws Throwable {
	    	 ClickElement(pag.getLancashirecricketPage().getCricketarrowbutton());
	    }
	    
	    
	    @Then("^Click News in the Top navigation  to visit the page$")
	    public void click_news_in_the_top_navigation_to_visit_the_page() throws Throwable {
	    	List <WebElement> Cislementss=	pag.getLancashirecricketPage().getNewsbutton();
	    	for(WebElement ele:Cislementss) {
		    		if(ele.getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/")) {
		    				MoveToElement(ele);
		    		}
	    	}
	    				try {
	    					if(!pag.getLancashirecricketPage().getMaincenterNews().getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/2021-news/lancashire-set-for-vitality-womens-county-t20/")){
	    						ClickElement(pag.getLancashirecricketPage().getMaincenterNews());
	    					}
//	    					else if(!pag.getLancashirecricketPage().getMaincenterNews().getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/2021-news/lancashire-set-for-vitality-womens-county-t20/")) {
//				
//	    						List <WebElement> Cislementss = pag.getLancashirecricketPage().getT20Newsbutton();
//	      
//	    						for(WebElement ele:Cislementss) {
//	    	  
//	    							if(driver.getTitle().equalsIgnoreCase("Lancashire set for Vitality Women's County T20 | Lancashire Cricket Club")) {
//	    								break;
//	    							}
//	    							else if (ele.getAttribute("href").equalsIgnoreCase("https://cricket.lancashirecricket.co.uk/news/2021-news/lancashire-set-for-vitality-womens-county-t20/")){
//	    								ele.click();
//	    							}
//	    	  
//	    						}
//	      
//	    					}
	    					
	    				}
	      
	    				catch(Exception e) {
	    					e.printStackTrace();
	    				}
	       
	    	}

	    @And("^Check Clicked news page is displayed$")
	    public void check_clicked_news_page_is_displayed() throws Throwable {
	    	String t20News =driver.getTitle();
	    	Assert.assertEquals(t20News, "Highlights: Kent vs Lancashire, Day Four | Lancashire Cricket Club");
	    }


}
