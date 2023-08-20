package com.greentrade.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateQuotePage {
	@FindBy(name = "subject")
	private WebElement subjectTbx;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='potential_name']/following-sibling::img")
	private WebElement selectOpportunityLookupImg;
	
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img")
	private WebElement selectContactLookupImg;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgLookupImg;
	
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billingAddressTbx;
	
	@FindBy(xpath = "//b[text()='Copy Billing address']/preceding-sibling::input")
	private WebElement copyBillingAddressRadioBtn;
	
	@FindBy(id = "searchIcon1")
	private WebElement selectItemProductLookupImg;
	
	@FindBy(id = "qty1")
	private WebElement qtyTbx;
	
	@FindBy(id = "listPrice1")
	private WebElement listPriceTbx;
	
	
	public CreateQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSubjectTbx() {
		return subjectTbx;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getSelectOpportunityLookupImg() {
		return selectOpportunityLookupImg;
	}


	public WebElement getSelectContactLookupImg() {
		return selectContactLookupImg;
	}


	public WebElement getSelectOrgLookupImg() {
		return selectOrgLookupImg;
	}


	public WebElement getBillingAddressTbx() {
		return billingAddressTbx;
	}


	public WebElement getCopyBillingAddressRadioBtn() {
		return copyBillingAddressRadioBtn;
	}


	public WebElement getSelectItemProductLookupImg() {
		return selectItemProductLookupImg;
	}


	public WebElement getQtyTbx() {
		return qtyTbx;
	}


	public WebElement getListPriceTbx() {
		return listPriceTbx;
	}
	
	
	
}
