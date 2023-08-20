package com.greentrade.genericutility;

import java.sql.SQLException; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.greentrade.objectrepository.HomePage;
import com.greentrade.objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public WebDriver driver;
public static WebDriver sdriver;

	
	//Create instance of all generic utilities
	public FileUtlity fLib=new FileUtlity();
	public WebActionUtility wLib=new WebActionUtility();
	public ExcelUtlity eLib=new ExcelUtlity();
	public JavaUtlity jLib=new JavaUtlity();
	public DataBaseUtility dbLib=new DataBaseUtility();
	
	@Parameters("browser")
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void connectToDataBase()
	{
		try {
			dbLib.connectDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected to database...!");
	}
	
	//@Parameters("browser")
	@BeforeClass
	public void OpenBrowser() throws Throwable
	{
		String commonDataFilePath=fLib.getFilePathFromPropertiesFile("commonDataFilePath");
		
		String browser = System.getProperty("browser", fLib.getDataFromProperties(commonDataFilePath, "browser"));
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}		
		driver.manage().window().maximize();
		sdriver = driver;
		wLib.waitForElementInDOM(driver);
		System.out.println("The "+browser+" browser is launched...!");
	}	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void login() throws Throwable
	{
		String commonDataFilePath=fLib.getFilePathFromPropertiesFile("commonDataFilePath");
		String URL=fLib.getDataFromProperties(commonDataFilePath, "url");
		String USERNAME=fLib.getDataFromProperties(commonDataFilePath, "username");
		String PASSWORD=fLib.getDataFromProperties(commonDataFilePath, "password");
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.setLogin(USERNAME, PASSWORD);
		
		System.out.println("Logged in Succesfully...!");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logout()
	{
		HomePage homePage=new HomePage(driver);
		homePage.signOut(wLib, driver);
		System.out.println("Logged Out...!");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("The browser is closed...!");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void closeDBConnection() throws SQLException
	{
		dbLib.closeDB();
		System.out.println("Database Closed..!");
	}
}
