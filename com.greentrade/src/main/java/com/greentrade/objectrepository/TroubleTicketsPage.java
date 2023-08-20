package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsPage {
	@FindBy(xpath = "//img[@alt='Create Ticket...']")
	private WebElement createTroubleTicketsLookupImg;
	
	public TroubleTicketsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCreateTroubleTicketsLookupImg() {
		 createTroubleTicketsLookupImg.click();
	}
	
	

	
}
