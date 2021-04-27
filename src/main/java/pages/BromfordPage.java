package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BromfordPage {
	
	//Cookies
	
	@FindBy(how=How.XPATH,using="//*[@id='onetrust-accept-btn-handler']")
	private WebElement Cookie;
	
	//About Us Nav
	@FindBy(how=How.XPATH,using="//*[@data-link='About us']")
	private WebElement AbtUsNav;
	
	

	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='site-dropdown js-megamenu active']/ul/li/a"))
	private List<WebElement> AbtUs;
	
	
	@FindBys(@FindBy(how=How.XPATH,using="(//*[@class='site-dropdown js-megamenu active']/ul)[3]/li/a"))
	private List<WebElement> custareaoption;
	
	@FindBys(@FindBy(how=How.XPATH,using="(//*[@class='site-dropdown js-megamenu active']/ul)[4]/li/a"))
	private List<WebElement> Newsoption;
	
	
	//Customer Area Nav
	@FindBy(how=How.XPATH,using="//*[@data-link='Customer area']")
	private WebElement Customerarea;
	
	//News Nav 
	@FindBy(how=How.XPATH,using="//*[@data-link='News']")
	private WebElement NewsNav;
	
	
	public BromfordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getAbtUsNav() {
		return AbtUsNav;
	}


	public WebElement getCustomerarea() {
		return Customerarea;
	}

	
	
	public WebElement getCookie() {
		return Cookie;
	}


	public WebElement getNewsNav() {
		return NewsNav;
	}
	
	public List<WebElement> getAbtUs() {
		return AbtUs;
		
	}


	public List<WebElement> getCustareaoption() {
		return custareaoption;
	}


	public List<WebElement> getNewsoption() {
		return Newsoption;
	}

	
	
	
}
