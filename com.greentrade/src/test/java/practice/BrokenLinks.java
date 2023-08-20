package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	@Test
	public void findBrokenLinks() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		ArrayList<String> brokenLinks = new ArrayList<String>();
		for (WebElement eachLink :links ) {
			String link = eachLink.getAttribute("href");
			URL url;
			int statusCode=0;
			try {
				url = new URL(link);
				URLConnection connection = url.openConnection();
				HttpURLConnection httpConnection = (HttpURLConnection)connection;
				statusCode = httpConnection.getResponseCode();
				if (statusCode>=400) {
					brokenLinks.add(link+" "+statusCode);
				}
			} catch (Exception e) {
				continue;
			}
		}
		System.out.println(brokenLinks.size());
		for (String eachBLink : brokenLinks) {
			System.out.println(eachBLink);
		}
		driver.close();
	}
}

















