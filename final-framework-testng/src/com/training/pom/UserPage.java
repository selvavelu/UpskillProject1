package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserPage {

	private WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//click User menu
	@FindBy(xpath = "//div[contains(text(),'Users')]")
	WebElement ClickUser;

	public void clickUserAction() {
		this.ClickUser.click();
	}

	//click ALL User sub menu
	@FindBy(xpath = "//a[@class='wp-first-item current']")
	WebElement ClickAllUsers;

	public void clickAllUsers() {
		this.ClickAllUsers.click();
	}

	//Input user search and click search button
	@FindBy(name="users[]")
	WebElement userRowCheck;
	
	
	@FindBy(xpath = "//input[@id='user-search-input']")
	WebElement UserSearch;

	public void userSearchInput() {
		UserSearch.sendKeys("TC_");
		WebElement searchbutton = driver.findElement(By.id("search-submit"));
		searchbutton.click();
	}
	//Select the list user checkbox
	@FindBy(name="users[]")
	WebElement selectListUser;
	public void selectUserList() {
		this.selectListUser.click();
	}
	
	@FindBy(id = "cb-select-all-1")
	WebElement selectNameCheckbox;

	public void selectNameCheckboxAction() {
		this.selectNameCheckbox.click();
	}

	//Bulk action Delete button select
	@FindBy(xpath = "//*[@id=\"bulk-action-selector-top\"]")
	WebElement deletebutton;

	public void deleteButton(String value) {
		Select option = new Select(deletebutton);
		// option.selectByIndex(index);
		option.selectByValue(value);
		// this.deletebutton.click();
	}
	
	//Bulk action Delete select and click Apply button 
	@FindBy(id = "doaction")
	WebElement applyButton;

	public void applyDeleteButton() {
		this.applyButton.click();
	}
	
	@FindBy(id ="submit")
//	@FindBy(xpath="//*[@id=\"submit\"])")
	WebElement confirmDelectionButton;
	public void confirmDeleteButton() {
		this.confirmDelectionButton.click();
	}

	/*public String tagDeleteConfirmMessage() {
		return this.confirmMessageTag.getText();

	}
*/	
	
	//Display Message
	
	@FindBy(xpath="//*[@id=\"message\"]/p")
	public WebElement display_user_Delete;
	public String displayMessageDelete(){
		String CT=display_user_Delete.getText();
		return CT;
	}

		
	//Select role to be change
	@FindBy(xpath = "//select[@id='new_role']")
	WebElement changeUserRole;

	public void changeUserRoleSelect(String role) {
		Select option = new Select(changeUserRole);
		option.selectByValue(role);
	}
	//Click change button for Selected role change
	@FindBy(id = "changeit")
	WebElement changeButton;

	public void changeButtonClick() {
		this.changeButton.click();
	}
	//Confirm the Role change message
	
	@FindBy(xpath="//p[contains(text(),'Changed roles.')]")
	public WebElement display_Changed_Role;
	public String displaychange(){
		String CT=display_Changed_Role.getText();
		return CT;
	}
	
	
}
