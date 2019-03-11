package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertyPage {

	private WebDriver driver;

	public PropertyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Click property Menu
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/a/div[3]")
	WebElement ClickProperty;

	public void clickPropertyAction() {
		this.ClickProperty.click();
	}
	//Click All properties Sub Menu
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[2]/a")
	WebElement ClickAllProperties;

	public void clickAllProperties() {
		this.ClickAllProperties.click();
	}

	
	//*[@id="menu-posts-property"]/ul/li[3]/a
	
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[3]/a")
	WebElement ClickAddNew;

	public void clickAddNewProperties() {
		this.ClickAddNew.click();
	}
	
	//Select Date drop down	
		// @FindBy(xpath = "//*[@id=\"filter-by-date\"]")
		// @FindBy(id="filter-by-date")
	@FindBy(xpath = "//select[@name='m']")
	WebElement allDateDropDown;

	public void dateSelect(String month) {
		Select option = new Select(allDateDropDown);
		// option.selectByIndex(index);
		option.selectByValue(month);
		// this.deletebutton.click();
	}

	//Apply Date filter button
	@FindBy(id = "post-query-submit")
	WebElement dateFilterButton;

	public void applyDateFilterButton() {
		this.dateFilterButton.click();
	}

	//Click on Trash Link
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/ul/li[4]/a")
	WebElement trashlink;

	public void trashlinkclick() {
		this.trashlink.click();
	}

	
	//Mouse over trash row Link 
	@FindBy(name = "post[]")
	// @FindBy(xpath="//*[@id=\"post-667\"]/td[1]")
	WebElement trashrow;

	public void rowMouseOver() {
		// WebElement element = driver.findElement(By.linkText("Product
		// Category"));
		Actions action = new Actions(driver);
		action.moveToElement(trashrow).build().perform();
	}
	//restore click on MouseOver element
	// @FindBy(xpath="//*[@id=\"post[]\"]/td[1]/div[2]/span[1]/a")
	@FindBy(xpath = "//table//tbody//tr//td//span//a[contains(text(),'Restore')]")
	WebElement restorelink;

	public void restoreMouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(restorelink).click().build().perform();
	}

	//Hidden Trash link Mouse over
	@FindBy(xpath = "//table//tbody//tr//td//span//a[contains(text(),'Trash')]")
	public WebElement trashHlink;

	public void trashHlinkMouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(trashHlink).click().build().perform();
	}

	//Display Message
	@FindBy(xpath = "//*[@id=\"message\"]/p")
	public WebElement messageDisplay;

	public String displayMessage() {
		String CT = messageDisplay.getText();
		return CT;
	}

	// ALL LINK CLICK
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/ul/li[1]/a")
	WebElement allLink;

	public void allLinkClick() {
		this.allLink.click();
	}

	//Restore click
		// @FindBy(xpath="//table//tbody//tr//td//strong[contains(text(),'Man')]")
	@FindBy(xpath = "//table/tbody//tr[1]//td[1]//strong")
	public WebElement displayRestore;

	public void displayRestore() {
		this.displayRestore.click();

	}

	// launch home page in New window
	public void mouseNewLaunch() throws AWTException, InterruptedException {

		WebElement gmailtab = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-site-name\"]/a"));
		Actions act = new Actions(driver);
		act.contextClick(gmailtab).perform();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		ArrayList<String> googletabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("number of tabs opened=" + googletabs.size());
		System.out.println("current url before switching " + driver.getCurrentUrl());
		driver.switchTo().window(googletabs.get(1)).getTitle();
		System.out.println("current url after switching " + driver.getCurrentUrl());
		// driver.findElement(By.xpath("//*[@id=\"ajaxsearchlite1\"]/div/div[3]/form/input[1]")).sendKeys("RETC_051_2");
		// driver.findElement(By.xpath("//*[@id=\"ajaxsearchlite1\"]/div/div[1]/div/svg")).click();

	}
	//New screen property input and confirm the display
	public void newScreenPropertyInput(String sText) {

		driver.findElement(By.xpath("//input[@placeholder='Search here for Properties..']")).sendKeys(sText);
		driver.findElement(By.xpath("//div[@class=\'promagnifier\']//*[@version='1.1']")).click();
		driver.findElement(By.xpath("//div[@class=\'resdrg\']//div[1]//div[1]//h3[1]")).click();
	}

	//input and search
	@FindBy(xpath = "//input[@id='post-search-input']")
	WebElement propertySearch;
	// public String sText="RETC_";
	public String sText = "prestige";

	public void propertySearchInput() {
		propertySearch.sendKeys(sText);
		WebElement searchbutton = driver.findElement(By.id("search-submit"));
		searchbutton.click();
	}

	@FindBy(xpath = "//input[@id='post-search-input']")
	WebElement propertySearch1;

	// public String sText="RETC_";
	// public String sText="prestige";
	public void propertySearchInput1(String ss) {
		propertySearch1.sendKeys(ss);
		WebElement searchbutton = driver.findElement(By.id("search-submit"));
		searchbutton.click();
	}

	// hidden trash permanently link click in Trash

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/div[2]/span[2]/a[1]")
	WebElement trashHPermanent;

	public void trashHPermanentClick() {
		this.trashHPermanent.click();

	}

	public void mouseclick() {
		driver.get("http://automate-apps.com/");
		System.out.println(driver.getTitle());
		Actions action = new Actions(driver);
		// WebElement element = driver.findElement(By.partialLinkText("SELENIUM
		// QUESTIONS"));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"menu-item-1284\"]/a"));

		action.contextClick(element).build().perform();
		// sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER);
		// action.build().perform();
		// Set<String> winid = driver.getWindowHandles();
		// Iterator<String> iter = winid.iterator();
		// iter.next();
		// String tab = iter.next();
		// driver.switchTo().window(tab);
		// System.out.println(driver.getTitle());
	}

	// ******Regions function added here***********

	// click Regions Menu under Properties

	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[5]/a")
	WebElement clickRegions;

	public void clickRegions() {
		this.clickRegions.click();
	}
	//  Regions-- Start ADD NEW REGION Regions Menu under Properties	
	// Input NAME in AddNewRegion Menu under Properties-Regions

	@FindBy(id = "tag-name")
	WebElement inputNameAddNewRegion;

	public void NameAddNewRegion(String Name) {
		this.inputNameAddNewRegion.clear();
		this.inputNameAddNewRegion.sendKeys(Name);
	}

	// Input SLUG in AddNewRegion Menu under Properties-Regions

	@FindBy(id = "tag-slug")
	WebElement inputSlugAddNewRegion;

	public void SlugAddNewRegion(String Slug) {
		this.inputSlugAddNewRegion.clear();
		this.inputSlugAddNewRegion.sendKeys(Slug);
	}

	// select drop down in Parent Region Menu under Properties-Regions

	@FindBy(id = "parent")
	WebElement sParetRegionAddNewRegion;

	public void selectParetRegionAddNewRegion(String p_region) {
		Select option = new Select(sParetRegionAddNewRegion);
//		 option.selectByIndex(index);
//		option.selectByValue(p_region);
		option.selectByVisibleText(p_region);
	}


	// INPUT DESCRIPTION in ADD NEW Region Menu under Properties-Regions
	@FindBy(id="tag-description")
	WebElement inputDescAddNewRegion;

	public void DescAddNewRegion(String desc) {
		this.inputDescAddNewRegion.clear();
		this.inputDescAddNewRegion.sendKeys(desc);
	}



	// click button ADD NEW REGION Regions Menu under Properties

	@FindBy(id="submit")
	WebElement buttonAddNewRegions;

	public void buttonAddNewRegionsClick(){
		this.buttonAddNewRegions.click();
		
	}
