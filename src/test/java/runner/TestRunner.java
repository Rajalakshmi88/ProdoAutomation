package runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProviders.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/Bromford.feature",
		glue = {"seleniumgluecode"},
		tags = {"@Bram"},
	//	plugin= {"json:TestReports/cucumber.json"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:TestReports/CucumberTestReport.html"},
				monochrome = true
		
		)
public class TestRunner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception{
		String browserName = FileReaderManager.getInstance().getCRInstance().getData("BrowserName");
		driver = BaseClass.getBrowser(browserName);
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
	

}
