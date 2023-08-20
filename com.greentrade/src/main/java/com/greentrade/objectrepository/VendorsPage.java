package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorLookupImg;
	
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCreateVendorLookupImg() {
		createVendorLookupImg.click();
	}
	
	
}