//Region search input AND click
	@FindBy(id="tag-search-input")
	WebElement regionSearch;

	public void regionSearchInput(String ss) {
		this.regionSearch.clear();
		this.regionSearch.sendKeys(ss);//Search Regions
//		WebElement searchbutton = driver.findElement(By.id("search-submit"));
//		WebElement searchbutton = driver.findElement(By.name("Search Regions"));
		//*[@id="search-submit"]
		WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"search-submit\"]"));
		searchbutton.click();
	}
	
	
	
	
	// END ADD NEW REGION Regions Menu under Properties			


//  Regions-- DB Start ADD NEW REGION Regions Menu under Properties	
	// Input NAME in AddNewRegion Menu under Properties-Regions

	@FindBy(id = "tag-name")
	WebElement inputNameAddNewRegion1;

	public String NameAddNewRegionDB(String Name) {
		this.inputNameAddNewRegion1.clear();
		this.inputNameAddNewRegion1.sendKeys(Name);
		return inputNameAddNewRegion1.getAttribute("value");
	}

	// Input SLUG in AddNewRegion Menu under Properties-Regions

	@FindBy(id = "tag-slug")
	WebElement inputSlugAddNewRegion1;

	public String SlugAddNewRegionDB(String Slug) {
		this.inputSlugAddNewRegion1.clear();
		this.inputSlugAddNewRegion1.sendKeys(Slug);
		return inputSlugAddNewRegion1.getAttribute("value");
	}

	// select drop down in Parent Region Menu under Properties-Regions

	@FindBy(id = "parent")
	WebElement sParetRegionAddNewRegion1;

	public String selectParetRegionAddNewRegionDB(String p_region) {
		Select option = new Select(sParetRegionAddNewRegion1);
//		 option.selectByIndex(index);
//		option.selectByValue(p_region);
		option.selectByVisibleText(p_region);
		return p_region;
	}


	// INPUT DESCRIPTION in ADD NEW Region Menu under Properties-Regions
	@FindBy(id="tag-description")
	WebElement inputDescAddNewRegion1;

	public String DescAddNewRegionDB(String desc) {
		this.inputDescAddNewRegion1.clear();
		this.inputDescAddNewRegion1.sendKeys(desc);
		return inputDescAddNewRegion1.getAttribute("value");
	}



	// click button ADD NEW REGION Regions Menu under Properties


	
	
	
	
	
	
	
//id="tag-description"/


/*
 * Actions action = new Actions(driver); WebElement link
 * =driver.findElement(By.xpath(
 * "//button[text()='Double-Click Me To See Alert']"));
 * action.doubleClick(link).perform()
 */;

 /*
  * WebElement rightclickelement = driver.findElement(By.xpath(
  * "/html/body/div[1]/div[1]/div/section/div[5]/div[2]/div[2]/ul/li[1]/div/div[2]/h2/a"
  * )); Actions action = new Actions(driver);
  * action.moveToElement(rightclickelement);
  * action.contextClick(rightclickelement).sendKeys(Keys.ARROW_DOWN).sendKeys(
  * Keys.ENTER).build().perform();
  * 
  * Actions action = new Actions(driver);
  * action.contextClick(WebElement).build().perform(); Robot robot = new Robot();
  * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
  * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
  */

}