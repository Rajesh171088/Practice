package com.greentrade.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.greentrade.genericutility.BaseClass;
import com.greentrade.genericutility.ExcelUtlity;
import com.greentrade.genericutility.FileUtlity;
import com.greentrade.genericutility.JavaUtlity;
import com.greentrade.genericutility.WebActionUtility;
import com.greentrade.objectrepository.AdminSettingPage;
import com.greentrade.objectrepository.CampaignsPage;
import com.greentrade.objectrepository.CreateCampaignPage;
import com.greentrade.objectrepository.CreateProductPage;
import com.greentrade.objectrepository.CreateVendorPage;
import com.greentrade.objectrepository.HomePage;
import com.greentrade.objectrepository.LoginPage;
import com.greentrade.objectrepository.ProductsPage;
import com.greentrade.objectrepository.SearchProductPage;
import com.greentrade.objectrepository.SearchVendorPage;
import com.greentrade.objectrepository.VendorsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTooltipTextOfCampaignTest extends BaseClass{
	@Test
	public void verifyTooltipTextOfCampaignTest() throws Throwable {
		/*Create Random Number*/
		int randomNum=jLib.getRandomNumber();	
		/*Read required Data from file*/
		ExcelUtlity eLib = new ExcelUtlity();
		String testScriptdataFilePath = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String vendorName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "vendor", "TC_35","Vendor Name")+randomNum;
		String productName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "product", "TC_35","Product Name")+randomNum;
		String campaignName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "campaign", "TC_35","Campaign Name")+randomNum;


		/*Create Vendor*/
		HomePage homePage=new HomePage(driver);
		wLib.mouseOverOnElement(driver, homePage.getMoreLink());
		homePage.getVendorsLink().click();
		VendorsPage vendorsPage=new VendorsPage(driver);
		vendorsPage.getCreateVendorLookupImg();
		CreateVendorPage createVendorPage=new CreateVendorPage(driver);
		createVendorPage.createVendor(vendorName);
		System.out.println("Vendor Created Successfully..!");

		/*Create Product*/
		homePage.getProductsLink().click();
		ProductsPage productsPage=new ProductsPage(driver);
		productsPage.getCreateProductsLookupImg();
		CreateProductPage createProductPage=new CreateProductPage(driver);
		createProductPage.getProductNameTbx().sendKeys(productName);
		createProductPage.getSelectVendorLookupImg().click();
		wLib.swithToWindow(driver, "Vendors");
		SearchVendorPage searchVendorPage=new SearchVendorPage(driver);
		searchVendorPage.searchAndSelectVendor(driver, vendorName);	
		wLib.swithToWindow(driver, "Product");
		createProductPage.getSaveBtn().click();
		System.out.println("Product Created Successfully..!");

		/*Create new Campaign*/
		homePage.getMoreLink().click();
		homePage.getCampaignsLink().click();
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		campaignsPage.getCreateCampaignsLookupImg();
		CreateCampaignPage createCampaignPage = new CreateCampaignPage(driver);
		createCampaignPage.getCampaignNameTbx().sendKeys(campaignName);
		createCampaignPage.getSelectProductLookupImg().click();
		wLib.swithToWindow(driver, "Products");
		SearchProductPage searchProductPage = new SearchProductPage(driver);
		searchProductPage.searchAndSelectProduct(driver, productName);
		wLib.swithToWindow(driver, "Campaign");
		createCampaignPage.getSaveBtn().click();
		System.out.println("Campaign Created Successfully..!");
		
		/*Change Campaign setting*/
		campaignsPage.getCampaignsSettingLookupImg().click();
		AdminSettingPage adminSettingPage = new AdminSettingPage(driver);
		adminSettingPage.getTooltipManagementLink().click();	
		WebElement selectfield = adminSettingPage.getSelectFieldDropDown();
		wLib.select(selectfield, "Campaign Name");
		Thread.sleep(2000);
		if (adminSettingPage.getProductCheckBox().isSelected()) {
			System.out.println("Product check box is already selected");
		}else {
			adminSettingPage.getProductCheckBox().click();
		}
		adminSettingPage.getSaveBtn().click();
		homePage.getMoreLink().click();
		homePage.getCampaignsLink().click();
		campaignsPage.getSearchForTbx().sendKeys(campaignName);
		WebElement inDropDown = campaignsPage.getInDropdown();
		wLib.select(inDropDown, "Campaign Name");
		campaignsPage.getSearchNowBtn().click();

		WebElement searchedCampaign = campaignsPage.getSearchedCampaignLink();
		wLib.mouseOverOnElement(driver, searchedCampaign);
		Thread.sleep(2000);
		wLib.waitForElement(driver, campaignsPage.getToolTip());
		WebElement ttip=campaignsPage.getToolTip();
		String actualText = ttip.getText();
		System.out.println(actualText);
		String productText=productName;
		System.out.println("actual text: "+actualText);
		System.out.println("Product text: "+productText);
		
		Assert.assertTrue(actualText.contains(productText), "Tooltip text for campaign is not verified Fail");
		Reporter.log("Tooltip text for campaign is verified PASS", true);
	}
}













