package com.greentrade.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentrade.genericutility.WebActionUtility;

public class SearchContactPage {
	@FindBy(id="search_txt")
	private WebElement searchTbx;

	@FindBy(name="search_field")
	private WebElement indropDwn;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
		
	
	public SearchContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchTextBox() {
		return searchTbx;
	}

	public WebElement getIndropDwn() {
		return indropDwn;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public WebElement getSearchedContact(WebDriver driver, String text) {
		return driver.findElement(By.xpath("//a[text()=' "+text+"']"));
	}
	
	public void searchAndSelectContact(WebDriver driver, String lastName) throws Throwable {
		searchTbx.sendKeys(lastName);
		WebActionUtility wLib = new WebActionUtility();
		wLib.moveToElementAndPause(driver, searchNowBtn);
		searchNowBtn.click();
		Thread.sleep(2000);
		getSearchedContact(driver, lastName).click();
	}
}
