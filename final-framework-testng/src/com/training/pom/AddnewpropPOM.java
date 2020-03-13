package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddnewpropPOM {
	private WebDriver driver; 
	
	public AddnewpropPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText="Properties")
	private WebElement propertieslink;
		
	@FindBy(linkText="Add New")
	private WebElement addnewLink;
	
	@FindBy(name="post_title")
	private WebElement enterTitle;
	
	@FindBy(name="content")
	private WebElement enterText;
	
	@FindBy(id="_price")
	private WebElement priceTextbox;
	
	@FindBy(id="_price_per")
	private WebElement priceSqrTextbox;
	
	@FindBy(id="ui-id-2")
	private WebElement maindetailsTab;
	
	@FindBy(id="_status")
	private WebElement statusField;
	
	@FindBy(id="_location")
	private WebElement locationField;
	
	@FindBy(id="_possession")
	private WebElement possionField;
	
	@FindBy(id="ui-id-3")
	private WebElement locationTab;
	
	@FindBy(id="_friendly_address")
	private WebElement address;
	
	@FindBy(id="_address")
	private WebElement googleAddress;
	
	@FindBy(id="_geolocation_lat")
	private WebElement googleLatitude;
	
	@FindBy(id="_geolocation_long")
	private WebElement googleLongitude;	
	
	@FindBy(id="ui-id-4")
	private WebElement detailsTab;
	
	@FindBy(name="_storage_room")
	private WebElement storageroomValue;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/form/div/div/div[3]/div[1]/div[5]/div/div/div[2]/div/div[2]/ul/li[4]/ul/li[3]/label/input")
	private WebElement centralBangcbox;
	
	@FindBy(id="publish")
	private WebElement publishButton;	
	
	@FindBy(id="message")
	private WebElement verifyMessage;
	
	@FindBy(linkText="All Properties")
	private WebElement allPropTab;
	
	@FindBy(className="row-title")
	private WebElement addedProp;
	
	
		public void Mouseovertoproperties() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(propertieslink).build().perform();
		act.moveToElement(addnewLink).build().perform();
		act.click(addnewLink).build().perform(); 
		Thread.sleep(2000);
		}
		public void sendTitle(String enterTitle) {
		this.enterTitle.click();
		this.enterTitle.sendKeys(enterTitle);
		}
		public void sendText(String enterText) {
		this.enterText.click();
		this.enterText.sendKeys(enterText);
		}		
		public void sendPrice(String enterPrice) {
		this.priceTextbox.click();
		this.priceTextbox.sendKeys(enterPrice);
		}
		public void sendperPrice(String enterperPrice) {
		this.priceSqrTextbox.click();
		this.priceSqrTextbox.sendKeys(enterperPrice);
		}
		public void sendnewDetails(String newdetails) {
		this.maindetailsTab.click();
		this.statusField.click();
		this.statusField.sendKeys(newdetails);
		}
		public void sendLocDetails(String locdetails) {
		this.locationField.click();
		this.locationField.sendKeys(locdetails);
		}
		public void sendpossessionDetails(String possdetails) {
		this.possionField.click();
		this.possionField.sendKeys(possdetails);
		}
		public void sendaddDetails(String adddetails) {
		this.locationTab.click();
		this.address.click();
		this.address.sendKeys(adddetails);
		}
		public void sendgoogleaddDetails(String googleadddetails) {
		this.googleAddress.click();
		this.googleAddress.sendKeys(googleadddetails);
		}
		public void sendgoogleLat(String googleLat) {
		this.googleLatitude.click();
		this.googleLatitude.sendKeys(googleLat);
		}
		public void sendgoogleLongitude(String googleLong) {
		this.googleLongitude.click();
		this.googleLongitude.sendKeys(googleLong);
		}
		public void sendstorageValue(String storageval) {
		this.detailsTab.click();
		this.storageroomValue.sendKeys(storageval);
		}
		public void selectbangcheck() {
		this.centralBangcbox.click();	
		if(this.centralBangcbox.isSelected())
		{
		System.out.println("central bangalore is checked");
		}
		else
		{
			System.out.println("central bangalore is checked");
		}
		}
		public void clickPublishbutton() {
		this.publishButton.click();
		}
		public void verifypostmessage(String message) {
		Assert.assertEquals(this.verifyMessage.getText(),message);
		}
		public void verifyPublishedpost(String newtitle) {
		this.allPropTab.click();
		System.out.println(this.addedProp.getText());
		Assert.assertEquals(this.addedProp.getText(), newtitle);
		}
		public void testReport() {
		Reporter.log("New Properties is been successfully added by Admin");
		}
}

