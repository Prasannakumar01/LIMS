package org.LifeInusrance.ObjectRepository;

import java.io.IOException;

import org.NewaInsurance_GenrericUtilities.WebdriverPerformUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_clientPage {
	// Declaration of all the elements in the page by encapsulating the elements

	@FindBy(xpath = "//input[@name='client_id']")
	private WebElement ClientIdTxtbox;

	@FindBy(xpath = "//input[@name='client_password']")
	private WebElement ClientpwdTxtbox;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement NameTxtBox;

	@FindBy(xpath = "//input[@name='fileToUpload']")
	private WebElement ChooseFilebtn;

	@FindBy(xpath = "//input[@name='sex']")
	private WebElement Gendertxtbox;

	@FindBy(xpath = "//input[@name='birth_date']")
	private WebElement Birthdatetxtbox;

	@FindBy(xpath = "//input[@name='maritial_status']")
	private WebElement Maritialstatustxtbox;

	@FindBy(xpath = "//input[@name='nid']")
	private WebElement NationalidTxtbox;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement Phonetxtbox;

	@FindBy(xpath = "//input[@name='address']")
	private WebElement Addresstxtbox;

	@FindBy(xpath = "//input[@name='policy_id']")
	private WebElement Policyidtxtbox;

	@FindBy(xpath = "//input[@name='agent_id']")
	private WebElement AgentidTxtbox;

	@FindBy(xpath = "//input[@name='nominee_id']")
	private WebElement NomineeIdtxtbox;

	@FindBy(xpath = "//input[@name='nominee_name']")
	private WebElement NomineenametxtBox;
	@FindBy(xpath = "//input[@name='nominee_sex']")
	private WebElement NomineeGenderTxtbox;

	@FindBy(xpath = "//input[@name='nominee_birth_date']")
	private WebElement NomineeBirthdtTxtBox;

	@FindBy(xpath = "//input[@name='nominee_nid']")
	private WebElement Nomineenidtxtbox;

	@FindBy(xpath = "//input[@name='nominee_relationship']")
	private WebElement Nomineerelatntxtbox;

	@FindBy(xpath = "//input[@name='priority']")
	private WebElement Prioritytxtbox;

	@FindBy(xpath = "//input[@name='nominee_phone']")
	private WebElement NomineePhonetxtbox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Submitbtn;

	// initialisation of all the elements using the PageFactory class
	public Add_clientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration of elements to the methods

	public WebElement getClientIdTxtbox() {
		return ClientIdTxtbox;
	}

	public WebElement getClientpwdTxtbox() {
		return ClientpwdTxtbox;
	}

	public WebElement getNameTxtBox() {
		return NameTxtBox;
	}

	public WebElement getChooseFilebtn() {
		return ChooseFilebtn;
	}

	public WebElement getGendertxtbox() {
		return Gendertxtbox;
	}

	public WebElement getBirthdatetxtbox() {
		return Birthdatetxtbox;
	}

	public WebElement getMaritialstatustxtbox() {
		return Maritialstatustxtbox;
	}

	public WebElement getNationalidTxtbox() {
		return NationalidTxtbox;
	}

	public WebElement getPhonetxtbox() {
		return Phonetxtbox;
	}

	public WebElement getAddresstxtbox() {
		return Addresstxtbox;
	}

	public WebElement getPolicyidtxtbox() {
		return Policyidtxtbox;
	}

	public WebElement getAgentidTxtbox() {
		return AgentidTxtbox;
	}

	public WebElement getNomineeIdtxtbox() {
		return NomineeIdtxtbox;
	}

	public WebElement getNomineenametxtBox() {
		return NomineenametxtBox;
	}

	public WebElement getNomineeGenderTxtbox() {
		return NomineeGenderTxtbox;
	}

	public WebElement getNomineeBirthdtTxtBox() {
		return NomineeBirthdtTxtBox;
	}

	public WebElement getNomineenidtxtbox() {
		return Nomineenidtxtbox;
	}

	public WebElement getNomineerelatntxtbox() {
		return Nomineerelatntxtbox;
	}

	public WebElement getPrioritytxtbox() {
		return Prioritytxtbox;
	}

	public WebElement getNomineePhonetxtbox() {
		return NomineePhonetxtbox;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	/**
	 * business libraries
	 */

	public void sendTxttoClientpwdTxtbox(String pwd) {
		ClientpwdTxtbox.sendKeys(pwd);

	}

	public void sendTxttoNametxtbox(String clientname) {
		NameTxtBox.sendKeys(clientname);

	}

	public void sendTexttoClientGender(String clientGender) {
		Gendertxtbox.sendKeys(clientGender);

	}

	public void sendTxttoClientBirth(String clientBirth) {
		Birthdatetxtbox.sendKeys(clientBirth);

	}

	public void sendTxttoMaritialstatus(String clientMaritalSt) {
		Maritialstatustxtbox.sendKeys(clientMaritalSt);

	}

	public void sendTxttoNationalidTxtbox(String clientnid) {
		Nomineenidtxtbox.sendKeys(clientnid);

	}

	public void sendTxttoPhonetxtbox(String clientPhone) {
		Phonetxtbox.sendKeys(clientPhone);

	}

	public void sendTxttoAddresstxtbox(String clientaddress) {
		Addresstxtbox.sendKeys(clientaddress);

	}

	public String gettxtfromAgentIdTxtbox() {
		return AgentidTxtbox.getText();
	}

	public String sendpolicyidtotxtbox(String policy) {
		Policyidtxtbox.sendKeys(policy);
		return policy;
	}

	public void gettxtfromNomineeidtxtbox() {
		NomineeIdtxtbox.getText();
	}

	public void sendtxttoNomineeNametxtBox(String nomineename) {
		NomineenametxtBox.sendKeys(nomineename);
	}

	public void sendtxttoNomineeGenderTxtbox(String nomineeGender) {
		NomineeGenderTxtbox.sendKeys(nomineeGender);
	}

	public void sendtxttoNomineeBirthdtTxtBox(String nomineeBirth) {
		NomineeBirthdtTxtBox.sendKeys(nomineeBirth);
	}

	public void sendtxttoNomineenidTxtBox(String nomineenid) {
		Nomineenidtxtbox.sendKeys(nomineenid);
	}

	public void sendtxttoNomineerelatntxtbox(String nomineerelationship) {
		Nomineerelatntxtbox.sendKeys(nomineerelationship);
	}

	public void sendtxttoPrioritytxtbox(String nomineepriority) {
		Prioritytxtbox.sendKeys(nomineepriority);
	}

	public void sendtxttoNomineePhonetxtbox(String nomineePhone) {
		NomineePhonetxtbox.sendKeys(nomineePhone);
	}

	public void clickonsubmit() {
		Submitbtn.click();
	}

	WebdriverPerformUtilities wlib = new WebdriverPerformUtilities();

	public void AddClientsdata(WebDriver driver, String pwd, String clientname, String imgpath, String clientGender,
			String clientBirth, String clientMaritalSt, String clientnid, String clientPhone, String clientaddress,
			String policy) {

		wlib.uploadfiles(driver, imgpath);
		ClientpwdTxtbox.sendKeys(pwd);
		NameTxtBox.sendKeys(clientname);

		Gendertxtbox.sendKeys(clientGender);
		Birthdatetxtbox.sendKeys(clientBirth);
		Maritialstatustxtbox.sendKeys(clientMaritalSt);
		Nomineenidtxtbox.sendKeys(clientnid);
		Phonetxtbox.sendKeys(clientPhone);
		Addresstxtbox.sendKeys(clientaddress);
		Policyidtxtbox.sendKeys(policy);

	}

	public void addnomineedata(WebDriver driver, String nomineename, String nomineeGender, String nomineeBirth,
			String nomineenid, String nomineerealtionship, String nomineepriority, String nomineePhone) {
		Homepage homepage = new Homepage(driver);
		homepage.clickonNominee();
		NomineenametxtBox.sendKeys(nomineename);
		NomineeGenderTxtbox.sendKeys(nomineeGender);
		NomineeBirthdtTxtBox.sendKeys(nomineeBirth);
		Nomineenidtxtbox.sendKeys(nomineenid);
		Nomineerelatntxtbox.sendKeys(nomineerealtionship);
		Prioritytxtbox.sendKeys(nomineepriority);
		Phonetxtbox.sendKeys(nomineePhone);
	}

	public void createclient(WebDriver driver, String clientpassword, String clientname, String img,
			String clientGender, String clientBirth, String clientMaritalst, String clientnid, String clientPhone,
			String clientaddress, String policy, String nomineename, String nomineeGender, String nomineeBirth,
			String nomineenid, String nomineerealtionship, String nomineepriority, String nomineePhone)
			throws IOException {

		Homepage homepage = new Homepage(driver);

		Clients_InformationPage clientsinfopage = new Clients_InformationPage(driver);

		homepage.clickonClients();
		clientsinfopage.clickonaddclient();

		ClientpwdTxtbox.sendKeys(clientpassword);
		NameTxtBox.sendKeys(clientname);
		ChooseFilebtn.click();
		wlib.uploadfiles(driver, img);
		Gendertxtbox.sendKeys(clientGender);
		Birthdatetxtbox.sendKeys(clientBirth);
		Maritialstatustxtbox.sendKeys(clientMaritalst);
		Nomineenidtxtbox.sendKeys(clientnid);
		Phonetxtbox.sendKeys(clientPhone);
		Addresstxtbox.sendKeys(clientaddress);
		Policyidtxtbox.sendKeys(policy);
		NomineenametxtBox.sendKeys(nomineename);
		NomineeGenderTxtbox.sendKeys(nomineeGender);
		NomineeBirthdtTxtBox.sendKeys(nomineeBirth);
		Nomineenidtxtbox.sendKeys(nomineenid);
		Nomineerelatntxtbox.sendKeys(nomineerealtionship);
		Prioritytxtbox.sendKeys(nomineepriority);
		Phonetxtbox.sendKeys(nomineePhone);
		clickonsubmit();

	}

}
