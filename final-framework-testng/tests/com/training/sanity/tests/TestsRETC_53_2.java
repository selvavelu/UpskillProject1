package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Postpage;
import com.training.pom.PropertyPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_53_2 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PropertyPage propertypage; 
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		propertypage = new PropertyPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_51_0");
		Thread.sleep(2000);
		
/*		driver.get("http://realestate.upskills.in/");
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.RETURN);
				
				Actions action = new Actions(driver);
		WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		action.doubleClick(link).perform();
			
*/		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
    	driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-site-name\"]/a")).sendKeys(selectLinkOpeninNewTab);
		System.out.println("newtab comes up");
		
		
		
//		driver.get("http://www.google.com");
//		WebElement gmailtab=driver.findElement(By.linkText("Gmail"));
		WebElement gmailtab=driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-site-name\"]/a"));
		Actions act = new Actions(driver);
		act.contextClick(gmailtab).perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		ArrayList <String> googletabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("number of tabs opened="+googletabs.size());
		System.out.println("current url before switching "+driver.getCurrentUrl());
		driver.switchTo().window(googletabs.get(1)).getTitle();
		System.out.println("current url after switching "+driver.getCurrentUrl());
	
		driver.findElement(By.xpath("//*[@id=\"ajaxsearchlite1\"]/div/div[3]/form/input[1]")).sendKeys("RETC_051_2");
		driver.findElement(By.xpath("//*[@id=\"ajaxsearchlite1\"]/div/div[1]/div/svg")).click();
		
		
		
		
		//*[@id="wp-admin-bar-site-name"]/a
    	//a[contains(text(),'Real Estate')]
		/*
		propertypage.clickPropertyAction();
		screenShot.captureScreenShot("TC_51_1");
		propertypage.clickAllProperties();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_51_2");
		propertypage.trashlinkclick();
		screenShot.captureScreenShot("TC_51_3");
		Thread.sleep(2000);
		String sText="RET";
		propertypage.propertySearchInput(sText);
		String ts= propertypage.displayRestore.getText();
		System.out.println(ts);
		propertypage.rowMouseOver();		
		screenShot.captureScreenShot("TC_51_4");
		
		propertypage.restoreMouseOver();
		screenShot.captureScreenShot("TC_51_5");
		Thread.sleep(1000);
//		screenShot.captureScreenShot("TC_51_6");
		
		try {
			propertypage.messageDisplay.isDisplayed();
			String actual = propertypage.displayMessage();
			System.out.println(actual);
			String expected = "1 post restored from the Trash.";
			Assert.assertEquals(actual, expected);
			System.out.println("Restored successfully and Confirmed");
		} catch (Exception e) {
			System.out.println("NOT Restored");
		}

*/		
		/*
		
		
		
		propertypage.allLinkClick();
		screenShot.captureScreenShot("TC_51_7");
		Thread.sleep(2000);
		
		propertypage.propertySearchInput(ts);
//		propertypage.displayRestore();
//		propertypage.displayRestore.getAttribute("post_title");
		String ss= propertypage.displayRestore.getText();
		System.out.println(ss);
		screenShot.captureScreenShot("TC_51_8");
	
	try{
		Assert.assertEquals(ss, ts);
		System.out.println("Property Restore successfully and listed in ALL");
	}
	catch(Exception e){
		System.out.println("Property Restore is Failed");
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	}
}
