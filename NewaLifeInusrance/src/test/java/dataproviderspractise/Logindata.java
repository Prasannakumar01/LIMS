package dataproviderspractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logindata {

	@Test(dataProvider="getData")
	public void fetchdata(String username,String password) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	     driver.findElement(By.xpath("//button[text()='login']")).submit();
	
	
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[2][2];
		obj[0][0] = "555";
		obj[0][1] = "993";
		
		obj[1][0] = "555";
		obj[1][1] = "666";
		return obj;
	}
 
}
