package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TenantPaymentPage {
		
		//Customer Reference text box in payment page
		@FindBy(how=How.XPATH,using="//*[@class='client-ref']")
		private WebElement CustRefernce;
		
		//Customer Reference text box in payment page
		@FindBy(how=How.XPATH,using="//*[@class='two-digits']")
		private WebElement Amount;
		
		//Next Button
		@FindBy(how=How.XPATH,using="//*[@class='btn btn-primary client-btn']")
		private WebElement NextButton;

		public TenantPaymentPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		
		public WebElement getCustRefernce() {
			return CustRefernce;
		}

		public WebElement getAmount() {
			return Amount;
		}

		public WebElement getNextButton() {
			return NextButton;
		}

}
