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
import com.training.pom.BlogPage;
import com.training.pom.LoginPOM;
import com.training.pom.Postpage;
import com.training.pom.PropertyPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestsRETC_54_2 {

	private WebDriver driver;
	private String baseUrl;
	private String baseUrl1;
	private LoginPOM loginPOM;
	private BlogPage blogpage; 
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
		blogpage = new BlogPage(driver);
//		baseUrl = properties.getProperty("baseURL");
		baseUrl1 = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl1);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
	
	@Test
	public void bloginput() throws InterruptedException, AWTException{
		blogpage.clickPropertyAction();
		Thread.sleep(2000);
		blogpage.readmoreClickAction();
		Thread.sleep(2000);
		screenShot.captureScreenShot("TC_54_1");
		blogpage.commentBlog();
		screenShot.captureScreenShot("TC_54_2");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		blogpage.rowMouseOverSignLink();
		screenShot.captureScreenShot("TC_54_3");
/*	
		driver.get(baseUrl);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("TC_54_4");
		blogpage.replyCommentMouseOver();
		screenShot.captureScreenShot("TC_54_5");
		blogpage.replyCommentButtonClick();
		screenShot.captureScreenShot("TC_54_6");
		blogpage.buttonApproveReplyClick();
		screenShot.captureScreenShot("TC_54_7");
		driver.navigate().refresh();
		
	*/
	
	
	
	
	
	
	
	}
}
