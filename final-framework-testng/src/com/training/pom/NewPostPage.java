package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewPostPage {

	private WebDriver driver;

	public NewPostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//click on posts in menu 
	@FindBy(xpath = "//*[@id=\"menu-posts\"]")
	WebElement menuPosts;

	public void menuPosts() {
		Actions action = new Actions(driver);
		action.moveToElement(menuPosts).build().perform();
	}

	//Click on Add New post
	@FindBy(xpath = "//a[@href='post-new.php']")
	WebElement addNewPost;

	public void addNewPostClick() {
		this.addNewPost.click();
	}

	//Click on Add New Category
	
	@FindBy(xpath = "//*[@id=\"category-add-toggle\"]")
	WebElement addNewCatogery;
	public void addNewCatogeryClick() {
		this.addNewCatogery.click();
	}

	//Add New Catogery Input
	
	@FindBy(xpath = "//input[@id='newcategory']")
	WebElement addNewCatogeryInput;

	public void addNewCatogeryInput() {
		this.addNewCatogeryInput.sendKeys("Plots chennai1");
	}
	
	//Category DropDown Selection
	
	@FindBy(xpath = "//*[@id=\"newcategory_parent\"]")
	WebElement categoryDD;
	public void categoryDDSelect(){
		Select cDropDown= new Select(categoryDD);
//		cDropDown.selectByValue("New Launches");
		cDropDown.selectByVisibleText("New Launches");
	}
	//*[@id="newcategory_parent"]/option[2]
//	driver.findElements(By.xpath ("//*[@id=\"newcategory_parent\"]"));
	@FindBy(xpath = "//*[@id=\"newcategory_parent\"]")
	WebElement categoryDD1;
	public void categoryDDSelect1(){
//		Select cDropDown= new Select(categoryDD1);
		List<WebElement> categorylist = driver.findElements(By.name("newcategory_parent"));
		for(WebElement checkbox : categorylist) {
		    System.out.println(checkbox.getAttribute("option"));
		    System.out.println(checkbox.getText());
		}
	}
	
	//Button Click on Add New Category
	@FindBy(xpath = "//input[@id='category-add-submit']")
	WebElement addNewCatogeryButton;

	public void addNewCatogeryButtonClick() {
		this.addNewCatogeryButton.click();
	}
	
	//Add New Enter Title Input
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement addNewEnterTitleInput;

	public void addNewEnterTitleInput(String place) {
		this.addNewEnterTitleInput.sendKeys(place);
	}
	
	//Click on All categories
	@FindBy(linkText ="All Categories")
	WebElement allCategories;
	public void allCategoriesClick(){
		this.allCategories.click();
			}
	
	//category Checkbox Selection
	@FindBy(id="in-category-325")
	WebElement newLaunch;
	
	public void categoryCheckSelect(){
		this.newLaunch.click();
		
	}
	
	//category Checkbox Selection- plot
	@FindBy(id="in-category-370")
	WebElement newPlot1;
	public void categoryPlotCheckSelect1(){
		this.newPlot1.click();
	}

	//category Checkbox Selection- plot
	@FindBy(id="in-category-371")
	WebElement newPlot2;
	public void categoryPlotCheckSelect2(){
		this.newPlot2.click();
	}
	
	//input content to frame
	
	public void frameTest() {
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("/html[1]/body[1]"));
		frame.sendKeys("This is new site");
		driver.switchTo().defaultContent();
	}
	
	
	//Click on Publish button
	@FindBy(id="publish")
	WebElement publishButton;
	public void publishButtonClick(){
		this.publishButton.click();
	}

	//message display and confirmation
	@FindBy(xpath="//*[@id=\"message\"]/p")
	public WebElement messageDisplay;
	public String displayMessage(){
		return messageDisplay.getText();
		}
	
	
	@FindBy(id = "tag-search-input")
	WebElement SearchTagBox;

	public void SearchTag() {
		SearchTagBox.sendKeys("TC_");
		WebElement searchbutton = driver.findElement(By.id("search-submit"));
		searchbutton.click();
	}

	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[5]/a")
	WebElement ClickTag;
	
	public void clickTagAction() {
		this.ClickTag.click();
	}

	// @FindBy(xpath = "//*[@id=\"tag-273\"]/td[1]/strong/a")
	@FindBy(xpath = "//*[@id=\"cb-select-273\"]")
	WebElement ClickTagName;

	
	@FindBy(name="delete_tags[]")
	WebElement selectListUser;
	public void selectUserList() {
		this.selectListUser.click();
	}
	
	
	public void selectTagDelete() {
		this.ClickTagName.click();
	}

	@FindBy(id = "message")
	WebElement confirmMessageTag;

	@FindBy(xpath = "//*[@id=\"bulk-action-selector-top\"]")
	WebElement deletebutton;

	public void deleteButton(String value) {
		Select option = new Select(deletebutton);
		// option.selectByIndex(index);
		option.selectByValue(value);
		// this.deletebutton.click();
	}

	@FindBy(id = "cb-select-all-1")
	WebElement selectNameCheckbox;

	public void selectNameCheckboxAction() {
		this.selectNameCheckbox.click();
	}

	@FindBy(id = "doaction")
	WebElement applyButton;

	public void applyDeleteButton() {
		this.applyButton.click();
	}
	
	
	
	
	public String tagDeleteConfirmMessage() {
		return this.confirmMessageTag.getText();

	}
	
	@FindBy(xpath="//*[@id=\"message\"]/p")
	public WebElement display_Tag_Delete;
	public String displaychange(){
		String CT=display_Tag_Delete.getText();
		return CT;
	}







	//*[@id="wp-admin-bar-site-name"]/a



}
