package org.LifeInusrance.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * This Homepage consists of the homepage elements paths we can use this
 * locators inorder to avoid syncronisation issue and reuse of the locators if
 * we are performing multiple times on the same element
 * 
 * @author prasanna
 *
 */
public class Homepage {

	// declaration
	@FindBy(xpath = "//a[.='Aegon Life']")
	private WebElement AgeonLifelink;
	@FindBy(xpath = "//div[@class='inner-text']")
	private WebElement AgentNameText;
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
	@FindBy(xpath = "//input[@name='key']")
	private WebElement Searchbox;

	@FindBy(xpath = "//input[@value='SEARCH']")
	private WebElement Searchbtn;
	@FindBy(xpath = "//h5[contains(text(),'Total clients')]")
	private WebElement Totalclientscount;

	@FindBy(xpath = "//h5[contains(text(),'Payment Records')]")
	private WebElement Paymentrecordscount;

	@FindBy(xpath = "//h5[contains(.,'Total agents')]")
	private WebElement TotalagentsCount;

//Initialization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getAgeonLifelink() {
		return AgeonLifelink;
	}

	public WebElement getAgentNametext() {
		return AgentNameText;
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

	public WebElement getSearchbox() {
		return Searchbox;
	}

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	public WebElement getTotalclientscount() {
		return Totalclientscount;
	}

	public WebElement getPaymentrecordscount() {
		return Paymentrecordscount;
	}

	public WebElement getTotalagentsCount() {
		return TotalagentsCount;
	}

	/**
	 * Logout , getText and click operations we are using in the Homepage actions in
	 * the business Library instead of hardcode BusinessLibrary
	 * @param driver 
	 * 
	 */
	public void Logout() {
		Logoutbtn.click();
	}

	public void clickonClients() {
		ClientsLink.click();
	}

	public void clickonAgents() {
		AgentLink.click();
	}

	public void clickonPolicy() {

		PolicyLink.click();
	}

	public void clickonNominee() {
		NomineeLink.click();
	}

	public void ClickonPayments() {
		PaymentsLink.click();
	}

	public String getclientslinktext() {
		String Clinktxt = ClientsLink.getText();
		return Clinktxt;

	}

	public String agentnameText() {
		return AgentNameText.getText();

	}

	public String countofclients() {
		String Clientcount = Totalclientscount.getText();
		return Clientcount;

	}

	public String countofAgents() {
		String agentscount = TotalagentsCount.getText();
		return agentscount;
	}

	public String countofPayments() {
		String paymentscount = TotalagentsCount.getText();
		return paymentscount;

	}
}
