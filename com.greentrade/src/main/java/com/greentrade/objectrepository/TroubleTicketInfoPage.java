package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketInfoPage {
	@FindBy(xpath = "//td[text()='Title']/following-sibling::td[@id='mouseArea_Title']")
	private WebElement titledisplayed;
	
	@FindBy(xpath = "//td[text()='Contact Name']/following-sibling::td[@align='left']")
	private WebElement contactdisplayed;
	
	@FindBy(xpath = "//td[text()='Product Name']/following-sibling::td[@align='left']")
	private WebElement productdisplayed;
	
	public TroubleTicketInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	public WebElement getTitledisplayed() {
		return titledisplayed;
	}

	public WebElement getContactdisplayed() {
		return contactdisplayed;
	}

	public WebElement getProductdisplayed() {
		return productdisplayed;
	}
	
	
}
