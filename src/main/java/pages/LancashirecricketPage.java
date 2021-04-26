package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LancashirecricketPage {
	//Cricket arrow button
	@FindBy(how=How.XPATH,using="//*[@class='landing-block columns cricket']/div//div")
	private WebElement Cricketarrowbutton;
	
	//Fixtures & Results Nav option
	@FindBy(how=How.XPATH,using="//*[@class='selected has_mega ']/a/div/span[text()='Fixtures & Results']")
	private WebElement FixtuResultsbut;
	
	//News Nav option
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='site_nav left_nav']//li/a"))
	private List<WebElement> Newsbutton;
	
	//T20 News option link
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='mega_menu subnav_wrapper news_mega']/div/div/div/a"))
	private List<WebElement> t20Newsbutton;
	
	//Main News option link
	@FindBy(how=How.XPATH,using="//*[@class='news_item big_news_item']")
	private WebElement MaincenterNews;
	
	
	//Results link under Fixtures & Results
	@FindBys( @FindBy(how=How.XPATH,using="//*[@class='results_box']/ul/li"))
	private List<WebElement> Rsults;
	
	//ViewAll link under news
	@FindBy(how=How.XPATH,using="//*[@class='btn btn_news_readall']")
	private WebElement ViewAllButton;
    
   
	
	public LancashirecricketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getViewAllButton() {
		return ViewAllButton;
	}


	public WebElement getMaincenterNews() {
		return MaincenterNews;
	}
	
	public List<WebElement> getT20Newsbutton() {
		return t20Newsbutton;
	}



	public List<WebElement> getRsults() {
		return Rsults;
	}


	public List<WebElement> getNewsbutton() {
		return Newsbutton;
	}


	public WebElement getCricketarrowbutton() {
		return Cricketarrowbutton;
	}


	public WebElement getFixtuResultsbut() {
		return FixtuResultsbut;
	}
}
