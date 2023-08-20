package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	@FindBy(name = "campaignname")
	private WebElement campaignNameTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement selectProductLookupImg;
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectProductLookupImg() {
		return selectProductLookupImg;
	}

	public void setSelectProductLookupImg(WebElement selectProductLookupImg) {
		this.selectProductLookupImg = selectProductLookupImg;
	}

	public WebElement getCampaignNameTbx() {
		return campaignNameTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
}
