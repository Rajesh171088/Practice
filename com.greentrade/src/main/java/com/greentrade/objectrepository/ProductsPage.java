package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductsLookupImg;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCreateProductsLookupImg() {
		 createProductsLookupImg.click();
	}
	
	
}
