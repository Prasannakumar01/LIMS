package org.LifeInusrance.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class Loginpage {

	//declaration

	@FindBy(name="username")private WebElement UsernameTextfield;

	@FindBy(name="password")private WebElement PasswordTextfield;

	@FindBy(xpath="//button[.='login']")private WebElement LoginbtnClik;



	//initialisation
	public Loginpage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}


	//utilisation
	public WebElement getUsernameTextfield() {
		return UsernameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return PasswordTextfield;
	}

	public WebElement getLoginbtnClik() {
		return LoginbtnClik;
	}

	/***
	 * Business libraries are created in every page which can be done on every script.
	 * Using this Login we can login to the application by using the  parameters
	 */
	public void Login(String username,String password) {
		UsernameTextfield.sendKeys(username);
		PasswordTextfield.sendKeys(password);
		LoginbtnClik.click();

	}


}
