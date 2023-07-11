package insurancePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Updatepaymentof23ndclientsinformationpractice {

	public static void main(String[] args) {

//initialize the webdriver
		WebDriver driver = new ChromeDriver();

//navigate to the Insurance application.
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/home.php");

		// Login to the application
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();

		// update the 7th row client payment

		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//th[text()='CLIENT ID']/../../tr[24]/td[7]")).click();
		driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		String recipientno = driver.findElement(By.xpath("//input[@name='recipt_no']")).getAttribute("value");
		String clientID = driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");

		System.out.println(clientID);
		System.out.println(recipientno);

		driver.findElement(By.xpath("//input[@name='month']")).sendKeys("June");
		WebElement amount = driver.findElement(By.xpath("//input[@name='amount']"));
		amount.sendKeys("6650");

		driver.findElement(By.xpath("//input[@name='due']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@name='fine']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
		driver.findElement(By.xpath(""));

	}

}
