package insurancePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Editandloginwithclientandcheckthepolicyupdate {

	public static void main(String[] args) {
		//initialize the browser.
		WebDriver driver=new FirefoxDriver();
		String policy="1";
		
		//navigate to the Insurance application.
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Login to the application
        driver.findElement(By.name("username")).sendKeys("555");
        driver.findElement(By.name("password")).sendKeys("666");
        driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();	
	//Collect the information by going to the clients information 
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//th[text()='STATUS']/../../tr[2]/td[7]")).click();
		String cpolicy=driver.findElement(By.xpath("//input[@name='policy_id']")).getText();
		String policyinfo=driver.findElement(By.xpath("//th[text()='POLICY ID']/../../tr[2]/td[1]")).getText();
		
		System.out.println(cpolicy);
		System.out.println(policyinfo);
		//Edit the information and update.
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//th[text()='UPDATE']/../../tr[2]/td[8]/a[text()='Edit']")).click();
	String client_id=	driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
		WebElement policyvalue= driver.findElement(By.xpath("//input[@name='policy_id']"));
				policyvalue.sendKeys(policy);
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	String clientstatus = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
	System.out.println("Status of the update..>"+clientstatus);
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//th[text()='STATUS']/../../tr[2]/td[7]")).click();
		
		//verify the update
	
				
		
	String up_policy=	driver.findElement(By.xpath("//input[@name='policy_id']")).getAttribute("value");
	String up_policyinfo=driver.findElement(By.xpath("//th[text()='POLICY ID']/../../tr[2]/td[1]")).getText();
	
		System.out.println(up_policy);
		System.out.println(up_policyinfo);
    driver.findElement(By.xpath( "//a[@title='Logout']" )).click();
    //Login With client login to verify the client is created or not
    
    driver.findElement(By.name("username")).sendKeys(client_id);
    driver.findElement(By.name("password")).sendKeys("@123");
    driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();
    
  String clientL_policy=  driver.findElement(By.xpath("//input[@name='policy_id']")).getAttribute("value");
    String clientInfo_policy=driver.findElement(By.xpath("//th[text()='POLICY ID']/../../tr[2]/td[1]")).getAttribute("value");
    
    System.out.println(clientL_policy);
    System.out.println(clientInfo_policy);
 
  
	
	}

}
