package insurancePractice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateClientandLoginwithClientCredentialspractice {

	public static void main(String[] args) throws InterruptedException {
		
		
		// Initialize the browser
          WebDriver driver= new FirefoxDriver();
          
          // Maximize screen
          driver.manage().window().maximize();
          //navigate to the web application.
          driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
          
          //Login to the application
          driver.findElement(By.name("username")).sendKeys("555");
          driver.findElement(By.name("password")).sendKeys("666");
          driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();
          
          //Navigate to the clients information page 
          driver.findElement(By.xpath("")).click();  
        String element=driver.findElement(By.xpath("//h1[starts-with(text(),'Clients')]")).getText();
          
        System.out.println(element);
        //navigate to the add client
        
        driver.findElement(By.xpath("//button/a[text()='Add Client']")).click();
        
         //Required fields of clients should be filled .
    String clientid= driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
    System.out.println(clientid);
       //Script data          
    String clientname="Spiderman";
    int random=new Random().nextInt(30);
    String clientBirth="09/03/2001";
    String clientGender="Male";
    String clientMaritalSt="Single";
    String clientnid="983903003";
    String clientPhone="9838300030";
    String clientaddress="JohnsonStreet,UK,783903";
  
	String policy="1";
	
    String nomineename="Batman";
    String nomineeGender="Male";
    String nomineeBirth="09/08/8903";
    String nomineenid="98298383932";
    String nomineerelationship="son";
    String nomineepriority="1st";
    String nomineePhone="8743903033";
    
    
        
   WebElement password=driver.findElement(By.name("client_password"));
		   password.sendKeys(clientname+"@"+random);
		 String pwd = password.getText();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(clientname);
        driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys("C:\\Users\\kasir\\Pictures\\Screenshots\\DSC_3162.jpg");
        driver.findElement(By.name("sex")).sendKeys(clientGender);
        driver.findElement(By.name("birth_date")).sendKeys(clientBirth);
        driver.findElement(By.name("maritial_status")).sendKeys(clientMaritalSt);
        driver.findElement(By.name("nid")).sendKeys(clientnid);
        driver.findElement(By.name("phone")).sendKeys(clientPhone);
        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(clientaddress);
        driver.findElement(By.xpath("//input[@name='policy_id']")).sendKeys(policy);
        String Agentid=  driver.findElement(By.name("agent_id")).getText();
  
      //Getting text to compare with the agent Id which was automatically inserted.
      String ID=driver.findElement(By.className("inner-text")).getText();
     System.out.println(Agentid.contains(ID)+"Matched");
    
    	 driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys(nomineename+"@"+random);
    	 driver.findElement(By.name("nominee_sex")).sendKeys(nomineeGender);
    	 driver.findElement(By.xpath("//input[@name='nominee_birth_date']")).sendKeys(nomineeBirth);
    	 driver.findElement(By.xpath("//input[@name='nominee_nid']")).sendKeys(nomineenid);
    	 driver.findElement(By.xpath("//input[@name='nominee_relationship']")).sendKeys(nomineerelationship);
    	 driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(nomineepriority);
    	 driver.findElement(By.name("nominee_phone")).sendKeys(nomineePhone);
    	 driver.findElement(By.xpath("//input[@type='submit']")).click();
     //verifying the created client.
          driver.findElement(By.xpath( "//a[@title='Logout']" )).click();
          //Login With client login to verify the client is created or not
          
          driver.findElement(By.name("username")).sendKeys(clientid);
          driver.findElement(By.name("password")).sendKeys(pwd);
          driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();
          
          System.out.println("Client got created successfully and login with his credentials. .");
          

          }
   
	}


