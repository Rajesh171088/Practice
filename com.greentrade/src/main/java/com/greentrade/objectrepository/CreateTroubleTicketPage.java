package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTroubleTicketPage {
	@FindBy(name = "ticket_title")
	private WebElement titleTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@id='parentid']/following-sibling::img")
	private WebElement selectContactLookupImg;
	
	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement selectProductLookupImg;
	
	public CreateTroubleTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitleTbx() {
		return titleTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectContactLookupImg() {
		return selectContactLookupImg;
	}

	public WebElement getSelectProductLookupImg() {
		return selectProductLookupImg;
	}
	
	
	
}
