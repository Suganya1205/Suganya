package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddnewpropPOM;
import com.training.pom.CustomerenquiryPOM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MedLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTestAsgnmt1 {

	private WebDriver driver;
	private String baseUrl;
	private CustomerenquiryPOM customerenquiryPOM;
	private AddnewpropPOM addnewPropPOM;
	private LoginPOM loginPOM;
	private MedLoginPOM medloginPOM;
	private HomePOM homePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		customerenquiryPOM = new CustomerenquiryPOM(driver);
		addnewPropPOM = new AddnewpropPOM(driver);
		loginPOM = new LoginPOM(driver);
		medloginPOM = new MedLoginPOM(driver); 
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test 
	public void addNewPropertybyAdmin() throws InterruptedException {
	  homePOM.clickLogInorRegtr(); 
	  medloginPOM.sendUserName("admin");
	  medloginPOM.sendPassword("admin@123"); 
	  medloginPOM.clickSignInBtn();
	  medloginPOM.verifyPageicon(); 
	  addnewPropPOM.Mouseovertoproperties();
	  addnewPropPOM.sendTitle("new launch"); 
	  addnewPropPOM.sendText("new launch");
	  addnewPropPOM.sendPrice("50000.00"); 
	  addnewPropPOM.sendperPrice("200.00");
	  addnewPropPOM.sendnewDetails("New");
	  addnewPropPOM.sendLocDetails("Electronic city");
	  addnewPropPOM.sendpossessionDetails("Immediate");
	  addnewPropPOM.sendaddDetails("Yeshwanthapur");
	  addnewPropPOM.sendgoogleaddDetails("Yeshwanthapur");
	  addnewPropPOM.sendgoogleLat("120"); 
	  addnewPropPOM.sendgoogleLongitude("56");
	  addnewPropPOM.sendstorageValue("2"); 
	  addnewPropPOM.selectbangcheck();
	  addnewPropPOM.clickPublishbutton();
	  addnewPropPOM.verifypostmessage("Post published. View post");
	  screenShot.captureScreenShot("Firstpost");
	  addnewPropPOM.verifyPublishedpost("new launch");
	  screenShot.captureScreenShot("Firstprop"); 
	  addnewPropPOM.testReport(); 
	  }
	 	  
	@Test (dependsOnMethods={"addNewPropertybyAdmin"})
	public void viewAddedPropertybyAdmin() throws InterruptedException {
	  homePOM.clickLogInorRegtr(); 
	  medloginPOM.sendUserName("admin");
	  medloginPOM.sendPassword("admin@123"); 
	  medloginPOM.clickSignInBtn();
	  medloginPOM.verifyPageicon(); 
	  addnewPropPOM.Mouseovertoproperties();
	  addnewPropPOM.sendTitle("new launch for sale");
	  addnewPropPOM.sendText("new launch for sale");
	  addnewPropPOM.clickPublishbutton();
	  addnewPropPOM.verifypostmessage("Post published. View post");
	  addnewPropPOM.verifyPublishedpost("new launch for sale");
	  screenShot.captureScreenShot("Firstpropview"); 
	  addnewPropPOM.testReport(); 
	  }  
	
	@Test 
	public void CustomerViewEnquireandCalculateLoan() throws InterruptedException {
		homePOM.clickLogInorRegtr();
	  loginPOM.sendUserName("suganya@gmail.com");
	  loginPOM.sendPassword("suganya@123"); 
	  loginPOM.clickSignInBtn();
	  loginPOM.verifyPagetext("My Account"); 
	  Thread.sleep(2000); 
	  customerenquiryPOM.Mouseovertotitle();
	  screenShot.captureScreenShot("Firstimg2");
	  customerenquiryPOM.scrollToViewEnquiry();
	  customerenquiryPOM.enterName("Selenium");
	  customerenquiryPOM.enterEmail("selenium@gmail.com");
	  customerenquiryPOM.enterSubject("Appartment");
	  customerenquiryPOM.enterMessage("Looking for appartments");
	  customerenquiryPOM.verifySentmessage("Thanks for your message. It has been sent.");
	  screenShot.captureScreenShot("FirstEnq");
	  customerenquiryPOM.scrollToViewCalc();
	  customerenquiryPOM.enterSaleprice("40000");
	  customerenquiryPOM.enterDownpayment("2000");
	  customerenquiryPOM.enterLoanterm("2");
	  customerenquiryPOM.enterInterestrate("5");
	  Thread.sleep(2000); 
	  customerenquiryPOM.verifyPaymentmesg("Monthly Payment: 1667.11 Rs.");
	  screenShot.captureScreenShot("FirstPC"); 
	  }
}