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
//objective  application allows admin to add multiple post based on the created category
public class HTestsRETC_83 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewPostPage newpostpage;
	private Postpage postpage;
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
		postpage = new Postpage(driver);
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
//login as admin
	
	@Test (priority= 1, dataProvider = "excel-inputs-login", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		
	}
	//adding new category getting input from excel
//enabled = false,
	@Test(priority= 2, dataProvider = "excel-inputs-HTestsRETC_83", dataProviderClass = LoginDataProviders.class)
	public void validRegionCreation(String Name, String Slug, String parentF, String description, String Title, String Body, String Category) throws InterruptedException {
	/*, String Title, String Body, String Category,, String Category
		*/
		propertypage.clickPropertyAction();
//		propertypage.clickRegions();
		postpage.clickPostAction();
		postpage.clickCategoriesMenu();

		postpage.NameAddNewCategory(Name);
		postpage.SlugAddNewCategory(Slug);
		screenShot.captureScreenShot("data"+Name);
		postpage.selectParentFeatureAddNewCategory(parentF);
		postpage.DescAddNewCategory(description);
		postpage.buttonAddNewCategoryClick();
//		driver.navigate().refresh();
	
		//click on posts in menu
		newpostpage.menuPosts();
		//click on posts in menu
		postpage.clickALLPostAction();
		//Click on Add New post
		newpostpage.addNewPostClick();
		
		
		//Add New Enter Title Input
		newpostpage.addNewEnterTitleInput(Title);
		//input content to frame
		newpostpage.addNewEnterBodyInput(Body);
		//Click on All categories
		newpostpage.allCategoriesClick();
		newpostpage.categorymyCheckSelect(Category);
//		driver.navigate().refresh();
		//Click on Publish button
		newpostpage.publishButtonClick();
		
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
