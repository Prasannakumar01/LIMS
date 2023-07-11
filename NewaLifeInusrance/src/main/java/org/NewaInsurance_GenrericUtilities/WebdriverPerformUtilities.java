package org.NewaInsurance_GenrericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**\
 * This class contains specific webdriver methods
 * @author prasanna
 *
 */
public class WebdriverPerformUtilities {
	FileUtilities flib=new FileUtilities();
	




	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/***
	 * This method is used to minimize the window from the normal size of the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize(); 	
	}

	/**
	 * This method is used for the implicitly wait ,it will always wait for the element in the dom and if it is present 
	 * this wait will release the control of the element
	 * @param driver
	 */
	public void waitforpageload(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * This method is used as the explicit wait and it used to wait for the page to load and to be visible in the GUI
	 * @param driver
	 * @param element
	 */
	public void waitforElementTobevisible(WebDriver driver,WebElement element,int seconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used as the explicit wait and it is used wait for the page to load and click on the element 
	 * @param driver
	 * @param element
	 */

	public void waitforElementTobeClickable(WebDriver driver,WebElement element,int seconds) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}

	/**
	 * This method is used inplace of explicit wait and it will wait and  click on the element 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element,int time) {
		int count=0;
		while(count<time) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count++;
			}
		}
	}

	/**
	 * This method wait for the element and sends( pass) the data to the element
	 * @param element
	 * @param data
	 * @throws InterruptedException
	 */

	public void waitAndText(WebElement element,int time,String data)  {
	
		      int count=0;
		      while(count<time) {
			try {
				element.sendKeys(data);
				break;
			}catch(Throwable e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count++;
			}}
		      
		
	}

	/**
	 * This method is used to handle the dropdown based on the index
	 * @param element
	 * @param index
	 */

	public void dropdownHandling(WebElement element,int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdown based on the id or name 
	 * @param element
	 * @param value
	 */
	public void dropdownHandling(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to handle the dropdown based on the visibleText
	 * @param text
	 * @param element
	 */
	public void dropdownHandling(String text,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}


	/**
	 * This method is used to place the cursor on the specified element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**\
	 *This method is used to right click  where the cursor is on the desktop and it is present in the Actions
	 * @param driver
	 */
	public void righClickAction(WebDriver driver ) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method is used to right click on the particular element based on the webelement parameter
	 * @param driver
	 * @param element
	 */

	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();	
	}

	/**
	 * This method is used to double click at the cursor location in the desktop
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act= new Actions(driver);
		act.doubleClick().perform();

	}

	/**
	 * This method is used to double click on the specified webelement which is passed as a parameter and this method is available
	 * in the Actions Class
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is present in the alert Interface and is used to accept the alert and verify the actual and expected text on the alert
	 * popup
	 * @param driver
	 * @param ExpectedMsg
	 */
	public void acceptAlert(WebDriver driver,String ExpectedMsg) {
		Alert alt=	driver.switchTo().alert();
		if(alt.getText().equals(ExpectedMsg)) {
			System.out.println("Alert message is verified");
		}else {
			System.out.println("Alert message is not verified");
		}
		alt.accept();
	}

	/**
	 * this method is present in the Alert Interface and this is used to dismiss the alert and verify the text 
	 * @param driver
	 * @param ExpectedMsg
	 */
	public void dismissAlert(WebDriver driver,String ExpectedMsg) {
		Alert alt=driver.switchTo().alert();
		if(alt.getText().equals(ExpectedMsg)) {
			System.out.println("Alert message is verified ");
		}else {
			System.out.println("Alert message is not verified");
		}
		alt.dismiss();
	}

	/**
	 * This method is present in the alert Interface and is used to get the text from the alert popup.
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		String alertMsg=driver.switchTo().alert().getText();
		return alertMsg;
	}

	/**
	 * This method is present in the webDriver Interface and it is used to handle the windows based on the title of the page.
	 * @param driver
	 * @param partWinTitle
	 */

	public void SwitchtowindowbasedonTitle(WebDriver driver,String partWinTitle) {
		Set<String>winIds= driver.getWindowHandles();
		for(String win :winIds) {
			String windowTitle=driver.switchTo().window(win).getTitle();
			if(windowTitle.contains(partWinTitle));
			System.out.println(windowTitle+"switchtowindow based on title is passed");
			break;
		}
	}

	/**
	 * This method is present in the WebDriver Interface and it is used to handle the windows based on the partial url.
	 * @param driver
	 * @param partwinUrl
	 */
	public void SwitchWindowbasedonWinUrl(WebDriver driver,String partwinUrl) {
		Set<String> set =driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String winId=it.next();
			String currenturl=  driver.switchTo().window(winId).getCurrentUrl();
			if(currenturl.contains(partwinUrl)) {
				System.out.println(partwinUrl+"switchtowindow  based on url is passsed.");
				break; 
			}    
		}
	}

	/**
	 * This method is used to scroll the windows on the y axis 
	 * @param driver
	 */
	public void ScrollAction(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)","");	
	}


	/**
	 * This method is used to scroll  the windows to particular element which is passed in the parameter
	 * @param driver
	 * @param element
	 */
	public void ScrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}

	/**\
	 * This method is used to switch to the frames based on the index number
	 * @param driver
	 * @param index
	 */

	public void switchtoFrames(WebDriver driver,int index ) {
		driver.switchTo().frame(index);	
	}


	/**
	 *  This method is used to switch to the frames based on the id_name_attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchtoFrames(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/*(*
	 * This method is used to switch the frames based on the element present in the frame
	 */
	public void switchtoFrames(WebElement element,WebDriver driver ) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch to the default frame.
	 * @param driver
	 */
	public void SwitchtoDefaultcontent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to switch to the immediate parent frame
	 * @param driver
	 */
	public void SwitchtoParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is present in the Actions Interface and it is used to drag the element and drop the element in the desired place.
	 * @param driver
	 * @param srcelement
	 * @param destelement
	 */

	public void draganddrop(WebDriver driver,WebElement srcelement, WebElement destelement) {
		Actions act= new Actions(driver);
		act.dragAndDrop(srcelement, destelement);
	}
	/**
	 * This method is to take the screenshot of the failed scripts and it will be helpful to show the actual failed result to the 
	 * developer inorder to understand where the bug was found.It acts like a proof.
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String takesScreenshot(WebDriver driver,String screenshotname)  {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(".\\screenshots\\"+screenshotname+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return des.getAbsolutePath();

	}
	
	
	public String  uploadfiles(WebDriver driver, String imgpath) {
		
	
		try {
			Robot robot=new Robot();
		StringSelection str=new StringSelection(imgpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V );
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return imgpath;
		
		
	}

}



