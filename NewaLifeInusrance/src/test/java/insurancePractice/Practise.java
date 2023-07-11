
package insurancePractice;

import java.io.IOException;

import org.LifeInusrance.ObjectRepository.Add_clientPage;
import org.LifeInusrance.ObjectRepository.Clients_InformationPage;
import org.LifeInusrance.ObjectRepository.Homepage;
import org.LifeInusrance.ObjectRepository.Loginpage;
import org.NewaInsurance_GenrericUtilities.FileUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise {
	
	public static void main(String[]args) throws IOException {
		FileUtilities flib=new FileUtilities();
		WebDriver driver=null;
	
		 String Url=flib.getdatafromProjectEnvconfig("url");
	      String Browser=	flib.getdatafromProjectEnvconfig( "browser");
	      String Username=flib.getdatafromProjectEnvconfig( "username");
	      String Password=flib.getdatafromProjectEnvconfig("password");
	      if(Browser.equalsIgnoreCase("edge")) {
	    	  WebDriverManager.edgedriver().setup();
	    	  driver=new EdgeDriver();
	      }else if(Browser.equalsIgnoreCase("chrome")){
	    	  WebDriverManager.chromedriver();
	    	  driver=new ChromeDriver();
	    
	      }

	           
	       Clients_InformationPage clientinfopage=new Clients_InformationPage(driver);
	       Homepage homepage=new Homepage(driver);
	      
              driver.get(Url);
               Loginpage loginpage=new Loginpage(driver);
              loginpage.Login(Username, Password);
              homepage.clickonClients();
              clientinfopage.getAddclientbtn().click();
             // WebElement clientIdTbx = driver.findElement(By.xpath("//input[@name='client_id']"));
//              Add_clientPage addclientpage=new Add_clientPage();
//              WebElement clientTextbox = addclientpage.getClientIdTxtbox();
//             String clientid=clientTextbox.getAttribute("innerHTML");
              Add_clientPage addclientpage=new Add_clientPage(driver);
              
              String id =addclientpage.getClientIdTxtbox().getAttribute("value");
           System.out.println(id);
              
              
              
       /*      String value= clientinfopage.Txtoflastclientname();
             System.out.println(value);*/
              
		
	}

}
