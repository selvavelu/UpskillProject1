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

public class TestsRETC_51 {

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
//		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		
		propertypage.mouseclick();
		/*
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_25_0");
		Thread.sleep(2000);
		propertypage.clickPropertyAction();
		screenShot.captureScreenShot("TC_25_1");
		propertypage.clickAllProperties();
		Thread.sleep(2000);
		screenShot.captureScreenShot("TC_25_2");

		propertypage.propertySearchInput();
		
		
		propertypage.trashlinkclick();
		screenShot.captureScreenShot("TC_25_3");
		Thread.sleep(2000);
		propertypage.rowMouseOver();		
		screenShot.captureScreenShot("TC_25_4");
		
		propertypage.restoreMouseOver();
		screenShot.captureScreenShot("TC_25_5");
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_25_6");
		
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
		
		propertypage.allLinkClick();
		screenShot.captureScreenShot("TC_25_7");
		Thread.sleep(2000);
//		propertypage.displayRestore();
//		propertypage.displayRestore.getAttribute("post_title");
		String ss= propertypage.displayRestore.getText();
		System.out.println(ss);
		screenShot.captureScreenShot("TC_25_8");
*/	
		}
}
