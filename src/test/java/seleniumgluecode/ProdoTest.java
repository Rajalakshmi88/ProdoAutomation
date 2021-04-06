package seleniumgluecode;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.DateCache.Tick;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.ConfigFileManager;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;

import pages.FranklinHightownPage;
import runner.TestRunner;

public class ProdoTest extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	public String Windoe;
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
	@Given("^Launch the Franklin Application$")
	public void Launch_the_Franklin_Application() throws Exception {
		
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("FranklinURL"));
		ClickElement(pag.getFranpage().getDismissbutton());
		
	}
	
	 @Then("^Enter username \"([^\"]*)\" and password \"([^\"]*)\" to login into tenant profile$")
	    public void enter_username_something_and_password_something_to_login_into_tenant_profile(String username, String password) throws Throwable {
	        InputvaluesIntoFields(pag.getFranpage().getUsername(), username);
	        InputvaluesIntoFields(pag.getFranpage().getPassword(), password);
	        ClickElement(pag.getFranpage().getLoginsubmit());
	        
	    }
	 
	 @Then("^Click on Account to view Account details$")
	    public void click_on_account_to_view_account_details() throws Throwable {
	        ClickElement(pag.getTenantHome().getTenantAccRadiButton());
	    }

	 
	 @And("^Click on Make payment button to make a payment for House$")
	    public void click_on_make_payment_button_to_make_a_payment_for_house() throws Throwable {
	      Windoe = driver.getWindowHandle();
		 ClickElement(pag.getTenantHome().getMakepayment());
	       
	     
	    }
	 
	 @Then("^Go to Payment Page and enter Customer Reference \"([^\"]*)\" and Amount \"([^\"]*)\"$")
	    public void go_to_payment_page_and_enter_customer_reference_something_and_amount_something(String reference, String amount) throws Throwable {
		 
		String Actualtitle = "Payment Gateway - Payment Details - Recipient";
		String Parentwind = "Account | {{MyHightown}} | Hightown";
		 Set<String> wind = driver.getWindowHandles();
		int WinSize= wind.size();
		 for(String id1:wind) {
		 String Title = driver.switchTo().window(id1).getTitle();
		 System.out.println(Title);
		 }
		 
	      for(String id:wind) {
	    	  if(driver.switchTo().window(id).getTitle().equalsIgnoreCase(Actualtitle)) {
	    		  InputvaluesIntoFields(pag.getTenantPayment().getCustRefernce(), reference);
	    		  InputvaluesIntoFields(pag.getTenantPayment().getAmount(), amount);
	    	  			}
	    	  else if (driver.switchTo().window(id).getTitle().equals(Parentwind)) {
	    		  System.out.println("Home page");
			}
	    	  else {
	    		Assert.assertEquals(id, Actualtitle);
	    	  }
	      }
		 
	 }
	 @Then("^Click Next button to complete the Payment$")
	    public void click_next_button_to_complete_the_payment() throws Throwable {
		 ClickElement(pag.getTenantPayment().getNextButton());
		 
		 driver.switchTo().window(Windoe);
	 }
	 
	 @Then("^Click Repairs option in Home Page$")
	    public void click_repairs_option_in_home_page() throws Throwable {
	       ClickElement(pag.getTenantRepair().getRepairbutton());
	    }
	 
	 @Then("^Click Report Repair button to log the repair$")
	    public void click_report_repair_button_to_log_the_repair() throws Throwable {
	     ClickElement(pag.getTenantRepair().getRepaRepbutton());
	    }
	 
	 @Then("^Click the Bathroom option$")
	    public void click_the_bathroom_option() throws Throwable {
	       ClickElement(pag.getTenantRepair().getBathroomButton());
	    }
	 
	 @And("^Click Toilet Option$")
	    public void click_toilet_option() throws Throwable {
	   List <WebElement> lements = pag.getTenantRepair().getToiletButton();
	   for (WebElement ele:lements) {
		  if( ele.getText().equalsIgnoreCase("Toilet")){
			 ClickElement(ele);
		  }
		   
	   }
	    }
	 
	  @And("^Click Toilet is leaking Option$")
	    public void click_toilet_is_leaking_option() throws Throwable {
		  try {
		  List <WebElement> lementss = pag.getTenantRepair().getToiletLeakButton();
		   for (WebElement elem:lementss) {
			  if( elem.getText().equalsIgnoreCase("Toilet is leaking")){
				 ClickElement(elem);
			  }
			   
		   }
		  }catch(Exception e) {
			  System.out.println("Found match");
		  }
	    }
	  
	  @And("^Click Cistern Option and Submit the Repair$")
	    public void click_cistern_option_and_submit_the_repair() throws Throwable {
		  List <WebElement> Cislementss = pag.getTenantRepair().getCisternButton();
		   for (WebElement elemt:Cislementss) {
			  if( elemt.getText().equalsIgnoreCase("Cistern")){
				 ClickElement(elemt);
				 Boolean founde = true;
				 break;
			  }
			   
		   }
		  // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click()",pag.getTenantRepair().getSubmitButton());
		   //Report a repair | {{MyHightown}} | Hightown
		   String ThanWord = "Report a repair | {{MyHightown}} | Hightown";
		   String Repairsuccues= driver.getTitle();
	
		   Assert.assertEquals(ThanWord, Repairsuccues);
		   
		   try {
			   js.executeScript("arguments[0].click()",pag.getTenantRepair().getHomeButton());
		   }
		   catch(Exception e) {
			   System.out.println("Back to Homepage");
		   }
		   
//		   String ThanWord = "Report a repair | {{MyHightown}} | Hightown";
//		  String Repairsuccues= driver.getTitle();
//
//		//  Assert.assertEquals(ThanWord, Repairsuccues);
//		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		  ClickElement(pag.getTenantRepair().getHomeButton());
		  
	    }

	  
	 
}
