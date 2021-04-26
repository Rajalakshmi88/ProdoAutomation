package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OldTraffordPage {
	 	//Events arrow button
		@FindBy(how=How.XPATH,using="//*[@class='landing-block columns events']/div//div")
		private WebElement EventsarrButton;
	   
		//Events page News Nav option
		@FindBy(how=How.XPATH,using="//*[@class='mega_nav']/ul/li[5]/a")
		private WebElement EventsNewButon;
		
		//Enquire Nav Option
		@FindBy(how=How.XPATH,using="//*[@class='enquire_button']")
		private WebElement EventsEnqButon;
		
		
		
		public OldTraffordPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}

		public WebElement getEventsarrButton() {
			return EventsarrButton;
		}

		public WebElement getEventsNewButon() {
			return EventsNewButon;
		}

		public WebElement getEventsEnqButon() {
			return EventsEnqButon;
		}
		
}
