package com.greentrade.vendor;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.greentrade.genericutility.BaseClass;
import com.greentrade.genericutility.ExcelUtlity;
import com.greentrade.objectrepository.CampaignsPage;
import com.greentrade.objectrepository.CreateCampaignPage;
import com.greentrade.objectrepository.CreateOpportunityPage;
import com.greentrade.objectrepository.CreateOrganizationPage;
import com.greentrade.objectrepository.CreateProductPage;
import com.greentrade.objectrepository.CreateVendorPage;
import com.greentrade.objectrepository.HomePage;
import com.greentrade.objectrepository.OpportunitiesPage;
import com.greentrade.objectrepository.OpportunityInfoPage;
import com.greentrade.objectrepository.OrganizationsPage;
import com.greentrade.objectrepository.ProductsPage;
import com.greentrade.objectrepository.SearchCampaignPage;
import com.greentrade.objectrepository.SearchOrgPage;
import com.greentrade.objectrepository.SearchProductPage;
import com.greentrade.objectrepository.SearchVendorPage;
import com.greentrade.objectrepository.VendorsPage;
@Listeners(com.greentrade.genericutility.ListenerImplementation.class)
public class CreateNewOpportunityTest extends BaseClass {
	@Test
	public void createNewOpportunityTest() throws Throwable {
		/*Create Random Number*/
		int randomNum=jLib.getRandomNumber();	
		/*Read required Data from file*/
		ExcelUtlity eLib = new ExcelUtlity();
		String testScriptdataFilePath = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String vendorName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "vendor", "TC_33","Vendor Name")+randomNum;
		String productName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "product", "TC_33","Product Name")+randomNum;
		String orgName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "org", "TC_33","Organization Name")+randomNum;
		String campaignName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "campaign", "TC_33","Campaign Name")+randomNum;
		String opportunityName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "opportunity", "TC_33","Opportunity Name")+randomNum;
	
		/*Create Vendor*/
		HomePage homePage=new HomePage(driver);
		wLib.mouseOverOnElement(driver, homePage.getMoreLink());
		homePage.getVendorsLink().click();
		VendorsPage vendorsPage=new VendorsPage(driver);
		vendorsPage.getCreateVendorLookupImg();
		CreateVendorPage createVendorPage=new CreateVendorPage(driver);
		createVendorPage.createVendor(vendorName);
		System.out.println("Vendor Created Successfully..!");
		Assert.fail();
		
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
		
		/*Create Organization*/
		homePage.getOrganizationsLink().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganizationLookupImg();
		CreateOrganizationPage createOrganizationPage = new CreateOrganizationPage(driver);
		createOrganizationPage.getOrgNameTbx().sendKeys(orgName);
		createOrganizationPage.getSaveBtn().click();
		System.out.println("Organization created successfully..!");
		Thread.sleep(2000);
		
		/*Create Opportunity*/
		homePage.getOpportunitiesLink().click();
		OpportunitiesPage opportunitiesPage = new OpportunitiesPage(driver);
		opportunitiesPage.getCreateOpportunitiesLookupImg();
		CreateOpportunityPage createOpportunityPage = new CreateOpportunityPage(driver);
		createOpportunityPage.getOpportunityNameTbx().sendKeys(opportunityName);
		createOpportunityPage.getSelectOrgLookupImg().click();
		wLib.swithToWindow(driver, "Accounts");
		SearchOrgPage searchOrgPage = new SearchOrgPage(driver);
		searchOrgPage.searchAndSelectOrg(driver, orgName);
		wLib.swithToWindow(driver, "Potentials");
		createOpportunityPage.getSelectCampaignLookupImg().click();
		wLib.swithToWindow(driver, "Campaign");
		SearchCampaignPage searchCampaignPage = new SearchCampaignPage(driver);
		searchCampaignPage.searchAndSelectCampaign(driver, campaignName);
		wLib.swithToWindow(driver, "Potentials");
		createOpportunityPage.getSaveBtn().click();
		System.out.println("Opportunity Created successfully..!");
		
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);
		String actualCampaign = oip.getCreatedCampaign().getText().trim();
		String expectedCampaign = campaignName;
		
		String actualOpportunity=oip.getCreatedOpportunity().getText().trim();
		String expectedOpportunity = opportunityName;
		
		String actualOrg=oip.createdOrg(driver, orgName).getText().trim();
		String expectedOrg = orgName;
		
		System.out.println("actualCampaign: "+actualCampaign);
		System.out.println("expectedCampaign: "+expectedCampaign);
		
		System.out.println("actualOpportunity: "+actualOpportunity);
		System.out.println("expectedOpportunity: "+expectedOpportunity);
		
		System.out.println("actualOrg: "+actualOrg);
		System.out.println("expectedOrg: "+expectedOrg);
		
		Assert.assertTrue(actualCampaign.equals(expectedCampaign) && actualOpportunity.equals(expectedOpportunity)&& actualOrg.equals(expectedOrg), "Opportunity is not created with requied details..!");
		Reporter.log("Opportunity is created successfully with requied details..!",true);
		
	}

}
