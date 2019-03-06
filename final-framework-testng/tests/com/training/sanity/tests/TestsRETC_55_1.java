package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
import com.training.pom.NewPostPage;
import com.training.pom.Postpage;
import com.training.pom.PropertyPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_55_1 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewPostPage newpostpage; 
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
		newpostpage = new NewPostPage(driver);
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
		screenShot.captureScreenShot("TC_55_0");
		Thread.sleep(2000);
		//click on posts in menu
		newpostpage.menuPosts();
		//Click on Add New post
		newpostpage.addNewPostClick();
		//Click on Add New Category
		newpostpage.addNewCatogeryClick();
		screenShot.captureScreenShot("TC_55_1");
		//Add New Catogery Input
		newpostpage.addNewCatogeryInput();
		//Category DropDown Selection
		newpostpage.categoryDDSelect();
		screenShot.captureScreenShot("TC_55_2");
		Thread.sleep(1000);
		//Button Click on Add New Category
		newpostpage.addNewCatogeryButtonClick();
		screenShot.captureScreenShot("TC_55_3");
		driver.navigate().refresh();
		//Add New Enter Title Input
		newpostpage.addNewEnterTitleInput("Vihar");
		//input content to frame
		newpostpage.frameTest();
		screenShot.captureScreenShot("TC_55_4");
		Thread.sleep(1000);
		//Click on All categories
		newpostpage.allCategoriesClick();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC_55_5");
		//category Checkbox Selection
		newpostpage.categoryCheckSelect();
		//category Checkbox Selection- plot
		newpostpage.categoryPlotCheckSelect1();
		newpostpage.categoryPlotCheckSelect2();
		screenShot.captureScreenShot("TC_55_6");
		driver.navigate().refresh();
		//Click on Publish button
		newpostpage.publishButtonClick();
		screenShot.captureScreenShot("TC_55_7");
		
		//message display and confirmation
		try {
			newpostpage.messageDisplay.isDisplayed();
			String actual = newpostpage.displayMessage();
			System.out.println(actual);
			String expected = "Post published. View post";
			Assert.assertEquals(actual, expected);
			System.out.println("Restored successfully and Confirmed");
		} catch (Exception e) {
			System.out.println("NOT Restored");
		}

		
		
	
	
	
	
	
	
	
	
	
	}
}
