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
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MedLoginPOM;
import com.training.pom.RecoverypasswordPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTestAsgnmt1 {

	private WebDriver driver;
	private String baseUrl;
	private RecoverypasswordPOM recoverypassPOM;
	private RegisterPOM registerPOM;
	private LoginPOM loginPOM;
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
		recoverypassPOM = new RecoverypasswordPOM(driver);
		registerPOM = new RegisterPOM(driver);
		loginPOM = new LoginPOM(driver); 
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
	
	@Test ()
	public void validRegTest() {
		homePOM.clickLogInorRegtr();
		registerPOM.clickRegisterTab();
		registerPOM.sendemailId("admin8@gmail.com");
		registerPOM.sendFirstName("admin");
		registerPOM.sendLastName("account");
		registerPOM.clickRegisterBtn();
		registerPOM.RegisterNotificmsg("You have successfully registered to Real Estate. We have emailed your password to the email address you entered.");
		screenShot.captureScreenShot("Firstreg");
	}
	@Test (dependsOnMethods={"validRegTest"})
	public void validLoginTest() {
		homePOM.clickLogInorRegtr();
		loginPOM.sendUserName("suganya@gmail.com");
		loginPOM.sendPassword("suganya@123");
		loginPOM.clickSignInBtn();
		loginPOM.verifyPagetext("My Account");
		screenShot.captureScreenShot("Firstlog");
	}
	@Test (dependsOnMethods={"validRegTest"})
	public void validrocoverPasswordTest() throws InterruptedException {
		homePOM.clickLogInorRegtr();
		Thread.sleep(2000);
		recoverypassPOM.lostPasswordLink();
		recoverypassPOM.sendEmailId("suganya@gmail.com");
		recoverypassPOM.resetPassButton();
		screenShot.captureScreenShot("Firstpassrec");
		recoverypassPOM.testReport();
	}
}