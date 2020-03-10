package com.training.pom;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerTab;
	
	@FindBy(id="email")
	private WebElement emailId; 
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(className="register-button")
	private WebElement registerBtn; 
	
	@FindBy(xpath="//html/body/div[1]/div[4]/div/article/div/div/div/div[1]")
	private WebElement registerNotificmsg; 
	
	public void clickRegisterTab() {
		this.registerTab.click(); 
	}
	
	public void sendemailId(String emailId) {
		this.emailId.clear();
		this.emailId.sendKeys(emailId);
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.clear(); 
		this.firstName.sendKeys(firstName); 
	}
		
	public void sendLastName(String lastName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lastName);
	}
	
	public void clickRegisterBtn() {
		this.registerBtn.click(); 
	}
	public void RegisterNotificmsg() {
		this.registerNotificmsg.getText();
		System.out.println(registerNotificmsg.getText());
		Assert.assertEquals(registerNotificmsg.getText(),"You have successfully registered to Real Estate. We have emailed your password to the email address you entered.");
			System.out.println("Successfully Registered");		
		}
}
