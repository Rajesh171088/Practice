package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	
	public static void main(String[] args) throws AWTException, Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.doubleClick().perform();
//		Robot robot = new Robot();
//		robot.mouseMove(50,50);
//		actions.click().build().perform();
//		robot.mouseMove(200,70);
//		actions.click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		/*select from city*/
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		/*Select to city*/
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[text()='Goa - Dabolim Airport, India']")).click();
		
		/*Select Date*/
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		
	}
}
