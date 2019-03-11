package com.training.pom;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewUserPage2 {

	private WebDriver driver;

	public NewUserPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Click User menu
	@FindBy(xpath = "//div[contains(text(),'Users')]")
	WebElement ClickUser;

	public void clickUserAction() {
		this.ClickUser.click();
	}

	//Click New User Sub menu
		// a[@href='user-new.php']
	@FindBy(xpath = "//a[@href='user-new.php']")
	WebElement ClickNewUser;

	public void ClickNewUserMenu() {
		this.ClickNewUser.click();
	}

	//Add New user Title
	@FindBy(xpath = "//h1[@id='add-new-user']")
	WebElement addNewUserTitle;

	//Add New user Name
	@FindBy(id = "user_login")
	WebElement addUserName;

	public void sendUserName(String userName) {
		this.addUserName.clear();
		this.addUserName.sendKeys(userName);
	}

	//Add New user email
	@FindBy(id = "email")
	WebElement addEmail;

	public void sendEmailName(String email) {
		this.addEmail.clear();
		this.addEmail.sendKeys(email);
	}
	//Add New user First Name
	@FindBy(id = "first_name")
	WebElement addFirstName;

	public void sendFirstName(String firstName) {
		this.addFirstName.clear();
		this.addFirstName.sendKeys(firstName);
	}
	//Add New user Last Name
	@FindBy(id = "last_name")
	WebElement addLastName;

	public void sendLastName(String lastName) {
		this.addLastName.clear();
		this.addLastName.sendKeys(lastName);
	}
	//Add New user URL
	@FindBy(id = "url")
	WebElement addURL;

	public void sendURLName(String urlName) {
		this.addURL.clear();
		this.addURL.sendKeys(urlName);
	}
//Show password button click
	@FindBy(xpath = "//button[contains(text(),'Show password')]")
	WebElement showPasswordButton;

	public void showPasswordButton() {
		this.showPasswordButton.click();
	}
	//Add password text
	@FindBy(xpath = "//input[@name='pass1-text']")
	WebElement addPassText;

	public void addPassText(String value) {
		this.addPassText.clear();
		this.addPassText.sendKeys(value);
	}
	//Add Role to New user
	@FindBy(id = "role")
	WebElement addRole;
	public void addRole(String value) {
		Select option = new Select(addRole);
		option.selectByValue(value);
	}

	//Add HUB to New user
	@FindBy(id = "createusersub")
	WebElement addCreateNewUserButton;

	public void addCreateNewUserButton() {
		this.addCreateNewUserButton.click();

	}

	//Display message after click create New user
	@FindBy(xpath = "//p[contains(text(),'New user created.')]")
	public WebElement display_user_Add;

	public String displayMessageAdd() {
		String CT = display_user_Add.getText();
		return CT;
	}

}
