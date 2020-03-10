package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RecoverypasswordPOM {
	private WebDriver driver; 
	
	public RecoverypasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Lost Your Password?")
	private WebElement lostpassword;
	
	@FindBy(id="user_login")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@class='lostpassword-button']")
	private WebElement resetPassBtn; 
	
	
	public void lostPasswordLink() {
		this.lostpassword.click(); 
	}
	
	public void sendEmailId(String emailId) {
		this.emailId.click();
		this.emailId.sendKeys("suganya@gmail.com");
	}
	
	public void resetPassButton() {
		this.resetPassBtn.click();
}	
	public void testReport() {
		Reporter.log("Clicking upon reset password button, system is giving error message 'The email could not be sent. Possible reason: your host may have disabled the mail() function.'");
		Reporter.log("Hence the further test cases are not automated.");
	}
	
	}