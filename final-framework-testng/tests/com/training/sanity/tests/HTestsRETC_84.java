package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
import com.training.pom.NewUserPage;
import com.training.pom.NewUserPage2;
import com.training.pom.Postpage;
import com.training.pom.UserPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//objective is creation user Add New by admin
public class HTestsRETC_84 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewUserPage newuserpage;
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
		newuserpage = new NewUserPage(driver);
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
// login as admin
	@Test (priority= 1, dataProvider = "excel-inputs-login", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot(userName);
		
	}
	//Adding New user getting value from excel
//enabled = false,
	@Test(priority= 2, dataProvider = "excel-inputs-HTestsRETC_84", dataProviderClass = LoginDataProviders.class)
	public void validUserCreation(String UName, String Email, String FName,String LName, String URL, String Pword, String Role) throws InterruptedException {
	/*, String Title, String Body, String Category,, String Category
		*/
	
		//Click user menu
		newuserpage.clickUserAction();
		//Click New user Sub menu
		newuserpage.ClickNewUserMenu();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC24_1");
		//Add New user Title
		newuserpage.sendUserName(UName);
		//Add New user email
		newuserpage.sendEmailName(Email);
		//Add New user First Name
		newuserpage.sendFirstName(FName);
		//Add New user Last Name
		newuserpage.sendLastName(LName);
		//Add New user URL
		newuserpage.sendURLName(URL);
		//Show password button click
		newuserpage.showPasswordButton();
		screenShot.captureScreenShot("TC24_2");
		Thread.sleep(1000);
		//Add password text
		newuserpage.addPassText(Pword);
		//"D266dhhk@"
		Thread.sleep(1000);
		//Add Role to New user
		newuserpage.addRole(Role);
		screenShot.captureScreenShot("TC24_3");
		//click Add create button in New user
		newuserpage.addCreateNewUserButton();
			// customer
			// agent
			// contributor
			// String actual = newuserpage.display_user_Add.getText();
			// System.out.println(actual);//New user created. Edit user
		screenShot.captureScreenShot("TC24_4");
		//Display message after click create New user
		try {
			newuserpage.display_user_Add.isDisplayed();
			String actual = newuserpage.displayMessageAdd();
			String expected = "New user created. Edit user";
			Assert.assertEquals(actual, expected);
			System.out.println("User successfully added and Confirmed");
		} catch (Exception e) {
			System.out.println("User is NOT Added");
		}

	}

}
