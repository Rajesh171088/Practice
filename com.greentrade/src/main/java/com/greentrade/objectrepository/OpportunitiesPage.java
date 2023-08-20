package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOpportunitiesLookupImg;
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCreateOpportunitiesLookupImg() {
		 createOpportunitiesLookupImg.click();
	}
	
	
}
