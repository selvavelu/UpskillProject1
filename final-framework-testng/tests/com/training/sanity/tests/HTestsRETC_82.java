package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.NewPostPage;
import com.training.pom.Postpage;
import com.training.pom.PropertyPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//objective application allows admin to Add Multiple Region in the application
public class HTestsRETC_82 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewPostPage newpostpage;
	private PropertyPage propertypage;
	private static Properties properties;
	private ScreenShot screenShot;

//	@BeforeClass
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

//	@BeforeMethod
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

//	@AfterMethod
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		// driver.quit();
	}

	//login as admin and Navigate to Property Regions
	
	@Test (priority= 1, dataProvider = "excel-inputs-login", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		propertypage.clickPropertyAction();
		propertypage.clickRegions();

	}
//	Adding New Regions below getting input from excel
//enabled = false,
	@Test(priority= 2, dataProvider = "excel-inputs-HTestsRETC_82", dataProviderClass = LoginDataProviders.class)
	public void validRegionCreation(String Name, String Slug, String p_region, String desc) throws InterruptedException {
		propertypage.NameAddNewRegion(Name);
		propertypage.SlugAddNewRegion(Slug);
		screenShot.captureScreenShot("data"+Name);
		propertypage.selectParetRegionAddNewRegion(p_region);
		propertypage.DescAddNewRegion(desc);
		propertypage.buttonAddNewRegionsClick();
		driver.navigate().refresh();
		//message display and confirmation
		//Message display confirm
				try {
					propertypage.messageDisplay.isDisplayed();
					String actual = propertypage.displayMessage();
					System.out.println(actual);
					String expected = "Regions Added";
					Assert.assertEquals(actual, expected);
					System.out.println("Region successfully and Confirmed");
				} catch (Exception e) {
					System.out.println("NOT added Region");
				}
	}
	
	
		
	
}
