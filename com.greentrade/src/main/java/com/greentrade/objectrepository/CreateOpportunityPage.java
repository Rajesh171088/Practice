package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunityPage {
	@FindBy(name="potentialname")
	private WebElement opportunityNameTbx;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	private WebElement selectOrgLookupImg;
	
	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img")
	private WebElement selectCampaignLookupImg;
	
	
	public CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}


	public WebElement getOpportunityNameTbx() {
		return opportunityNameTbx;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getSelectOrgLookupImg() {
		return selectOrgLookupImg;
	}


	public WebElement getSelectCampaignLookupImg() {
		return selectCampaignLookupImg;
	}
	
	
}
