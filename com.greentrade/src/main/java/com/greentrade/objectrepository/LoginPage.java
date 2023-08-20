package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement unTbx;
	
	@FindBy(name = "user_password")
	private WebElement pwdTbx;
	
	@FindBy(id = "submitButton")
	private WebElement lgBtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String userName, String password) throws Throwable {
		unTbx.sendKeys(userName);
		pwdTbx.sendKeys(password);
		lgBtn.click();
	}

	public WebElement getUnTbx() {
		return unTbx;
	}

	public WebElement getPwdTbx() {
		return pwdTbx;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	
}
