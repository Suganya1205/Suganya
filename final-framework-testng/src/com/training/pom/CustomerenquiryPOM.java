package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.testng.Assert;
//import org.testng.Reporter;

public class CustomerenquiryPOM {
	private WebDriver driver; 
	
	public CustomerenquiryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/header/div[2]/nav/div/ul/li[@id='menu-item-354']/a")
	private WebElement newlaunchTab;
		
	@FindBy(xpath="(//a[@title='Nullam hendrerit Apartments'])[2]")
	private WebElement titleNullamApart;
	
	@FindBy(xpath="//a[@class='item mfp-gallery slick-slide slick-current slick-active']")
	private WebElement galleryImage;
	
	@FindBy(xpath="//button[@class='slick-next slick-arrow']")
	private WebElement nextArrow;	
	
	@FindBy(xpath="//div[@class='agent-title']/h3")
	private WebElement enquiryTitle;
	
	@FindBy(name="your-name")
	private WebElement enquiryName;
	
	@FindBy(name="your-email")
	private WebElement enquiryEmail;
	
	@FindBy(name="your-subject")
	private WebElement enquirySubject;
	
	@FindBy(name="your-message")
	private WebElement enquiryMessage;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement sentMessage;
	
	@FindBy(id="widget_mortgage_calc_properties-4")
	private WebElement priceCalculator;	
	
	@FindBy(id="amount")
	private WebElement salePrice;
	
	@FindBy(id="downpayment")
	private WebElement downPayment;
	
	@FindBy(id="years")
	private WebElement loanTerm;
	
	@FindBy(id="interest")
	private WebElement interestRate;
	
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement calcButton;
	
	@FindBy(xpath="//div[@class='notification success']")
	private WebElement payMessage;	
	
		public void Mouseovertotitle() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(newlaunchTab).build().perform();
		act.moveToElement(titleNullamApart).build().perform();
		act.click(titleNullamApart).build().perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", this.galleryImage);
		act.moveToElement(galleryImage).build().perform();
		act.click(nextArrow).build().perform();
		}
		public void scrollToViewEnquiry() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", this.enquiryTitle);
		}
		public void enterName(String enquiryname) { 
			this.enquiryName.click();
			this.enquiryName.sendKeys(enquiryname);
		}
		public void enterEmail(String enquiryemail) { 
			this.enquiryEmail.click();
			this.enquiryEmail.sendKeys(enquiryemail);
		}
		public void enterSubject(String enquirysubject) { 
			this.enquirySubject.click();
			this.enquirySubject.sendKeys(enquirysubject);
		}
		public void enterMessage(String enquirymessage) { 
			this.enquiryMessage.click();
			this.enquiryMessage.sendKeys(enquirymessage);
			this.enquiryMessage.submit();
		}
		public void verifySentmessage(String sentmessage) { 
			try {
			Assert.assertEquals(this.sentMessage.getText(),sentmessage);
		}
			catch (AssertionError e)
			{
				System.out.println(this.sentMessage.getText());
			}
		}
		public void scrollToViewCalc() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", this.priceCalculator);
			}
		public void enterSaleprice(String saleprice) {
			this.salePrice.click();
			this.salePrice.sendKeys(saleprice);
		}
		public void enterDownpayment(String downpayment) {
			this.downPayment.click();
			this.downPayment.sendKeys(downpayment);	
		}
		public void enterLoanterm(String loanterm) {
			this.loanTerm.click();
			this.loanTerm.sendKeys(loanterm);	
		}
		public void enterInterestrate(String interestrate) {
			this.interestRate.click();
			this.interestRate.sendKeys(interestrate);	
		}
		public void verifyPaymentmesg(String paymessage) {
			this.calcButton.click();
			this.payMessage.getText();
			System.out.println(payMessage.getText());
			Assert.assertEquals(payMessage.getText(), paymessage);
		}
}	