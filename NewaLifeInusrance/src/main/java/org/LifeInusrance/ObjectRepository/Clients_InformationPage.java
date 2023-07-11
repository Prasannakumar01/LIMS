package org.LifeInusrance.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Clients_InformationPage {

	// declaration
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

	@FindBy(xpath = "//table/tbody/tr[last()]/td[1]/../td[2]")
	private WebElement lastrowclientname;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[1]/../td[1]'")
	private WebElement lastrowclientid;
	@FindBy(xpath = "//table/tbody/tr[1] ")
	private WebElement ClientsInfofirstrow;
	@FindBy(xpath = "(//tbody/tr)[last()]/td[7]")
	private WebElement LastClientstatuslink;
	@FindBy(xpath = "(//tbody/tr)[last()-1]/td[7]")
	private WebElement Lastbut1ClientstatusLink;
	@FindBy(xpath = "//tbody/tr/th[1]/../../tr/td[7]")
	private WebElement ClienttatuslinkbasedonID;
	@FindBy(xpath = "(//tbody/tr)[last()]/td[8]")
	private WebElement LastclientEditlink;
	@FindBy(xpath = "(//tbody/tr)[last()-1]/td[8]")
	private WebElement LastbutoneclientEditlink;
	@FindBy(xpath = "//tbody/tr[*]/td[1]")
	private List<WebElement> Fetchallclientids;
	@FindBy(xpath = "//a[text()='Add Client']")
	private WebElement Addclientbtn;
    @FindBy(xpath="//table/tbody[*]/tr[*]/td[1]")
    private WebElement Allclientids;
    
	
	// initialization
	public Clients_InformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAgeonLifelink() {
		return AgeonLifelink;
	}

	public WebElement getAgentNametext() {
		return AgentNametext;
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

	public WebElement getLastClientstatuslink() {
		return LastClientstatuslink;
	}

	public WebElement getLastbut1ClientstatusLink() {
		return Lastbut1ClientstatusLink;
	}

	public WebElement getClienttatuslinkbasedonID() {
		return ClienttatuslinkbasedonID;
	}

	public WebElement getLastclientEditlink() {
		return LastclientEditlink;
	}

	public WebElement getLastbutoneclientEditlink() {
		return LastbutoneclientEditlink;
	}

	public List<WebElement> getFetchallclientids() {
		return Fetchallclientids;
	}

	public WebElement getAddclientbtn() {
		return Addclientbtn;
	}

	public WebElement getLastrowclientname() {
		return lastrowclientname;
	}

	public WebElement getLastrowclientid() {
		return lastrowclientid;
	}
	
	
	/**
	 * Business library for the clients information page
	 *  
	 */

	public void clickonaddclient() {
		Addclientbtn.click();
	}

	public String Txtoflastclientname() {
		String clntname = lastrowclientname.getText();
		return clntname;
	}

	public String Txtoflastclientid() {
		String clntid = lastrowclientid.getText();
		return clntid;
	}

	public void clickonlastclientedit() {
		LastclientEditlink.click();
	}

	public void clickonlastclientstatus() {
		LastClientstatuslink.click();
	}

	public void verifytheCreatedClient(String actualclientId) {
		String cid = "";
		for (WebElement wb : Fetchallclientids) {
			cid = wb.getText();
			if (cid.equals(actualclientId)) {
				System.out.println(cid + "Verified the created Client-->pass");

			} else {
				System.out.println(cid + "Verified the created Client-->fail");
			}

		}

	}
}
