package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TestsRETC_53_1 {

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
		//Click on Submit, Input for Login and Password
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_53_0");
		Thread.sleep(2000);
		//Click property Menu
		propertypage.clickPropertyAction();
		screenShot.captureScreenShot("TC_53_1");
		//Click All properties Sub Menu
		propertypage.clickAllProperties();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_53_2");
		//click trash link
		propertypage.trashlinkclick();
		screenShot.captureScreenShot("TC_53_3");
		Thread.sleep(2000);
//		String sText="RET";
		//input and search property
		propertypage.propertySearchInput();
		//getting restore text displayed
		String ts= propertypage.displayRestore.getText();
		System.out.println(ts);
		//Mouse over the property row
		propertypage.rowMouseOver();		
		screenShot.captureScreenShot("TC_53_4");
		//Mouse over on Restore 
		propertypage.restoreMouseOver();
		screenShot.captureScreenShot("TC_53_5");
		Thread.sleep(1000);
//		screenShot.captureScreenShot("TC_53_6");
		//message display confirmation
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

//New launch using mouse key
		propertypage.mouseNewLaunch();
		screenShot.captureScreenShot("TC_53_7");
		Thread.sleep(2000);
		//New screen property input and confirm the display
		propertypage.newScreenPropertyInput(ts);
		

	
	
	
	
	
	
	
	}
}
