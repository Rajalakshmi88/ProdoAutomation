package dataProviders;

import org.openqa.selenium.WebDriver;

import pages.BromfordPage;
import pages.FranklinHightownPage;
import pages.LancashirecricketPage;
import pages.OldTraffordPage;
import pages.TenantHomePage;
import pages.TenantPaymentPage;
import pages.TenantRepairPage;

public class PageObjectManager {
	public static WebDriver driver;
	private FranklinHightownPage Franpage ;
	private TenantHomePage TenantHome;
	private TenantPaymentPage Payment;
	private TenantRepairPage Repair;
	private LancashirecricketPage Lcc;
	private OldTraffordPage Emirate;
	private BromfordPage Bram;
	
	
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
	
	public LancashirecricketPage getLancashirecricketPage() {
		Lcc = new  LancashirecricketPage(driver);
		return Lcc;
	}
	public OldTraffordPage getEmirate() {
		
		Emirate = new OldTraffordPage(driver);
		return Emirate;
	}
	
	public BromfordPage getBram() {
		
		Bram = new BromfordPage(driver);
		return Bram;
	}

}
