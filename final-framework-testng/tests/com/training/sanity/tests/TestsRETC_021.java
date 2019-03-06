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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_021 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Postpage postpage;
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
		postpage = new Postpage(driver);
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
		screenShot.captureScreenShot("Step 0");
		Thread.sleep(2000);
		
		//click Post menu and screenshot
		postpage.clickPostAction();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 1");
		
		//click Tag link from menu and screenshot
		postpage.clickTagAction();
		screenShot.captureScreenShot("Step 2");
		//Search the tag and submit button
		postpage.SearchTag();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 3");

		//Select the record in User List and screenshot
		postpage.selectUserList();
		screenShot.captureScreenShot("step_4");
/*
				postpage.selectNameCheckboxAction();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 4");

		/*
		 * postpage.selectTagDelete(); screenShot.captureScreenShot("Step 3");
		 */
		
		//Select Delete link and click delete action
		postpage.deleteButton("delete");
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 5");
		postpage.applyDeleteButton();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 6");

		//Delete tag confirm
		postpage.tagDeleteConfirmMessage();
		Thread.sleep(1000);
		screenShot.captureScreenShot("Step 7");
/*
//		try {
//			driver.findElement(By.xpath("//*[@id=\"message\"]/p")).isDisplayed();
//			System.out.println("Tag successfully Detected and Confirmed");
//		} catch (Exception e) {
//			System.out.println("Tag is NOT Delected");
		}
*/
		//Display Message, confirm Actual and expects
		try {
			postpage.display_Tag_Delete.isDisplayed();
			String actual = postpage.displaychange();
			String expected = "Tags deleted.";
			Assert.assertEquals(actual, expected);
			System.out.println("Tag successfully Detected and Confirmed");
		} catch (Exception e) {
			System.out.println("Tag is NOT Delected");
		}
		
		
	}
}
