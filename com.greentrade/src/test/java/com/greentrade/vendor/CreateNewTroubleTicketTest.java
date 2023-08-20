package com.greentrade.vendor;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.greentrade.genericutility.BaseClass;
import com.greentrade.genericutility.ExcelUtlity;
import com.greentrade.objectrepository.ContactsPage;
import com.greentrade.objectrepository.CreateContactPage;
import com.greentrade.objectrepository.CreateOrganizationPage;
import com.greentrade.objectrepository.CreateProductPage;
import com.greentrade.objectrepository.CreateTroubleTicketPage;
import com.greentrade.objectrepository.CreateVendorPage;
import com.greentrade.objectrepository.HomePage;
import com.greentrade.objectrepository.OrganizationsPage;
import com.greentrade.objectrepository.ProductsPage;
import com.greentrade.objectrepository.SearchContactPage;
import com.greentrade.objectrepository.SearchOrgPage;
import com.greentrade.objectrepository.SearchProductPage;
import com.greentrade.objectrepository.SearchVendorPage;
import com.greentrade.objectrepository.TroubleTicketInfoPage;
import com.greentrade.objectrepository.TroubleTicketsPage;
import com.greentrade.objectrepository.VendorsPage;

public class CreateNewTroubleTicketTest extends BaseClass {
	@Test
	public void createNewTroubleTicketTest() throws Throwable {
		/*Create Random Number*/
		int randomNum=jLib.getRandomNumber();	
		/*Read the test data from excel file*/
		ExcelUtlity eLib = new ExcelUtlity();
		String testScriptdataFilePath = fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String vendorName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "vendor", "TC_34","Vendor Name")+randomNum;
		String productName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "product", "TC_34","Product Name")+randomNum;
		String orgName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "org", "TC_34","Organization Name")+randomNum;
		String lastName = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "contact", "TC_34","Last Name")+randomNum;
		String title = eLib.getDataFromExcelBasedTestId(testScriptdataFilePath, "troubleticket", "TC_34","Title")+randomNum;
		
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
		SearchOrgPage searchOrgPage = new SearchOrgPage(driver);
		searchOrgPage.searchAndSelectOrg(driver, orgName);
		wLib.swithToWindow(driver, "Contacts");
		createContactPage.getSaveBtn().click();
		System.out.println("Contact Created successfully..!");
		
		/*Create trouble ticket*/
		homePage.getTroubleTicketsLink().click();
		TroubleTicketsPage troubleTicketsPage = new TroubleTicketsPage(driver);
		troubleTicketsPage.getCreateTroubleTicketsLookupImg();
		CreateTroubleTicketPage createTroubleTicketPage = new CreateTroubleTicketPage(driver);
		createTroubleTicketPage.getTitleTbx().sendKeys(title);
		/*Select Contact*/
		createTroubleTicketPage.getSelectContactLookupImg().click();
		wLib.swithToWindow(driver, "Contacts");
		SearchContactPage searchContactPage = new SearchContactPage(driver);
		searchContactPage.searchAndSelectContact(driver, lastName);
		wLib.swithToWindow(driver, "Support");
		/*Select Product*/
		createTroubleTicketPage.getSelectProductLookupImg().click();
		wLib.swithToWindow(driver, "Products");
		SearchProductPage searchProductPage = new SearchProductPage(driver);
		searchProductPage.searchAndSelectProduct(driver, productName);
		wLib.swithToWindow(driver, "Support");
		createTroubleTicketPage.getSaveBtn().click();
		System.out.println("Trouble Ticket is created successfully..!");
		
		TroubleTicketInfoPage troubleTicketInfoPage = new TroubleTicketInfoPage(driver);
		String actualTitle=troubleTicketInfoPage.getTitledisplayed().getText().trim();
		String expectedTitle = title;
		
		String actualContact=troubleTicketInfoPage.getContactdisplayed().getText().trim();
		String expectedContact = lastName;
		
		String actualProduct=troubleTicketInfoPage.getProductdisplayed().getText().trim();
		String expectedProduct = productName;
		
		System.out.println("actualTitle: "+actualTitle);
		System.out.println("expectedTitle: "+expectedTitle);
		
		System.out.println("actualContact: "+actualContact);
		System.out.println("expectedContact: " +expectedContact);
		
		System.out.println("actualProduct: "+actualProduct);
		System.out.println("expectedProduct: "+expectedProduct);
		
		Assert.assertTrue(actualTitle.equals(expectedTitle) && actualContact.equals(expectedContact) && actualProduct.equals(expectedProduct), "Trouble Ticket is not created with requied details");
		Reporter.log("Trouble Ticket is created with requied details", true);
	}
}
