package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentrade.genericutility.WebActionUtility;

public class HomePage {
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Quotes")
	private WebElement qotesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutLookupImg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getQotesLink() {
		return qotesLink;
	}

	public WebElement getSignOutLookupImg() {
		return signOutLookupImg;
	}

	public void signOut(WebActionUtility wLib,WebDriver driver)
	{
		wLib.mouseOverOnElement(driver, signOutLookupImg);
		signoutLink.click();		
	}
}
