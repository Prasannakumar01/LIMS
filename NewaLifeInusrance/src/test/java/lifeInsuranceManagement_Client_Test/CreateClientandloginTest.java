package lifeInsuranceManagement_Client_Test;

import java.io.IOException;

import org.LifeInusrance.ObjectRepository.Add_clientPage;
import org.LifeInusrance.ObjectRepository.Insert_ClientPage;
import org.NewaInsurance_GenrericUtilities.BaseClass;
import org.NewaInsurance_GenrericUtilities.ExcelUtilities;
import org.NewaInsurance_GenrericUtilities.WebdriverPerformUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateClientandloginTest extends BaseClass {

	@Test
	public void createClientandLoginTest() throws IOException, InterruptedException {

		// WebDriver driver=null;
WebdriverPerformUtilities wlib=new WebdriverPerformUtilities();


		ExcelUtilities exlib = new ExcelUtilities();
           
		String clientpassword = exlib.getDatabasedOnTestId("TestData", "ALI_TC_10015", "clientpassword");
		String clientname = exlib.getDatafromExcel("TestData", 1, 2);
		String clientGender = exlib.getDatabasedOnTestId("TestData", "ALI_TC_10015", "clientgender");
		String clientBirth = exlib.getDatafromExcel("TestData", 1, 4);
		String clientMaritalst = exlib.getDatafromExcel("TestData", 1, 5);
		String clientnid = exlib.getDatafromExcel("TestData", 1, 7);
		String clientPhone = exlib.getDatafromExcel("TestData", 1, 8);
		String clientaddress = exlib.getDatafromExcel("TestData", 1, 9);
		String policy = exlib.getDatafromExcel("TestData", 1, 10);
		String nomineename = exlib.getDatafromExcel("TestData", 1, 11);
		String nomineeGender = exlib.getDatafromExcel("TestData", 1, 12);
		String nomineeBirth = exlib.getDatafromExcel("TestData", 1, 13);
		String nomineenid = exlib.getDatafromExcel("TestData", 1, 14);
		String nomineerealtionship = exlib.getDatafromExcel("TestData", 1, 14);
		String nomineepriority = exlib.getDatafromExcel("TestData", 1, 15);
		String nomineePhone = exlib.getDatafromExcel("TestData", 1, 16);

		Add_clientPage addclientpage = new Add_clientPage(driver);
		addclientpage.createclient(driver, clientpassword, clientname, wlib.uploadfiles(driver, "C:\\Users\\kasir\\Pictures\\_IVA6128.jpg"), clientGender, clientBirth, clientMaritalst,
				clientnid, clientPhone, clientaddress, policy, nomineename, nomineeGender, nomineeBirth, nomineenid,
				nomineerealtionship, nomineepriority, nomineePhone);

		 
		Insert_ClientPage insertclientpage = new Insert_ClientPage(driver);
		String expectedresult = "ADDED Nominee Successfully";
		Assert.assertTrue(insertclientpage.messagebox().contains(expectedresult), "failed verfying the actual");
		insertclientpage.clickonclients();

		// Navigate to the clients information page
 
		/*
		 * WebElement clelem =
		 * driver.findElement(By.xpath("//a[@href=\"client.php\"]")); clelem.click();
		 * 
		 * // navigate to the add client
		 * 
		 * driver.findElement(By.xpath("//button/a[text()='Add Client']")).click();
		 * 
		 * // Required fields of clients should be filled . String clientid =
		 * driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute(
		 * "value"); System.out.println(clientid);
		 * driver.findElement(By.xpath("//input[@name='name']")).sendKeys(clientname);
		 * WebElement pwd = driver.findElement(By.name("client_password"));
		 * pwd.sendKeys(clientname);
		 * 
		 * driver.findElement(By.xpath("//input[@name='fileToUpload']"))
		 * .sendKeys(imgpath);
		 * driver.findElement(By.name("sex")).sendKeys(clientGender);
		 * driver.findElement(By.name("birth_date")).sendKeys(clientBirth);
		 * driver.findElement(By.name("maritial_status")).sendKeys(clientMaritalSt);
		 * driver.findElement(By.name("nid")).sendKeys(clientnid);
		 * driver.findElement(By.name("phone")).sendKeys(clientPhone);
		 * driver.findElement(By.xpath("//input[@name='address']")).sendKeys(
		 * clientaddress);
		 * driver.findElement(By.xpath("//input[@name='policy_id']")).sendKeys(policy);
		 * 
		 * driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys(
		 * nomineename );
		 * driver.findElement(By.name("nominee_sex")).sendKeys(nomineeGender);
		 * driver.findElement(By.xpath("//input[@name='nominee_birth_date']")).sendKeys(
		 * nomineeBirth);
		 * driver.findElement(By.xpath("//input[@name='nominee_nid']")).sendKeys(
		 * nomineenid);
		 * driver.findElement(By.xpath("//input[@name='nominee_relationship']")).
		 * sendKeys(nomineerelationship);
		 * driver.findElement(By.xpath("//input[@name='priority']")).sendKeys(
		 * nomineepriority);
		 * driver.findElement(By.name("nominee_phone")).sendKeys(nomineePhone);
		 * driver.findElement(By.xpath("//input[@type='submit']")).click();
		 * driver.findElement(By.xpath("//a[@title='Logout']")).click();
		 * 
		 * String cpwd=pwd.getAttribute("value"); //verify the client has been created
		 * or not
		 * 
		 * 
		 * 
		 * //login with the client
		 * driver.findElement(By.name("username")).sendKeys(clientid);
		 * driver.findElement(By.name("password")).sendKeys(cpwd);
		 * driver.findElement(By.xpath("//button[contains(text(),'login')]")).submit();
		 */
	}
}