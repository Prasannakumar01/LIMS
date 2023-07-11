package org.NewaInsurance_GenrericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.LifeInusrance.ObjectRepository.Homepage;
import org.LifeInusrance.ObjectRepository.Loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This base class is the parent class and we will extends to the test class and
 * make the scripts get executed without using for the multiple scripts.
 * 
 * @author prasanna
 *
 */

public class BaseClass {
	
    public static WebDriver sDriver;//Listeners
	public WebDriver driver;
	public DatabaseUtilities dlib = new DatabaseUtilities();
	public FileUtilities flib = new FileUtilities();
	public ExcelUtilities Elib = new ExcelUtilities();
	public JavaUtilities jlib = new JavaUtilities();
	public WebdriverPerformUtilities wlib = new WebdriverPerformUtilities();
	

	/**
	 * Connect with the database using this method. It will execute when ever we
	 * Start to execute the script for one type for all the scripts because we want
	 * the common steps to be mentioned in the base class
	 */
	@BeforeSuite(alwaysRun = true)
	public void connectToDatabase() {
		try {
			dlib.connectDB();
			System.out.println("------------------------Database connection is successful----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * Here the launching the browser is runtime polymorphism where we can observer during the run 
	 * time we are able to see the which browser is going to launch .
	 */
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable {

	    
		String Browser = flib.getdatafromProjectEnvconfig("browser");
		
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("-----------" + Browser + "Launched Successfully-----------");
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("---------------" + Browser + "-Launched Successfully-------------");
			}
			else if(Browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
			driver=	new EdgeDriver();
			System.out.println("---------------" + Browser + "-Launched Successfully-------------");

			
		}
/*
		switch(Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("-----------" + Browser + "-----------");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			System.out.println("---------------" + Browser + "-Launched Successfully-------------");
			break;

		case "edge":
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
			System.out.println("---------------" + Browser + "-Launched Successfully-------------");
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("---------------" + Browser + "Launched successfully--------------");
		}*/
		
		sDriver=driver;
		wlib.maximizeWindow(driver);
		wlib.waitforpageload(driver, 20);
		String Url = flib.getdatafromProjectEnvconfig( "url");
		driver.get(Url);

	}

	/**
	 * this method will login to the application for every test script as this class
	 * is extended to the script class
	 * 
	 * @throws IOException
	 */
	@BeforeMethod(alwaysRun = true)
	public void logintoApplication() throws IOException {
       		String Username = flib.getdatafromProjectEnvconfig( "username");
		String Password = flib.getdatafromProjectEnvconfig( "password");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.Login(Username, Password);
		
		System.out.println("Successful login to the application");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutfromApplication() {
		Homepage homepage = new Homepage(driver);
		homepage.Logout();

		System.out.println("Logout from the application");
	}

	/**
	 * This method will close the browser after the class
	 */
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed");
	}

	/***
	 * This method will disconnect to the database with the help of AfterSuite
	 */
	@AfterSuite(alwaysRun = true)
	public void disconnectToDatabase() {
		try {
			dlib.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database closed");
	}

}
