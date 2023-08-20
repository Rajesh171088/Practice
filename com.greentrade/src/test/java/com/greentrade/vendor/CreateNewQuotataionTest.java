package com.greentrade.vendor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.greentrade.genericutility.BaseClass;
import com.greentrade.genericutility.ExcelUtlity;
import com.greentrade.objectrepository.CampaignsPage;
import com.greentrade.objectrepository.ContactsPage;
import com.greentrade.objectrepository.CreateCampaignPage;
import com.greentrade.objectrepository.CreateContactPage;
import com.greentrade.objectrepository.CreateOpportunityPage;
import com.greentrade.objectrepository.CreateOrganizationPage;
import com.greentrade.objectrepository.CreateProductPage;
import com.greentrade.objectrepository.CreateQuotePage;
import com.greentrade.objectrepository.CreateVendorPage;
import com.greentrade.objectrepository.HomePage;
import com.greentrade.objectrepository.OpportunitiesPage;
import com.greentrade.objectrepository.OrganizationsPage;
import com.greentrade.objectrepository.ProductsPage;
import com.greentrade.objectrepository.QuoteInfoPage;
import com.greentrade.objectrepository.QuotesPage;
import com.greentrade.objectrepository.SearchCampaignPage;
import com.greentrade.objectrepository.SearchContactPage;
import com.greentrade.objectrepository.SearchItemProductPage;
import com.greentrade.objectrepository.SearchOpportunityPage;
import com.greentrade.objectrepository.SearchOrgPage;
import com.greentrade.objectrepository.SearchProductPage;
import com.greentrade.objectrepository.SearchVendorPage;
import com.greentrade.objectrepository.VendorsPage;

