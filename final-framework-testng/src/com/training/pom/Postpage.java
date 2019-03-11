package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Postpage {

	private WebDriver driver;

	public Postpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	// click Post menu
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/a/div[3]")
	WebElement ClickPost;

	public void clickPostAction() {
		this.ClickPost.click();
	}


	// click ALL Post menu
	//*[@id="menu-posts"]/ul/li[2]/a
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[2]/a")
	WebElement ALLPost;

	public void clickALLPostAction() {
		this.ALLPost.click();
	}

		
	// Search the input and submit button

	@FindBy(id = "tag-search-input")
	WebElement SearchTagBox;

	public void SearchTag() {
		SearchTagBox.sendKeys("TC_");
		WebElement searchbutton = driver.findElement(By.id("search-submit"));
		searchbutton.click();
	}

	// click Tag link from menu
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[5]/a")
	WebElement ClickTag;

	public void clickTagAction() {
		this.ClickTag.click();
	}

	// select delete tag and click
	@FindBy(name = "delete_tags[]")
	WebElement selectListUser;

	public void selectUserList() {
		this.selectListUser.click();
	}

	// select delete tag and 
			// @FindBy(xpath = "//*[@id=\"tag-273\"]/td[1]/strong/a")
	@FindBy(xpath = "//*[@id=\"cb-select-273\"]")
	WebElement ClickTagName;

	public void selectTagDelete() {
		this.ClickTagName.click();
	}

	

	//Select Delete Drop down
	
	@FindBy(xpath = "//*[@id=\"bulk-action-selector-top\"]")
	WebElement deletebutton;

	public void deleteButton(String value) {
		Select option = new Select(deletebutton);
		// option.selectByIndex(index);
		option.selectByValue(value);
		// this.deletebutton.click();
	}

	//Select the record in User List
	
	@FindBy(id = "cb-select-all-1")
	WebElement selectNameCheckbox;

	public void selectNameCheckboxAction() {
		this.selectNameCheckbox.click();
	}

	//click Delete Button Apply
	
	@FindBy(id = "doaction")
	WebElement applyButton;

	public void applyDeleteButton() {
		this.applyButton.click();
	}


	//Display Message web element and get text
	
		@FindBy(id = "message")
		WebElement confirmMessageTag;
		
	public String tagDeleteConfirmMessage() {
		return this.confirmMessageTag.getText();

	}

	//Delete tag confirm message
	@FindBy(xpath = "//*[@id=\"message\"]/p")
	public WebElement display_Tag_Delete;

	public String displaychange() {
		String CT = display_Tag_Delete.getText();
		return CT;
	}

	//***************Post==>Categories Menu STARTS***************
	//*[@id="menu-posts"]/ul/li[2]/a
	//*[@id="menu-posts"]/ul/li[4]/a
	// click Categories link from menu
		@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[4]/a")
		WebElement menuCategories;
		public void clickCategoriesMenu() {
			this.menuCategories.click();
		}
	
		//Add New Category: Name, Slug, ParentCategory, Description
		@FindBy(id = "tag-name")
		WebElement inputNameAddNewCategory;

		public void NameAddNewCategory(String Name) {
			this.inputNameAddNewCategory.clear();
			this.inputNameAddNewCategory.sendKeys(Name);
		}

		// Input SLUG in AddNewcategory Menu under Post=>Categories

		@FindBy(id = "tag-slug")
		WebElement inputSlugAddNewCategory;

		public void SlugAddNewCategory(String Slug) {
			this.inputSlugAddNewCategory.clear();
			this.inputSlugAddNewCategory.sendKeys(Slug);
		}

		// select drop down in Parent Region Menu under Post=>Categories

		@FindBy(id = "parent")
		WebElement sParetFeatureAddNewCategory;

		public void selectParentFeatureAddNewCategory(String p_category) {
			Select option = new Select(sParetFeatureAddNewCategory);
//			 option.selectByIndex(index);
//			option.selectByValue(p_region);
			option.selectByVisibleText(p_category);
		}


		// INPUT DESCRIPTION in ADD NEW Region Menu under Post=>Categories
		@FindBy(id="tag-description")
		WebElement inputDescAddNewCategory;

		public void DescAddNewCategory(String desc) {
			this.inputDescAddNewCategory.clear();
			this.inputDescAddNewCategory.sendKeys(desc);
		}



		// click button ADD NEW Category Menu under Post=>Categories

		@FindBy(id="submit")
		WebElement buttonAddNewCategory;

		public void buttonAddNewCategoryClick(){
			this.buttonAddNewCategory.click();
			
		}
	//Region search input AND click
		@FindBy(id="tag-search-input")
		WebElement categorySearch;

		public void regionSearchInput(String ss) {
			this.categorySearch.clear();
			this.categorySearch.sendKeys(ss);//Search Regions
//			WebElement searchbutton = driver.findElement(By.id("search-submit"));
//			WebElement searchbutton = driver.findElement(By.name("Search Regions"));
			//*[@id="search-submit"]
			WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"search-submit\"]"));
			searchbutton.click();
		}
		
		
		
	//***************Post==>Categories Menu ENDS***************
}
