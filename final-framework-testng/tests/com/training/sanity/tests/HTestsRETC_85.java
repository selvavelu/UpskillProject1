package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.NewPostPage;
import com.training.pom.Postpage;
import com.training.pom.PropertyPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//objective application allows admin to create region in property menu 
// added post details should get published and displayed on home screen
public class HTestsRETC_85 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewPostPage newpostpage;
	private PropertyPage propertypage;
	private static Properties properties;
	private ScreenShot screenShot;

	// @BeforeClass
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	// @BeforeMethod
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		newpostpage = new NewPostPage(driver);
		propertypage = new PropertyPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	// @AfterMethod
	@AfterClass
	public void tearDown() throws Exception {

//		 driver.quit();
	}
	//Login with Admin to Url
	@Test
	public void validLoginTest(){
		// Click on Submit, Input for Login and Password
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
//user adding New Region to property and publish post
//Adding New Region to the property
		
		@Test
		public void addNewRegionTest(){	
			//click on Property Menu
		propertypage.clickPropertyAction();
		//click on new region
		propertypage.clickRegions();
		//Input Name to New Region
		propertypage.NameAddNewRegion("Name");
		//slug Name to New Region
		propertypage.SlugAddNewRegion("Slug");
		//Input parent category to New Region
		propertypage.selectParetRegionAddNewRegion("Apartments");
		//Input Description to New Region
		propertypage.DescAddNewRegion("brigade road");
		//click on submit the new region input
		propertypage.buttonAddNewRegionsClick();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// driver.navigate().refresh();
		// propertypage.clickPropertyAction();
		// propertypage.clickAddNewProperties();
		//publish a post for this region
		}
		
		//Creating New post	and publish	
		@Test
		public void addNewPostTest() throws InterruptedException{	
		// click on posts in menu
		newpostpage.menuPosts();
		// Click on Add New post
		newpostpage.addNewPostClick();
		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Click on Add New Category
		newpostpage.addNewCatogeryClick();

		// Add New Enter Title Input
		newpostpage.addNewEnterTitleInput("Title");
		// input content to frame
		newpostpage.addNewEnterBodyInput("Body");
		// Click on All categories
		newpostpage.allCategoriesClick();
//		newpostpage.categorymyCheckSelect("New Launches");
		newpostpage.categorymyCheckSelect("RETC_018");
		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Click on Publish button
		newpostpage.publishButtonClick();
		
		}
		
		//message display and confirmation assertion
		@Test
		public void assertionMessageTest(){	
		try {
					newpostpage.messageDisplay.isDisplayed();
					String actual = newpostpage.displayMessage();
					System.out.println(actual);
					String expected = "Post published. View post";
					Assert.assertEquals(actual, expected);
					System.out.println("posted successfully and Confirmed");
				} catch (Exception e) {
					System.out.println("NOT Posted");
				}
		}
				
	//New launch New Home screen
		@Test
		public void realEstatehomescreenTest() throws AWTException, InterruptedException{	
				propertypage.mouseNewLaunch();
				screenShot.captureScreenShot("TC_53_7");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//New screen property input and confirm the display
			propertypage.newScreenPropertyInput("prestige");
//				propertypage.propertySearchInput1("prestige");
		}
				
	

}
