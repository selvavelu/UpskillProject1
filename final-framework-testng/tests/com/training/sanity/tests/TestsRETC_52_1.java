package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

public class TestsRETC_52_1 {

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
	public void validLoginTest() throws InterruptedException {
		//Click on Submit, Input for Login and Password
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_52_0");
		Thread.sleep(2000);
		//Click property Menu
		propertypage.clickPropertyAction();
		screenShot.captureScreenShot("TC_52_1");
		//Click All properties Sub Menu
		propertypage.clickAllProperties();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_52_2");
		//input and search property
//		String sText="RET";
		String sText="RETC52_";
		propertypage.propertySearchInput1(sText);
		//Mouse over Property row
		propertypage.rowMouseOver();
		screenShot.captureScreenShot("TC_52_3");
		//get restore text
		String ss= propertypage.displayRestore.getText();
		System.out.println(ss);
		//Mouse over Trash link
		propertypage.trashHlinkMouseOver();
		screenShot.captureScreenShot("TC_52_4");
		//display message
		propertypage.displayMessage();
		//Message display confirmation
		
		try {
			propertypage.messageDisplay.isDisplayed();
			String actual = propertypage.displayMessage();
			System.out.println(actual);
			String expected = "1 post moved to the Trash. Undo";
			Assert.assertEquals(actual, expected);
			System.out.println("Trashed successfully and Confirmed");
		} catch (Exception e) {
			System.out.println("NOT Trashed");
		}
		//click trash link
		propertypage.trashlinkclick();
		//input and search
		propertypage.propertySearchInput1(ss);
		screenShot.captureScreenShot("TC_52_5");
		Thread.sleep(1000);
		//Mouse over row
		propertypage.rowMouseOver();
		screenShot.captureScreenShot("TC_52_6");
		//click trash link
		propertypage.trashHPermanentClick();
		screenShot.captureScreenShot("TC_52_7");
		//message display permanently deleted
		try {
			propertypage.messageDisplay.isDisplayed();
			String actual = propertypage.displayMessage();
			System.out.println(actual);
			String expected = "1 post permanently deleted.";
			Assert.assertEquals(actual, expected);
			System.out.println("permanently deleted - successfully and Confirmed");
		} catch (Exception e) {
			System.out.println("permanently deleted - Failed");
		}
		
	
	
	
	
	
	
	
	
	
	}
}
