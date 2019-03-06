package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.NewUserPage;
import com.training.pom.Postpage;
import com.training.pom.UserPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_24 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewUserPage newuserpage;
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
		newuserpage = new NewUserPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		// driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {
		//Click on Submit, Input for Login and Password
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("TC24_0");
		Thread.sleep(2000);
		//Click user menu
		newuserpage.clickUserAction();
		//Click New user Sub menu
		newuserpage.ClickNewUserMenu();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC24_1");
		//Add New user Title
		newuserpage.sendUserName("userName3");
		//Add New user email
		newuserpage.sendEmailName("email3@resale.com");
		//Add New user First Name
		newuserpage.sendFirstName("firstName3");
		//Add New user Last Name
		newuserpage.sendLastName("lastName3");
		//Add New user URL
		newuserpage.sendURLName("urlName3");
		//Show password button click
		newuserpage.showPasswordButton();
		screenShot.captureScreenShot("TC24_2");
		Thread.sleep(1000);
		//Add password text
		newuserpage.addPassText("D266dhhk@");
		Thread.sleep(1000);
		//Add Role to New user
		newuserpage.addRole("agent");
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
