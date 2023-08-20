package com.greentrade.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentrade.genericutility.WebActionUtility;

public class SearchOrgPage {
	@FindBy(id="search_txt")
	private WebElement searchTbx;

	@FindBy(name="search_field")
	private WebElement indropDwn;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
		
	
	public SearchOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchedOrg(WebDriver driver, String text) {
		return driver.findElement(By.xpath("//a[text()='"+text+"']"));
	}
	
	public void searchAndSelectOrg(WebDriver driver, String orgName) throws Throwable {
		searchTbx.sendKeys(orgName);
		WebActionUtility wLib = new WebActionUtility();
		wLib.moveToElementAndPause(driver, searchNowBtn);
		searchNowBtn.click();
		Thread.sleep(2000);
		getSearchedOrg(driver, orgName).click();
	}
	
}
