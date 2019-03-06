package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlogPage {

	private WebDriver driver;

	public BlogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Click on Header Blog menu	
	@FindBy(xpath = "//header[1]/div[2]/nav[1]/div[1]/ul[1]/li[7]/a[1]")
	WebElement headerBlogClick;
	public void clickPropertyAction() {
		this.headerBlogClick.click();
	}
	
	
	//Click on readmore button
	@FindBy(xpath = "//a [@href='http://realestate.upskills.in/new-launch/'][contains(text(),'Read More')]")
	WebElement readmoreClick;
	public void readmoreClickAction() {
		this.readmoreClick.click();
	}	
		
	//input comment on the Blog	
	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement commentBlog;
	@FindBy(xpath ="//input[@id='author']")
	public WebElement commentNameBlog;
	@FindBy(xpath ="//input[@id='email']")
	public WebElement commentEmailBlog;
	@FindBy(xpath ="//input[@id='url']")
	public WebElement commentURLBlog;
	@FindBy(xpath ="//input[@id='submit']")
	public WebElement commentSubmitBlog;
	
	public void commentBlog() {
		this.commentBlog.click();
		this.commentBlog.sendKeys("hai welcome6");
		this.commentNameBlog.sendKeys("Chennai_6");
		this.commentEmailBlog.sendKeys("hai3@gmail.com");
		this.commentURLBlog.sendKeys("realestate1");
		this.commentSubmitBlog.click();
	}
	//Mouse over sign link
	@FindBy(xpath="//a[@class='sign-in']")
	WebElement signlink;
	public void rowMouseOverSignLink() throws AWTException, InterruptedException{
		Actions act = new Actions(driver);
		act.contextClick(signlink).perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		ArrayList <String> googletabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("number of tabs opened="+googletabs.size());
		System.out.println("current url before switching "+driver.getCurrentUrl());
		driver.switchTo().window(googletabs.get(1)).getTitle();
		System.out.println("current url after switching "+driver.getCurrentUrl());
	}
//reply Comment MouseOver	
	
//	@FindBy(xpath ="//p[contains(text(),'this is very good property')]")
//	@FindBy(xpath ="//a[(@class='url')][contains(text(),'admin')]")
	@FindBy(xpath ="//a[(@class='url')][contains(text(),'Chennai')]")
	public WebElement recentCommentFrom;
	public void replyCommentMouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(recentCommentFrom).build().perform();
	}
	
	//Reply Comment Button Click
	@FindBy(xpath ="//a[@class='vim-r hide-if-no-js'][contains(text(),'Reply')]")
	//li[@id='comment-1838']//span[@class='reply hide-if-no-js'][contains(text(),'|')]
	//a[contains(text(),'TC_54')]//following::span[contains(text(),'Reply')]
	public WebElement replyComment;
	public void replyCommentButtonClick(){
		Actions action = new Actions(driver);
		action.moveToElement(replyComment).click().perform();
	}
	
	
	//reply Comment button click
	@FindBy(xpath ="//textarea[@id='replycontent']")
	public WebElement replyContent;
	@FindBy(xpath ="//span[@id='replybtn']")
	public WebElement buttonApproveReply;
	public void buttonApproveReplyClick(){
		this.replyContent.sendKeys("1 this is very good property");
		this.buttonApproveReply.click();
		}
	
		
		
	
	
	
	
}