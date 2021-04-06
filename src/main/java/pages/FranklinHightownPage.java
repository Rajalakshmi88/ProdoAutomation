package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FranklinHightownPage{
	
	//Dismissbutton
	@FindBy(how=How.XPATH,using="//*[@class='m-alert-banner__button m-btn m-btn--ghost']")
	private WebElement Dismissbutton;
	
	//Hightown button
	@FindBy(how=How.XPATH,using="(//*[@class='rte_primary_button'])[1]")
	private WebElement HighTownButton;

	//Login username
	@FindBy(how=How.CSS,using="#LoginUsername")
	private WebElement Username;
	
	//Tenant Password
	@FindBy(how=How.CSS,using="#LoginPassword")
	private WebElement Password;
	
	//Login submit Button
	@FindBy(how=How.XPATH,using="(//*[@type='submit'])[1]")
	private WebElement Loginsubmit;
	

	public FranklinHightownPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getHighTownButton() {
		return HighTownButton;
	}

	public WebElement getDismissbutton() {
		return Dismissbutton;
	}
	
	public WebElement getUsername() {
		return Username;
	}
	
	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginsubmit() {
		return Loginsubmit;
	}

}
