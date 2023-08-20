package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getOrgNameTbx() {
		return orgNameTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

}
