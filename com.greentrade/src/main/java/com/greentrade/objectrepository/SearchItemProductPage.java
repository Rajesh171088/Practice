package com.greentrade.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greentrade.genericutility.WebActionUtility;

public class SearchItemProductPage {
	@FindBy(id="search_txt")
	private WebElement searchTbx;

	@FindBy(name="search_field")
	private WebElement indropDwn;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
		
	
	public SearchItemProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getSearchTbx() {
		return searchTbx;
	}


	public WebElement getIndropDwn() {
		return indropDwn;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}


	public WebElement getSearchedProduct(WebDriver driver, String text) {
		return driver.findElement(By.xpath("//a[text()='"+text+"']"));
	}
	
	public void searchAndSelectProduct(WebDriver driver, String productName) throws Throwable {
		searchTbx.sendKeys(productName);
		WebActionUtility wLib = new WebActionUtility();
		wLib.moveToElementAndPause(driver, searchNowBtn);
		searchNowBtn.click();
		Thread.sleep(2000);
		getSearchedProduct(driver, productName).click();
	}
}
