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


}
