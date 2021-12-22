package december21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceDelete {
	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get("https://login.salesforce.com/");
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the sales option
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and...']")).click();
		//click on the opportunities tab
		WebElement opp = driver.findElement(By.xpath("(//a[@title='Opportunities']/span)"));
		driver.executeScript("arguments[0].click();", opp);
		//search the name in search  bar
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("salesforce Automation by pradeepkumar N",Keys.ENTER);
		Thread.sleep(5000);
		//click the dropdown
		driver.findElement(By.xpath("(//span[text()='Show Actions']/parent::span)[1]")).click();
		Thread.sleep(5000);
		//click the delete option 
		driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		WebElement name = driver.findElement(By.xpath("//a[text()='Salesforce Automation by Pradeepkumar N']"));
		boolean enabled = name.isEnabled();
		System.out.println(enabled);
		
		
		
		
		
		
		
		
		
	}

}
