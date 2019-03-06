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
import com.training.pom.Postpage;
import com.training.pom.UserPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_23 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UserPage userpage;
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
		userpage = new UserPage(driver);
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
		screenShot.captureScreenShot("TC23_0");
		Thread.sleep(2000);
		//Click user menu
		userpage.clickUserAction();
		Thread.sleep(2000);
		screenShot.captureScreenShot("TC23_1");
		//click All Users sub menu
		userpage.clickAllUsers();
		Thread.sleep(1000);
		screenShot.captureScreenShot("TC23_2");
		//Giving Search user Input
		userpage.userSearchInput();
		Thread.sleep(1000);
//		userpage.selectNameCheckboxAction();
//		Thread.sleep(1000);
		screenShot.captureScreenShot("TC23_3");
		//select user from list
		userpage.selectUserList();
		screenShot.captureScreenShot("TC23_4");
		//Bulk action select and apply Delete action
		userpage.deleteButton("delete");
		userpage.applyDeleteButton();
		Thread.sleep(1000);
		//Delete confirm button click
		userpage.confirmDeleteButton();
		//Confirm the delete message
		try {
			userpage.display_user_Delete.isDisplayed();
			String actual = userpage.displayMessageDelete();
			System.out.println(actual);
			String expected = "User deleted.";
			Assert.assertEquals(actual, expected);
			System.out.println("User successfully Deleted and Confirmed");
		} catch (Exception e) {
			System.out.println("User is NOT Deleted");
		}
		
		

}

}
