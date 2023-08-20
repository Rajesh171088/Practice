package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignsLookupImg;
	
	@FindBy(xpath = "//img[@title='Campaigns Settings']")
	private WebElement campaignsSettingLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement searchForTbx;
	
	@FindBy(xpath = "//b[text()='In']/../..//select[@name='search_field']")
	private WebElement inDropdown;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[@title='Campaigns']")
	private WebElement searchedCampaignLink;
	
	@FindBy(xpath="//div[@class='tooltipClass']")
	private WebElement toolTip;
	
	public WebElement getToolTip() {
		return toolTip;
	}
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	

	public void getCreateCampaignsLookupImg() {
		 createCampaignsLookupImg.click();
	}

	public WebElement getCampaignsSettingLookupImg() {
		return campaignsSettingLookupImg;
	}

	public WebElement getSearchForTbx() {
		return searchForTbx;
	}

	public WebElement getInDropdown() {
		return inDropdown;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSearchedCampaignLink() {
		return searchedCampaignLink;
	}

	
	
	
	
}
