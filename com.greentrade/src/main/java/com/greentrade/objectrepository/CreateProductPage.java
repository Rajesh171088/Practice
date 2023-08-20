package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	@FindBy(name = "productname")
	private WebElement productNameTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement selectVendorLookupImg;
	
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTbx() {
		return productNameTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectVendorLookupImg() {
		return selectVendorLookupImg;
	}
	
}
