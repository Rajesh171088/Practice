package com.greentrade.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentrade.genericutility.WebActionUtility;

public class SearchCampaignPage {
	@FindBy(id="search_txt")
	private WebElement searchTbx;

	@FindBy(name="search_field")
	private WebElement indropDwn;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
		
	
	public SearchCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchedCampaign(WebDriver driver, String text) {
		return driver.findElement(By.xpath("//a[text()='"+text+"']"));
	}
	
	public void searchAndSelectCampaign(WebDriver driver, String campaignName) throws Throwable {
		searchTbx.sendKeys(campaignName);
		WebActionUtility wLib = new WebActionUtility();
		wLib.moveToElementAndPause(driver, searchNowBtn);
		searchNowBtn.click();
		Thread.sleep(2000);
		getSearchedCampaign(driver, campaignName).click();
	}
	
}
