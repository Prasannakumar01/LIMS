package org.LifeInusrance.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insert_ClientPage {

	// declaration of Insert Page elements in the POM Class by creating the page
	@FindBy(xpath = "//h1[@class='page-head-line']")
	private WebElement InsertClientText;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement AddclientBtn;
	@FindBy(xpath = "//div[@class='col-md-12']/b[1])")
	private WebElement Warningmsgforfileupload;
	@FindBy(xpath = "//a[.='Aegon Life']")
	private WebElement AgeonLifelink;
	@FindBy(xpath = "//div[@class='inner-text']")
	private WebElement AgentNametext;
	@FindBy(xpath = "//a[text()='CLIENTS']")
	private WebElement ClientsLink;
	@FindBy(xpath = "//a[text()='AGENTS']")
	private WebElement AgentLink;
	@FindBy(xpath = "//a[text()='POLICY']")
	private WebElement PolicyLink;
	@FindBy(xpath = "//a[text()='NOMINEE']")
	private WebElement NomineeLink;
	@FindBy(xpath = "//a[text()='PAYMENTS")
	private WebElement PaymentsLink;
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement Logoutbtn;
	@FindBy(xpath = "//div[@class='col-md-12']")
	private WebElement MessageBox;

//initialization of the elements in the POM class
	public Insert_ClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization of the elements in the POM class
	public WebElement getInsertClientText() {
		return InsertClientText;
	}

	public WebElement getAddclientBtn() {
		return AddclientBtn;
	}

	public WebElement getWarningmsgforfileupload() {
		return Warningmsgforfileupload;
	}

	public WebElement getAgeonLifelink() {
		return AgeonLifelink;
	}

	public WebElement getClientsLink() {
		return ClientsLink;
	}

	public WebElement getAgentLink() {
		return AgentLink;
	}

	public WebElement getPolicyLink() {
		return PolicyLink;
	}

	public WebElement getNomineeLink() {
		return NomineeLink;
	}

	public WebElement getPaymentsLink() {
		return PaymentsLink;
	}

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	public WebElement getMessageBox() {
		return MessageBox;
	}

	/***
	 * Business Libraries important methods or actions we will keep in this method.
	 */

	/*
	 * This method will click on the AddclientBtn
	 */
	public void clickonAddClient() {
		AddclientBtn.click();
	}

	String msg = "";

	public String messagebox() {
		String msg = MessageBox.getAttribute("inner HTML");
		return msg;
	}

	public void getErrorMsgText() {
		Warningmsgforfileupload.getText();
	}

	public void clickonAgents() {
		AgentLink.click();
	}

	public void clickonPolicy() {

		PolicyLink.click();
	}

	public void clickonclients() {
		ClientsLink.click();
	}

	public void ClickonPayments() {
		PaymentsLink.click();
	}

	public void Logout() {
		Logoutbtn.click();
	}

		
}
