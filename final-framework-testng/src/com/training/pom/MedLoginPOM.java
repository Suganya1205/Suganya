package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MedLoginPOM {
	private WebDriver driver; 
	private boolean b;
	
	public MedLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement signInBtn; 
	
	@FindBy(partialLinkText ="Dashboard")
	private WebElement verifyPageicon; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickSignInBtn() {
		this.signInBtn.click(); 
	}

	public void verifyPageicon() {
		this.verifyPageicon.getText();
		System.out.println(verifyPageicon.getText());
		verifyPageicon.getText().equals("Dashboard");
		System.out.println("Admin Login Successful");
		}
}
