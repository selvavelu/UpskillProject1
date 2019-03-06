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

public class TestsRETC_51_1 {

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
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		//Click on Submit, Input for Login and Password
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_51_0");
		Thread.sleep(2000);
		//Click property Menu
		propertypage.clickPropertyAction();
		screenShot.captureScreenShot("TC_51_1");
		//Click All properties Sub Menu
		propertypage.clickAllProperties();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_51_2");
		//Click on Trash Link
		propertypage.trashlinkclick();
		screenShot.captureScreenShot("TC_51_3");
		Thread.sleep(2000);
		//input and search
		propertypage.propertySearchInput();
		String ts= propertypage.displayRestore.getText();
		System.out.println(ts);
		//Mouse over trash row Link 
		propertypage.rowMouseOver();		
		screenShot.captureScreenShot("TC_51_4");
		//restore click on MouseOver element
		propertypage.restoreMouseOver();
		screenShot.captureScreenShot("TC_51_5");
		Thread.sleep(1000);
//		screenShot.captureScreenShot("TC_51_6");
		//Message display confirm
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
		
		//Click All properties Sub Menu
		propertypage.allLinkClick();
		screenShot.captureScreenShot("TC_51_7");
		Thread.sleep(2000);
		//input and search
		propertypage.propertySearchInput1(ts);
//		propertypage.displayRestore();
//		propertypage.displayRestore.getAttribute("post_title");
		String ss= propertypage.displayRestore.getText();
		System.out.println(ss);
		screenShot.captureScreenShot("TC_51_8");
	//Property restore Assertion
	try{
		Assert.assertEquals(ss, ts);
		System.out.println("Property Restore successfully and listed in ALL");
	}
	catch(Exception e){
		System.out.println("Property Restore is Failed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
