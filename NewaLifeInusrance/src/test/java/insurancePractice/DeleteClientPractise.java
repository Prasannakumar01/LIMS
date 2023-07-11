package insurancePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteClientPractise {

	public static void main(String[] args) {
		
		//initialize the browser
		WebDriver driver= new FirefoxDriver();
		//launch the application
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/home.php");
		//maximize the screen
		driver.manage().window().maximize();
		//Add the implicitlywait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login to the application
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("555");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("666");
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		//Delete the client
		driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
		driver.findElement(By.xpath("//th[.='CLIENT ID']/parent::tr/parent::tbody/child::tr[last()]/td[8]")).click();
		String cl_ID=driver.findElement(By.xpath("//label[.='CLIENT ID']/../input[2]")).getText();
		String cl_password=driver.findElement(By.xpath("//label[.='CLIENT PASSWORD']/../input[3]")).getText();
		driver.findElement(By.xpath("//a[.='Delete Client']")).click();
		
		System.out.println(cl_ID);
		System.out.println(cl_password);
		

		//verify the deleted client in the client's information page
		driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
		driver.findElement(By.xpath(""));
		
		
		
		
		

	}

}
