package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@name=\"submitAuth\"]")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),\"Sign up\")]")
	private WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(),\"I lost my password\")]")
	private WebElement lostPwdLink;
	
	@FindBy(xpath="//title[contains(text(),'My Organization')]")
	private WebElement loginPgTitle;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement profileDD;
	
	@FindBy(id="logout_button")
	private WebElement logoutLnk;
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickSignUpLink() {
		this.signUpLink.click(); 
	}
	public void clickLostPwdLink() {
		this.lostPwdLink.click(); 
	}

	public String getLoginPgTitle() {
		return this.driver.getTitle();
	}
	
}
