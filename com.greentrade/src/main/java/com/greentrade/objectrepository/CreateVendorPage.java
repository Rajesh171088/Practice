package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	@FindBy(name = "vendorname")
	private WebElement vendorNameTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createVendor(String vendorName) {
		vendorNameTbx.sendKeys(vendorName);
		saveBtn.click();
	}
	
}
