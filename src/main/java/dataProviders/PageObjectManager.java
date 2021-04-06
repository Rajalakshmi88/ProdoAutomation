package dataProviders;

import org.openqa.selenium.WebDriver;

import pages.FranklinHightownPage;
import pages.TenantHomePage;
import pages.TenantPaymentPage;
import pages.TenantRepairPage;

public class PageObjectManager {
	public static WebDriver driver;
	private FranklinHightownPage Franpage ;
	private TenantHomePage TenantHome;
	private TenantPaymentPage Payment;
	private TenantRepairPage Repair;
	
	
	public PageObjectManager(WebDriver driver1) {
		this.driver=driver1;
		
	}
	public FranklinHightownPage getFranpage() {
		Franpage = new FranklinHightownPage(driver);
		return Franpage;
	}
	
	public TenantHomePage getTenantHome() {
		TenantHome = new TenantHomePage(driver);
		return TenantHome;
	}
	
	public TenantPaymentPage getTenantPayment() {
		Payment = new TenantPaymentPage(driver);
		return Payment;
	}
	
	public TenantRepairPage getTenantRepair() {
		Repair = new TenantRepairPage(driver);
		return Repair;
	}
	

}