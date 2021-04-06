package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TenantRepairPage {
	
	//Tenant Repair Radio button
			@FindBy(how=How.XPATH,using="//*[@title='Repairs']")
			private WebElement Repairbutton;
			
			
	//Report Repair button
			@FindBy(how=How.XPATH,using="//*[@id='button--repair-cta-link']")
			private WebElement RepaRepbutton;
			
	//Bathroom button	
			
			@FindBy(how=How.XPATH,using="(//*[@class='m-filter__button_text'])[1]")
			private WebElement BathroomButton;
	
	//Toilet button	
			
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-filter__listitem js-job_item u-hidden u-visible']"))
			private List<WebElement> ToiletButton;
			
			
	//Toilet is leaking button	
			
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-filter__listitem']"))
			private List<WebElement> ToiletLeakButton;	
					
	
	//Cistern button	
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-filter__listitem']"))
			private List<WebElement> CisternButton;	
						
			
	//Submit button	
			@FindBy(how=How.XPATH,using="//*[@type='submit']")
			private WebElement submitButton;	

			
	//Home button	
			@FindBy(how=How.XPATH,using="(//*[@class='m-btn m-btn--primary m-btn--full'])[1]")
			private WebElement homeButton;				
	
					
	public TenantRepairPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
		
	}
	

	public WebElement getHomeButton() {
		return homeButton;
	}


	public WebElement getRepairbutton() {
				return Repairbutton;
			}


	public WebElement getSubmitButton() {
		return submitButton;
	}


	public WebElement getRepaRepbutton() {
				return RepaRepbutton;
			}
	
	public WebElement getBathroomButton() {
		return BathroomButton;
	}


	public List<WebElement> getToiletButton() {
		return ToiletButton;
	}
	
	public List<WebElement> getToiletLeakButton() {
		return ToiletLeakButton;
	}

	public List<WebElement> getCisternButton() {
		return CisternButton;
	}

}
