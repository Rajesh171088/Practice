package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuoteInfoPage {
	@FindBy(xpath = "//td[text()='Subject']/following-sibling::td[@id='mouseArea_Subject']")
	private WebElement subjectDisplayed;
	
	@FindBy(xpath = "//td[text()='Opportunity Name']/following-sibling::td[@align='left']")
	private WebElement opportunityDisplayed;
	
	@FindBy(xpath = "//td[text()='Contact Name']/following-sibling::td[@align='left']")
	private WebElement contactDisplayed;
	
	@FindBy(xpath = "//td[text()='Organization Name']/following-sibling::td[@align='left']")
	private WebElement orgDisplayed;
	
	@FindBy(xpath = "//b[text()='Grand Total']/../following-sibling::td")
	private WebElement grandTotalDisplayed;
	
	public QuoteInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectDisplayed() {
		return subjectDisplayed;
	}

	public WebElement getOpportunityDisplayed() {
		return opportunityDisplayed;
	}

	public WebElement getContactDisplayed() {
		return contactDisplayed;
	}

	public WebElement getOrgDisplayed() {
		return orgDisplayed;
	}

	public WebElement getGrandTotalDisplayed() {
		return grandTotalDisplayed;
	}
	
	
}
