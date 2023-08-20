package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSettingPage {
	@FindBy(partialLinkText = "Tooltip Management")
	private WebElement tooltipManagementLink;
	
	@FindBy(id="pick_field")
	private WebElement selectFieldDropDown;
	
	@FindBy(xpath="(//td[contains(text(),'Product')]/preceding-sibling::td/input)[position()=last()]")
	private WebElement productCheckBox;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	
	public AdminSettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getTooltipManagementLink() {
		return tooltipManagementLink;
	}


	public WebElement getSelectFieldDropDown() {
		return selectFieldDropDown;
	}


	public WebElement getProductCheckBox() {
		return productCheckBox;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