public class CreateNewQuotataionTest extends BaseClass {
	@Test
	public void createNewQuotataionTest() throws Throwable {
		int randomNum=jLib.getRandomNumber();	
		/*Read required Data from file*/
		ExcelUtlity eLib = new ExcelUtlity();
		String testScriptdataFilePath = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String vendorName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "vendor", "TC_17","Vendor Name")+randomNum;
		String productName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "product", "TC_17","Product Name")+randomNum;
		String orgName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "org", "TC_17","Organization Name")+randomNum;
		String campaignName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "campaign", "TC_17","Campaign Name")+randomNum;
		String opportunityName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "opportunity", "TC_17","Opportunity Name")+randomNum;
		String lastName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "contact", "TC_17","Last Name")+randomNum;
		String subject = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "quotes", "TC_17","Subject")+randomNum;
		String billingAdd = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "quotes", "TC_17","Billing Address")+randomNum;
		String qty = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "quotes", "TC_17","Qty");
		String listPrice = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "quotes", "TC_17","List Price");
		String grandTotal = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "quotes", "TC_17","Grand Total");
		
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
		
		/*Create Organization*/
		homePage.getOrganizationsLink().click();
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrganizationLookupImg();
		CreateOrganizationPage createOrganizationPage = new CreateOrganizationPage(driver);
		createOrganizationPage.getOrgNameTbx().sendKeys(orgName);
		createOrganizationPage.getSaveBtn().click();
		System.out.println("Organization created successfully..!");
		Thread.sleep(2000);
		
		/*Create Contact*/
		homePage.getContactsLink().click();
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactLookupImg();
		CreateContactPage createContactPage = new CreateContactPage(driver);
		createContactPage.getLastNameTbx().sendKeys(lastName);
		createContactPage.getSelectOrgLookupImg().click();
		wLib.swithToWindow(driver, "Accounts");
		SearchOrgPage searchOrgPage1 = new SearchOrgPage(driver);
		searchOrgPage1.searchAndSelectOrg(driver, orgName);
		wLib.swithToWindow(driver, "Contacts");
		createContactPage.getSaveBtn().click();
		System.out.println("Contact Created successfully..!");
		
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
		
		/*Create Quote*/
		homePage.getMoreLink().click();
		homePage.getQotesLink().click();
		QuotesPage quotesPage = new QuotesPage(driver);
		quotesPage.getCreateQuotesLookupImg();
		CreateQuotePage createQuotePage = new CreateQuotePage(driver);
		createQuotePage.getSubjectTbx().sendKeys(subject);
		
		//Enter opportunity
		createQuotePage.getSelectOpportunityLookupImg().click();
		wLib.swithToWindow(driver, "Potentials");
		SearchOpportunityPage searchOpportunityPage = new SearchOpportunityPage(driver);
		searchOpportunityPage.searchAndSelectOpportunity(driver, opportunityName);
		wLib.swithToWindow(driver, "Quotes");
		
		//Enter contact
		createQuotePage.getSelectContactLookupImg().click();
		wLib.swithToWindow(driver, "Contacts");
		SearchContactPage searchContactPage = new SearchContactPage(driver);
		searchContactPage.searchAndSelectContact(driver, lastName);
		wLib.dismissAlert(driver);
		wLib.swithToWindow(driver, "Quotes");
		
		//Enter org
		createQuotePage.getSelectOrgLookupImg().click();
		wLib.swithToWindow(driver, "Accounts");
		SearchOrgPage searchOrgPage2 = new SearchOrgPage(driver);
		searchOrgPage2.searchAndSelectOrg(driver, orgName);
		wLib.dismissAlert(driver);
		wLib.swithToWindow(driver, "Quotes");
		
		//Enter Billing and shipping Address
		createQuotePage.getBillingAddressTbx().sendKeys(billingAdd);
		createQuotePage.getCopyBillingAddressRadioBtn().click();
		
		//Enter Item Details
		createQuotePage.getSelectItemProductLookupImg().click();
		wLib.swithToWindow(driver, "Products");
		SearchItemProductPage searchItemProductPage = new SearchItemProductPage(driver);
		searchItemProductPage.searchAndSelectProduct(driver, productName);
		wLib.swithToWindow(driver, "Quotes");
		//Qty
		createQuotePage.getQtyTbx().sendKeys(qty);
		//list price
		createQuotePage.getListPriceTbx().clear();
		createQuotePage.getListPriceTbx().sendKeys(listPrice);
		createQuotePage.getSaveBtn().click();
		
		//validation
		QuoteInfoPage quoteInfoPage = new QuoteInfoPage(driver);
		String actualSubject = quoteInfoPage.getSubjectDisplayed().getText().trim();
		String expectedSubject = subject;
		System.out.println("actualSubject: "+actualSubject);
		System.out.println("expectedSubject: "+expectedSubject);
		Assert.assertTrue(actualSubject.equals(expectedSubject), "Quotation subject displayed is not correct");
		
		String actualContact= quoteInfoPage.getContactDisplayed().getText().trim();
		String expectedContact = lastName;
		System.out.println("actualContact: "+actualContact);
		System.out.println("expectedContact: "+expectedContact);
		Assert.assertTrue(actualContact.equals(actualContact), "Quotation contact displayed is not correct");
		
		String actualOpportunity= quoteInfoPage.getOpportunityDisplayed().getText().trim();
		String expectedOpportunity = opportunityName;
		System.out.println("actualOpportunity: "+actualOpportunity);
		System.out.println("expectedOpportunity: "+expectedOpportunity);
		Assert.assertTrue(actualOpportunity.equals(expectedOpportunity), "Quotation Opportunity displayed is not correct");
		
		String actualOrg= quoteInfoPage.getOrgDisplayed().getText().trim();
		String expectedOrg = orgName;
		System.out.println("actualOrg: "+actualOrg);
		System.out.println("expectedOrg: "+expectedOrg);
		Assert.assertTrue(actualOrg.equals(expectedOrg), "Quotation Organization displayed is not correct");
		
		String actualGrandTotal= quoteInfoPage.getGrandTotalDisplayed().getText().trim();
		String expectedGrandTotal= grandTotal;
		System.out.println("actualGrandTotal: "+actualGrandTotal);
		System.out.println("expectedGrandTotal: "+expectedGrandTotal);
		Assert.assertTrue(actualGrandTotal.equals(expectedGrandTotal), "Quotation Grand Total displayed is not correct");
		Reporter.log("Quotation is created successfully with requied detais and it is varified", true);
	}
}
