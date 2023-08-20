package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	@FindBy(name="lastname")
	private WebElement lastNameTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement selectOrgLookupImg;
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectOrgLookupImg() {
		return selectOrgLookupImg;
	}
	
}
