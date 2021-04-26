package baseClass;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xalan.templates.ElemApplyImport;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	//Method to get the chromerdriver to run in chrome browser
	public static WebDriver getBrowser(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajalakshmiganesan\\Desktop\\Initail Setup\\ProdoTesting\\src\\test\\java\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				System.out.println("Invalid Browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		return driver;
	}
	
	//Method for explicit wait
	public static void WaitForElementvisibility(WebElement element) {
		try {
			WebDriverWait waits = new  WebDriverWait(driver, 60);
			waits.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to Click the Element
	public static void ClickElement(WebElement element) {
		WaitForElementvisibility(element);
		try {
		element.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Method to enter the values in Text Box Field
	public static void InputvaluesIntoFields(WebElement element,String value) {
		WaitForElementvisibility(element);
		try {
			element.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to get the mouse actions
	public static void MoveToElement(WebElement element) {
		//WaitForElementvisibility(element);
		try {
		Actions Act = new Actions(driver);
		Act.moveToElement(element).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to Select the value from dropdown field
	public static void Selectelement(WebElement element,int index,String value,String option) {
		Select sel = new Select(element);
		if(option.equalsIgnoreCase("value")) {
			sel.selectByValue(value);
		}
		else if (option.equalsIgnoreCase("index")) {
			sel.selectByIndex(Integer.parseInt(value));
		}
	else if (option.equalsIgnoreCase("visibiletext")) {
		sel.selectByVisibleText(value);
		
	}
	}
	
	public static void getScreenshot(WebDriver driver,String Name) throws IOException {
		try {
			TakesScreenshot screen = (TakesScreenshot)driver;
			File file = screen.getScreenshotAs(OutputType.FILE);
			File destfile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+Name+".png");
			FileUtils.copyFile(file, destfile);
		}catch(WebDriverException e) {
			e.printStackTrace();
		}
	}
	
}
