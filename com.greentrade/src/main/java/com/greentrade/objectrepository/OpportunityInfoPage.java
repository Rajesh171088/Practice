package com.greentrade.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	@FindBy(xpath = "//td[text()='Opportunity Name']/following-sibling::td[@id='mouseArea_Opportunity Name']")
	private WebElement createdOpportunity;
	
	@FindBy(xpath = "//td[text()='Campaign Source']/following-sibling::td[1]")
	private WebElement createdCampaign;
	
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getCreatedOpportunity() {
		return createdOpportunity;
	}


	public WebElement getCreatedCampaign() {
		return createdCampaign;
	}


	public WebElement createdOrg(WebDriver driver, String orgName) {
		return driver.findElement(By.linkText(orgName));
	}
	
}
