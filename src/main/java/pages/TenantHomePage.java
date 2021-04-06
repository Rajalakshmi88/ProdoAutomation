package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TenantHomePage {

	
	//Tenant Account radiobutton
		@FindBy(how=How.XPATH,using="//*[@class='m-navigation__link 'and @title='Account']")
		private WebElement TenantAccRadiButton;
	
		
		
	//Tenant Repairs radiobutton
		@FindBy(how=How.XPATH,using="//*[@class='m-navigation__link active']")
		private WebElement TenantRepairButton;	
		
	
	//Tenant Make payment button
		@FindBy(how=How.XPATH,using="//*[@id='button--rent-make-a-payment']")
		private WebElement Makepayment;
		



	public TenantHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getTenantAccRadiButton() {
		return TenantAccRadiButton;
	}
	
	public WebElement getTenantRepairButton() {
		return TenantRepairButton;
	}


	public WebElement getMakepayment() {
			return Makepayment;
	}

}
